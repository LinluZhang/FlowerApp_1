package suwu.flowerapp.response.flower;

public class FlowerItem {
    private int id;
    private String name;
    private String cover;
    private double price;

    public FlowerItem(){ }

    public FlowerItem(int _id, String _name, String _cover, double _price){
        this.id = _id;
        this.name = _name;
        this.cover = _cover;
        this.price = _price;
    }

    public void setId(int _id){ this.id = id; }

    public int getId(){ return id; }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }

    public void setCover(String _cover){ this.cover = _cover; }

    public String getCover(){ return cover; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }
}
