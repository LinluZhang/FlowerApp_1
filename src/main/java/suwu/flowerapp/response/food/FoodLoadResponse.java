package suwu.flowerapp.response.food;

import suwu.flowerapp.response.Response;

import java.util.List;

public class FoodLoadResponse extends Response {
    private List<PortItem> portItemList;

    public FoodLoadResponse() {
    }

    public FoodLoadResponse(List<PortItem> portItemList) {
        this.portItemList = portItemList;
    }

    public List<PortItem> getPortItemList() {
        return portItemList;
    }

    public void setPortItemList(List<PortItem> portItemList) {
        this.portItemList = portItemList;
    }
}
