package book.pojo;
/*
 * @author  AmbitionJingH
 * @date  2023/7/29 12:12
 * @version 1.0
 */

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Integer,CartItem> cartItemMap;//购物车中购物车项的集合
    private Double totalMoney;//购物车的总价
    private Integer totalCount;//购物车中购物项的总数量
    private Integer totalBookCount;//购物车中书本的总数量


    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        BigDecimal bigDecimal = new BigDecimal(""+0);
        totalMoney = 0.0;
        if(cartItemMap!=null && cartItemMap.size()>0){
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer,CartItem> cartItemEntry:entries) {
                CartItem cartItem = cartItemEntry.getValue();
                BigDecimal bigDecimalPrice = new BigDecimal("" + cartItem.getBook().getPrice());
                BigDecimal bigDecimalBuyCount = new BigDecimal("" + cartItem.getBuyCount());
                bigDecimal = bigDecimal.add(bigDecimalPrice.multiply(bigDecimalBuyCount));
            }
        }
        totalMoney = bigDecimal.doubleValue();
        return totalMoney;
    }


    public Integer getTotalCount() {
        totalCount = 0;
        if(cartItemMap!=null && cartItemMap.size()>0)
            totalCount = cartItemMap.size();
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if(cartItemMap!=null && cartItemMap.size()>0)
            for (CartItem cartItem : cartItemMap.values()){
                totalBookCount += cartItem.getBuyCount();
            }
        return totalBookCount;
    }
}
