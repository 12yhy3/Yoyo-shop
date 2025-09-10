package yhy.project.service;

import yhy.project.util.Result;

public interface ICartService {
    Result getCartByUserIdAndGoodsId(int userId, int goodsId);

    Result getCartNum(Integer userId);

    Result getCartList(Integer userId);

    Result changeCartNum(Integer num, Integer cartId);

    Result delCart(Integer cartId);
}