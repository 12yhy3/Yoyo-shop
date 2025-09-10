package yhy.project.service.Impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.text.CharSequenceUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhy.project.entity.Item;
import yhy.project.entity.Order;
import yhy.project.entity.vo.CartVo;
import yhy.project.entity.vo.OrderVo;
import yhy.project.mapper.CartMapper;
import yhy.project.mapper.GoodsMapper;
import yhy.project.mapper.ItemMapper;
import yhy.project.mapper.OrderMapper;
import yhy.project.service.IOrderService;
import yhy.project.util.RedisUtils;
import yhy.project.util.Result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private static final SimpleDateFormat SDF = new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override // yhy.project.service.IOrderService
    public Result submitOrder(String token, Integer payType, String name, String phone, String address) {
        Integer userId = (Integer) this.redisUtils.hmget(token).get("id");
        List<CartVo> cartList = this.cartMapper.selectCartListByUserId(userId);
        if (cartList.size() == 0) {
            return Result.error("购物车为空");
        }
        Integer amount = 0;
        Double total = Double.valueOf(0.0d);
        for (CartVo cartVo : cartList) {
            Integer num = cartVo.getNum();
            Integer stock = cartVo.getStock();
            if (stock.intValue() < num.intValue()) {
                return Result.error(cartVo.getTitle() + "商品库存不足，库存数量是：" + stock);
            }
            Double price = cartVo.getPrice();
            total = Double.valueOf(total.doubleValue() + (price.doubleValue() * num.intValue()));
            amount = Integer.valueOf(amount.intValue() + num.intValue());
        }
        String orderNumber = "YY" + SDF.format(new Date()).replace("-", "").replace(":", "").replace(CharSequenceUtil.SPACE, "") + userId;
        System.out.println("订单编号是：" + orderNumber);
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setTotal(total);
        order.setAmount(amount);
        order.setPaytype(payType);
        order.setName(name);
        order.setPhone(phone);
        order.setAddress(address);
        order.setUserId(userId);
        order.setStatus(2);
        order.setSystime(SDF.format(new Date()));
        this.orderMapper.insertOrder(order);
        List<Item> items = new ArrayList<>();
        for (CartVo cartVo2 : cartList) {
            Item item = new Item();
            item.setTitle(cartVo2.getTitle());
            item.setPrice(cartVo2.getPrice());
            item.setPic(cartVo2.getPic());
            item.setAmount(cartVo2.getNum());
            item.setGoodsId(cartVo2.getGoodsId());
            item.setOrderId(order.getId());
            items.add(item);
            this.goodsMapper.updateGoodsStockById(cartVo2.getGoodsId(), cartVo2.getNum());
        }
        this.itemMapper.insertItemsBatch(items);
        this.cartMapper.deleteCartByUserId(userId);
        return Result.success("购买成功！");
    }

    @Override // yhy.project.service.IOrderService
    public Result getOrdersByUserId(Integer userId) {
        List<OrderVo> orderList = this.orderMapper.selectOrdersByUserId(userId);
        for (OrderVo order : orderList) {
            int orderId = order.getId().intValue();
            List<Item> items = this.itemMapper.selectItemsByOrderId(Integer.valueOf(orderId));
            order.setItemList(items);
        }
        return Result.success(orderList);
    }

    @Override // yhy.project.service.IOrderService
    public Result getAllOrders(Integer page, Integer limit, String orderNumber, Integer status, Integer paytype) {
        List<OrderVo> orderList = this.orderMapper.getAllOrders(orderNumber, status, paytype);
        for (OrderVo order : orderList) {
            int orderId = order.getId().intValue();
            List<Item> items = this.itemMapper.selectItemsByOrderId(Integer.valueOf(orderId));
            order.setItemList(items);
        }
        PageHelper.startPage(page.intValue(), limit.intValue());
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderList);
        return Result.success(pageInfo);
    }

    @Override // yhy.project.service.IOrderService
    public Result updateOrderStatus(Integer id, Integer status) {
        return this.orderMapper.updateOrderStatus(id, status) > 0 ? Result.success("成功") : Result.success("失败");
    }
}