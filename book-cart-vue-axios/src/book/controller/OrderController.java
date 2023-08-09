package book.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/7/31 16:45
 * @version 1.0
 */

import book.pojo.OrderBean;
import book.pojo.User;
import book.service.OrderBeanService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderController {
    private OrderBeanService orderBeanService;

    //结账
    public String checkOut(HttpSession session){
        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        int year = now.getYear();
        int month = now.getMonth();
        int day = now.getDate();
        int hour = now.getHours();
        int min = now.getMinutes();
        int sec = now.getSeconds();
        orderBean.setOrderNo(UUID.randomUUID().toString()+"_"+year+month+day+hour+min+sec);
        orderBean.setOrderDate(now);

        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderBeanService.addOrderBean(orderBean);
        return "index";
    }

    public String getOrderList(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderBeanService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser",user);
        return "order/order";
    }
}
