package cn.gdcp.service.impl;

import cn.gdcp.domain.Cart;
import cn.gdcp.mapper.CartMapper;
import cn.gdcp.service.CartService;
import cn.gdcp.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodService goodService;

    /*获取购物车数量*/
    public int getCount(int userId) {
        return cartMapper.selectSumAmountByUserId(userId);
    }

    /*获取购物车列表*/
    public List<Cart> getList(int userId){
        List<Cart> cartList = cartMapper.selectListByUseId(userId);
//        System.out.println(cartList);
        return pack(cartList);
    }

    /*添加购物车*/
    public boolean save(int goodId, int count, int userId) {
        Cart cart =cartMapper.selectByUserIdAndGoodId(userId,goodId);
        if (Objects.nonNull(cart)){
            return cartMapper.updateAmount(cart.getId(),count);
        }
        cart = new Cart();
        cart.setGoodId(goodId);
        cart.setUserId(userId);
        cart.setAmount(count);
        return cartMapper.insert(cart);
    }
    public boolean save(int goodId, int userId) {
        Cart cart =cartMapper.selectByUserIdAndGoodId(userId,goodId);
        if (Objects.nonNull(cart)){
            return cartMapper.updateAmount(cart.getId(),1);
        }
        cart = new Cart();
        cart.setGoodId(goodId);
        cart.setUserId(userId);
        cart.setAmount(1);//默认数量1
        return cartMapper.insert(cart);
    }

    /*购物车总金额*/
    public int getTotal(int userId) {
        int total=0;
        List<Cart> cartList = this.getList(userId);
        if (Objects.nonNull(cartList) && !cartList.isEmpty()){
            for (Cart cart : cartList){
                total += cart.getGood().getPrice() * cart.getAmount();
            }
        }
        return total;
    }
    /*封装商品*/
    private List<Cart> pack(List<Cart> list) {
        for (Cart cart:list) {
            cart=pack(cart);
        }
        return list;
    }

    /*封装商品 */
    private Cart pack(Cart cart){
        if (Objects.nonNull(cart)){
            cart.setGood(goodService.get(cart.getGoodId()));//类目信息
            cart.setTotal(cart.getAmount() * cart.getGood().getPrice());
        }
        return cart;
    }

    public boolean cartDel(int id) {
        return cartMapper.delete(id);
    }

    public boolean add(int id) {
        return cartMapper.updateAmount(id,1);
    }

    public boolean less(int id) {
        Cart cart = cartMapper.select(id);
        if(cart.getAmount()<=1){
            return cartDel(id);
        }
        return cartMapper.updateAmount(id,-1);
    }

    /*清空购物车*/
    public boolean clean(int userId) {
        return cartMapper.deleteByUserId(userId);
    }
}
