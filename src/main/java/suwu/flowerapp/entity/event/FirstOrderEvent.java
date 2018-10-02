package suwu.flowerapp.entity.event;

import suwu.flowerapp.publicdatas.event.EventState;
import suwu.flowerapp.publicdatas.event.EventType;
import suwu.flowerapp.publicdatas.event.EventState;
import suwu.flowerapp.publicdatas.event.EventType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FirstOrderEvent extends Event {
    @Column(name = "minusPrice")
    private double minusPrice;

    public FirstOrderEvent() {
    }

    public FirstOrderEvent(String content, EventState eventState, double minusPrice) {
        super(content, EventType.FirstOrder, eventState);
        this.minusPrice = minusPrice;
    }

    public double getMinusPrice() {
        return minusPrice;
    }

    public void setMinusPrice(double minusPrice) {
        this.minusPrice = minusPrice;
    }
}
