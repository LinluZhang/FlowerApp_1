package suwu.flowerapp.parameters.event;

import suwu.flowerapp.publicdatas.event.EventType;
import suwu.flowerapp.publicdatas.event.EventType;

public class FirstOrderEventParameters extends EventAddParameters {
    private double minusPrice;

    public FirstOrderEventParameters() {
    }

    public FirstOrderEventParameters(EventType eventType, String description, double minusPrice) {
        super(eventType, description);
        this.minusPrice = minusPrice;
    }

    public double getMinusPrice() {
        return minusPrice;
    }

    public void setMinusPrice(double minusPrice) {
        this.minusPrice = minusPrice;
    }
}
