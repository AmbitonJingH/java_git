package book.service;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 16:27
 * @version 1.0
 */

import book.pojo.User;

public interface UserService {
    User login(String uname,String pwd);
    void regist(User user);
    User getUser(String uname);
}
