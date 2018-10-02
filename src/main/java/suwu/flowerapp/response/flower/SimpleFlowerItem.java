package suwu.flowerapp.response.flower;

public class SimpleFlowerItem {
    private String url;
    private String name;
    private double price;
    private int id;

    public SimpleFlowerItem(){}

    public SimpleFlowerItem(String _url, String _name, double _price, int _id){
        this.url = _url;
        this.name = _name;
        this.price = _price;
        this.id = _id;
    }

    public void setUrl(String _url){ this.url = _url; }

    public String getUrl(){ return url; }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }
}
