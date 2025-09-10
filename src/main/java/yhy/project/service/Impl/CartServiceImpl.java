package yhy.project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhy.project.entity.Cart;
import yhy.project.entity.Goods;
import yhy.project.mapper.CartMapper;
import yhy.project.mapper.GoodsMapper;
import yhy.project.service.ICartService;
import yhy.project.util.Result;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override // yhy.project.service.ICartService
    public Result getCartByUserIdAndGoodsId(int userId, int goodsId) {
        Cart cart = this.cartMapper.selectCartByUserIdAndGoodsId(Integer.valueOf(userId), Integer.valueOf(goodsId));
        if (cart == null) {
            Goods goods = this.goodsMapper.selectGoodsById(Integer.valueOf(goodsId));
            if (goods.getStock().intValue() >= 1) {
                Cart c = new Cart();
                c.setTitle(goods.getName());
                c.setPic(goods.getCover());
                c.setPrice(goods.getPrice());
                c.setNum(1);
                c.setGoodsId(Integer.valueOf(goodsId));
                c.setUserId(Integer.valueOf(userId));
                this.cartMapper.insertCart(c);
            } else {
                return Result.error("商品库存不足");
            }
        } else if (this.goodsMapper.selectGoodsById(Integer.valueOf(goodsId)).getStock().intValue() >= cart.getNum().intValue() + 1) {
            cart.setNum(Integer.valueOf(cart.getNum().intValue() + 1));
            this.cartMapper.updateCart(cart);
        } else {
            return Result.error("商品库存不足");
        }
        return Result.success();
    }

    @Override // yhy.project.service.ICartService
    public Result getCartNum(Integer userId) {
        System.out.println("----" + userId);
        int count = this.cartMapper.selectCartNum(userId);
        return Result.success(Integer.valueOf(count));
    }

    @Override // yhy.project.service.ICartService
    public Result getCartList(Integer userId) {
        List<Cart> cartList = this.cartMapper.selectCartList(userId);
        return Result.success(cartList);
    }

    @Override // yhy.project.service.ICartService
    public Result changeCartNum(Integer num, Integer cartId) {
        Cart cart = this.cartMapper.selectCartById(cartId);
        int goodsId = cart.getGoodsId().intValue();
        Goods goods = this.goodsMapper.selectGoodsById(Integer.valueOf(goodsId));
        if (goods.getStock().intValue() < cart.getNum().intValue() + num.intValue()) {
            return Result.error("商品库存不足");
        }
        cart.setNum(Integer.valueOf(cart.getNum().intValue() + num.intValue()));
        if (cart.getNum().intValue() <= 0) {
            delCart(cartId);
        } else {
            this.cartMapper.updateCart(cart);
        }
        return Result.success();
    }

    @Override // yhy.project.service.ICartService
    public Result delCart(Integer cartId) {
        int row = this.cartMapper.deleteCartById(cartId);
        return row > 0 ? Result.success() : Result.error();
    }
}