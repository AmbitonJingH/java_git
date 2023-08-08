package book.dao.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/7/31 15:42
 * @version 1.0
 */

import book.dao.OrderItemDAO;
import book.pojo.OrderItem;
import com.atguigu.myssm.basedao.BaseDAO;

public class OrderItemImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
    }
}
