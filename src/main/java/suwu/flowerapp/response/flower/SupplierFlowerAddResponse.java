package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;

public class SupplierFlowerAddResponse extends Response {
    private int id;

    public SupplierFlowerAddResponse(){}

    public SupplierFlowerAddResponse(int _id){ this.id = _id; }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }
}
