package yhy.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import yhy.project.entity.Cart;
import yhy.project.entity.vo.CartVo;

import java.util.List;

@Mapper
/* loaded from: yoyo-shop-1.0-SNAPSHOT.jar:BOOT-INF/classes/tech/deepmind/mapper/CartMapper.class */
public interface CartMapper {
    Cart selectCartByUserIdAndGoodsId(Integer userId, Integer goodsId);

    int insertCart(Cart cart);

    int updateCart(Cart cart);

    int selectCartNum(Integer userId);

    List<Cart> selectCartList(Integer userId);

    Cart selectCartById(Integer cartId);

    int deleteCartById(Integer cartId);

    List<CartVo> selectCartListByUserId(Integer userId);

    int deleteCartByUserId(Integer userId);
}