package book.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/7/31 15:36
 * @version 1.0
 */

import book.pojo.OrderItem;

public interface OrderItemDAO {
    //添加订单项
    void addOrderItem(OrderItem orderItem);
}
