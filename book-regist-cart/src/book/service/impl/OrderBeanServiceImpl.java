package book.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/7/31 16:13
 * @version 1.0
 */

import book.dao.CartItemDAO;
import book.dao.OrderBeanDAO;
import book.dao.OrderItemDAO;
import book.pojo.CartItem;
import book.pojo.OrderBean;
import book.pojo.OrderItem;
import book.pojo.User;
import book.service.OrderBeanService;

import java.util.List;
import java.util.Map;

public class OrderBeanServiceImpl implements OrderBeanService {
    private OrderBeanDAO orderBeanDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderBeanDAO.addOrderBean(orderBean);
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for(CartItem cartItem : cartItemMap.values()){
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }

        for(CartItem cartItem : cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderList = orderBeanDAO.getOrderList(user);
        for(OrderBean orderBean : orderList){
            Integer totalBookCount = orderBeanDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }

        return orderList;
    }
}
