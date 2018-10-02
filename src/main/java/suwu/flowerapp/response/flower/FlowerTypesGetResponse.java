package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;
import java.util.List;

public class FlowerTypesGetResponse extends Response {
    private List<SimpleFlowerTypeItem> flowerTypeItems;

    public FlowerTypesGetResponse(){}

    public FlowerTypesGetResponse(List<SimpleFlowerTypeItem> _flowerTypeItems){ this.flowerTypeItems = _flowerTypeItems; }

    public void setFlowerTypeItems(List<SimpleFlowerTypeItem> _flowerTypeItems){ this.flowerTypeItems = _flowerTypeItems; }

    public List<SimpleFlowerTypeItem> getFlowerTypeItems(){ return flowerTypeItems; }
}
