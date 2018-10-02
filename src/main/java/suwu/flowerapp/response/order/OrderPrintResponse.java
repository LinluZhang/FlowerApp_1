package suwu.flowerapp.response.order;

import suwu.flowerapp.response.Response;

public class OrderPrintResponse extends Response {
    private String info;

    public OrderPrintResponse() {
        this.info = "success";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
