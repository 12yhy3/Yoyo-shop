package yhy.project.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yhy.project.service.IOrderService;
import yhy.project.util.RedisUtils;
import yhy.project.util.Result;

@RequestMapping({"/api/order"})
@RestController
public class OrderController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private IOrderService orderService;

    @PostMapping({"/submit"})
    public Result submitOrder(String token, Integer payType, String name, String phone, String address) {
        if (Strings.isEmpty(token) || !this.redisUtils.hasKey(token)) {
            return Result.error("请先登录");
        }
        if (payType == null || payType.intValue() < 1 || payType.intValue() > 3) {
            return Result.error("请选择支付方式");
        }
        if (Strings.isEmpty(name)) {
            return Result.error("收货人姓名不能为空");
        }
        if (Strings.isEmpty(phone)) {
            return Result.error("收货人手机号不能为空");
        }
        if (!phone.matches("^1[3-9]\\d{9}$")) {
            return Result.error("收货人手机号格式不正确");
        }
        if (Strings.isEmpty(address)) {
            return Result.error("收货人地址不能为空");
        }
        return this.orderService.submitOrder(token, payType, name, phone, address);
    }

    @PostMapping({"/list"})
    public Result Order(String token) {
        System.out.println("token:" + token);
        System.out.println(this.redisUtils.hasKey(token));
        if (Strings.isEmpty(token) || !this.redisUtils.hasKey(token)) {
            return Result.error("请先登录");
        }
        Integer userId = (Integer) this.redisUtils.hmget(token).get("id");
        return this.orderService.getOrdersByUserId(userId);
    }

    @GetMapping({"/listspage"})
    public Result Order(Integer page, Integer limit, String orderNumber, Integer status, Integer paytype) {
        if (page == null) {
            page = 0;
        }
        if (limit == null) {
            limit = 10;
        }
        return this.orderService.getAllOrders(page, limit, orderNumber, status, paytype);
    }

    @PutMapping({"/updateStatus/{id}/{status}"})
    public Result updateOrderStatus(@PathVariable("id") Integer id, @PathVariable("status") Integer status) {
        if (status.intValue() < 2) {
            return Result.success("还未付款不能派送");
        }
        return this.orderService.updateOrderStatus(id, status);
    }
}