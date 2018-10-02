package suwu.flowerapp.response.order;

import suwu.flowerapp.response.Response;

public class FinalPriceGetResponse extends Response {
    private double finalPrice;

    public FinalPriceGetResponse() {
    }

    public FinalPriceGetResponse(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
