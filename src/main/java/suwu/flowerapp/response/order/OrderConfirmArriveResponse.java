package suwu.flowerapp.response.order;

import suwu.flowerapp.response.Response;

public class OrderConfirmArriveResponse extends Response {
    private String info;

    public OrderConfirmArriveResponse() {
        this.info = "success";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}