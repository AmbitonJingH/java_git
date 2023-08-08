package book.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 16:28
 * @version 1.0
 */

import book.dao.UserDAO;
import book.pojo.User;
import book.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        return userDAO.getUser(uname);
    }
}
