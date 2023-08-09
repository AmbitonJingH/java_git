package book.service;
/*
 * @author  AmbitionJingH
 * @date  2023/7/31 16:12
 * @version 1.0
 */

import book.pojo.OrderBean;
import book.pojo.User;

import java.util.List;

public interface OrderBeanService {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
}
