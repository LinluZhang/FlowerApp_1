package suwu.flowerapp.response.order;

import suwu.flowerapp.response.Response;

import java.util.List;

public class OrderLoadResponse extends Response {
    private List<OrderItem> orders;

    public OrderLoadResponse() {
    }

    public OrderLoadResponse(List<OrderItem> orders) {
        this.orders = orders;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }
}
