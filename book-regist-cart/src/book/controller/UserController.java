package book.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 16:21
 * @version 1.0
 */

import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;
import book.service.CartItemService;
import book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController {
    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session){
        User user = userService.login(uname, pwd);
        if(user!=null){
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }
        return "user/login";
    }


    public String regist(String verifyCode, String uname, String pwd, String email, HttpSession session, HttpServletResponse response) throws IOException {
        Object kaptchaCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
        if(kaptchaCodeObj==null || !verifyCode.equals(kaptchaCodeObj)){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script language='javascript'>alert('验证码不正确!');</script>");
            return "user/regist";
        }else {
            if(verifyCode.equals(kaptchaCodeObj)){
                userService.regist(new User(uname,pwd,email,0));
                return "user/login";
            }
        }
        return "user/login";
    }

    public String ckUname(String uname){
        User user = userService.getUser(uname);
        if(user!=null){
            //表示用户名已存在不可以注册
            return "json:{'uname':'1'}";
        }else {
            //表示用户名未被注册 可以注册
            return "json:{'uname':'0'}";
        }
    }
}
