package yhy.project.service;

import yhy.project.util.Result;

public interface IOrderService {
    Result submitOrder(String token, Integer payType, String name, String phone, String address);

    Result getOrdersByUserId(Integer userId);

    Result getAllOrders(Integer page, Integer limit, String orderNumber, Integer status, Integer paytype);

    Result updateOrderStatus(Integer id, Integer status);
}