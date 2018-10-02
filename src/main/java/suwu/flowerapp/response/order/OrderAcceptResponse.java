package suwu.flowerapp.response.order;

import suwu.flowerapp.response.Response;

public class OrderAcceptResponse extends Response {
    private String info;

    public OrderAcceptResponse() {
        this.info = "success";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
