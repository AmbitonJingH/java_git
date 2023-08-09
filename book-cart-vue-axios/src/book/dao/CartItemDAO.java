package book.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/7/29 11:58
 * @version 1.0
 */

import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;

import java.util.List;

public interface CartItemDAO {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    List<CartItem> getCartItemList (User user);
    void delCartItem(CartItem cartItem);
}