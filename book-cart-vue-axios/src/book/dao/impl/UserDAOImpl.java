package book.dao.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 16:25
 * @version 1.0
 */

import book.dao.UserDAO;
import book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return load("select * from t_user where uname=? and pwd=?",uname,pwd);
    }

    @Override
    public void addUser(User user) {
        executeUpdate("insert into t_user values(0,?,?,?,0)",user.getUname(),user.getPwd(),user.getEmail());
    }

    @Override
    public User getUser(String uname) {
        return load("select * from t_user where uname=?",uname);
    }
}
