package suwu.flowerapp.parameters.flower;

public class FlowerTypeDeleteParameters {
    private int id;

    public FlowerTypeDeleteParameters(){}

    public FlowerTypeDeleteParameters(int _id){ this.id = _id; }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }
}
