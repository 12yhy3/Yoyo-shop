package yhy.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yhy.project.entity.Order;
import yhy.project.entity.vo.OrderVo;

import java.util.List;

@Mapper
/* loaded from: yoyo-shop-1.0-SNAPSHOT.jar:BOOT-INF/classes/tech/deepmind/mapper/OrderMapper.class */
public interface OrderMapper {
    int insertOrder(Order order);

    List<OrderVo> selectOrdersByUserId(Integer userId);

    List<OrderVo> getAllOrders(@Param("orderNumber") String orderNumber, @Param("status") Integer status, @Param("paytype") Integer paytype);

    int updateOrderStatus(@Param("id") Integer id, @Param("status") Integer status);
}