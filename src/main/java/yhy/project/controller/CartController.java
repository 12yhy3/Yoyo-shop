package yhy.project.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhy.project.service.ICartService;
import yhy.project.util.RedisUtils;
import yhy.project.util.Result;


@RequestMapping({"/api/cart"})
@RestController
public class CartController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ICartService cartService;

    @PostMapping({"/addCart"})
    public Result addCart(Integer id, String token) {
        if (Strings.isEmpty(token) || !this.redisUtils.hasKey(token)) {
            return Result.error("请先登录");
        }
        if (id == null || id.intValue() <= 0) {
            return Result.error("商品id不能为空");
        }
        Integer userId = (Integer) this.redisUtils.hmget(token).get("id");
        return this.cartService.getCartByUserIdAndGoodsId(userId.intValue(), id.intValue());
    }

    @PostMapping({"/getCartNum"})
    public Result getCartNum(String token) {
        if (Strings.isEmpty(token) || !this.redisUtils.hasKey(token)) {
            return Result.error("请先登录");
        }
        Integer userId = (Integer) this.redisUtils.hmget(token).get("id");
        return this.cartService.getCartNum(userId);
    }

    @PostMapping({"/getCartList"})
    public Result getCartList(String token) {
        if (Strings.isEmpty(token) || !this.redisUtils.hasKey(token)) {
            return Result.error("请先登录");
        }
        Integer userId = (Integer) this.redisUtils.hmget(token).get("id");
        return this.cartService.getCartList(userId);
    }

    @PostMapping({"/changeNum"})
    public Result changeCartNum(Integer num, Integer cartId, String token) {
        if (Strings.isEmpty(token) || !this.redisUtils.hasKey(token)) {
            return Result.error("请先登录");
        }
        if (num == null || num.intValue() == 0) {
            return Result.error("商品数量不能为空");
        }
        if (cartId == null || cartId.intValue() <= 0) {
            return Result.error("购物车id不能为空");
        }
        return this.cartService.changeCartNum(num, cartId);
    }

    @PostMapping({"/delCart"})
    public Result delCart(Integer cartId, String token) {
        if (Strings.isEmpty(token) || !this.redisUtils.hasKey(token)) {
            return Result.error("请先登录");
        }
        if (cartId == null || cartId.intValue() <= 0) {
            return Result.error("购物车id不能为空");
        }
        return this.cartService.delCart(cartId);
    }
}