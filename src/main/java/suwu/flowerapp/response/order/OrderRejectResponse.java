package suwu.flowerapp.response.order;

import suwu.flowerapp.response.Response;

public class OrderRejectResponse extends Response {
    private String info;

    public OrderRejectResponse() {
        this.info = "success";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
