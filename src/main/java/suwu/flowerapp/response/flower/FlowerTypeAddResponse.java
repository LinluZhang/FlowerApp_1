package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;

public class FlowerTypeAddResponse extends Response {
    private int typeId;

    public FlowerTypeAddResponse(){ }

    public FlowerTypeAddResponse(int _typeId){ this.typeId = _typeId; }

    public void setTypeId(int _typeId){ this.typeId = _typeId; }

    public int getTypeId(){ return typeId; }
}
