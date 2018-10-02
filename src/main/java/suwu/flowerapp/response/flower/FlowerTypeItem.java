package suwu.flowerapp.response.flower;

public class FlowerTypeItem {
    private int id;
    private String name;

    public FlowerTypeItem(){}

    public FlowerTypeItem(int _id, String _name){
        this.id = _id;
        this.name = _name;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }

}
