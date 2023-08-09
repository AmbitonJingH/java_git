package book.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/7/31 15:35
 * @version 1.0
 */

import book.pojo.OrderBean;
import book.pojo.User;

import java.util.List;

public interface OrderBeanDAO {
    //添加订单
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
    Integer getOrderTotalBookCount(OrderBean orderBean);
}
