package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;

public class FlowerTypeDeleteResponse extends Response {
    private int typeId;

    public FlowerTypeDeleteResponse(){}

    public FlowerTypeDeleteResponse(int _typeId){ this.typeId = _typeId; }

    public void setTypeId(int _typeId){ this.typeId = _typeId; }

    public int getTypeId(){ return typeId; }

}
