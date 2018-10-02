package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;

import java.util.List;

public class FlowerGetByTypeResponse extends Response {
    private List<FlowerItem> flowerItems;

    public FlowerGetByTypeResponse(){}

    public FlowerGetByTypeResponse(List<FlowerItem> _flowItems){ this.flowerItems = _flowItems; }

    public void setFlowerItems(List<FlowerItem> _flowerItem){ this.flowerItems = _flowerItem; }

    public List<FlowerItem> getFlowerItems(){ return flowerItems; }
}
