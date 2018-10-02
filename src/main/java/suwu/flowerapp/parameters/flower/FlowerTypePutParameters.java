package suwu.flowerapp.parameters.flower;

public class FlowerTypePutParameters {
    private String name;

    public FlowerTypePutParameters(){}

    public FlowerTypePutParameters(String _name){ this.name = _name; }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }
}
