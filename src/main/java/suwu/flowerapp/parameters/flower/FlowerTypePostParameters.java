package suwu.flowerapp.parameters.flower;

import suwu.flowerapp.entity.flower.Flower;
import java.util.List;

public class FlowerTypePostParameters {
    private int id;
    private String name;
    private List<Flower> flowers;

    public FlowerTypePostParameters(){}

    public FlowerTypePostParameters(int _id, String _name, List<Flower> _flowers){
        this.id = _id;
        this.name = _name;
        this.flowers = _flowers;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }

    public void setFlowers(List<Flower> _flowers){ this.flowers = _flowers; }

    public List<Flower> getFlowers(){ return flowers; }
}
