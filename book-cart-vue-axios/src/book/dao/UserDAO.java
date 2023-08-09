package book.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 16:24
 * @version 1.0
 */

import book.pojo.User;

public interface UserDAO {
    User getUser(String uname,String pwd);
    void addUser(User user);
    User getUser(String uname);
}
