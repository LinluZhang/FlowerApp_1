package suwu.flowerapp.parameters.flower;

import suwu.flowerapp.entity.flower.FlowerType;

import java.util.List;

public class FlowerPostParameters {
    private int id;
    private String name;
    private String coverUrl;
    private String description;
    private double price;
    private List<String> imageUrls;
    private boolean hasChoice;
    private String[] choice;
    private FlowerType flowerType;

    public FlowerPostParameters(){}

    public FlowerPostParameters(int _id, String _name, String _coverUrl, String _description, double _price, List<String> _imageUrls, boolean _hasChoice, String[] _choice, FlowerType _flowerType){
        this.id = _id;
        this.name = _name;
        this.coverUrl = _coverUrl;
        this.description = _description;
        this.price = _price;
        this.imageUrls = _imageUrls;
        this.hasChoice = _hasChoice;
        this.choice = _choice;
        this.flowerType = _flowerType;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }

    public void setCoverUrl(String _coverUrl){ this.coverUrl = _coverUrl; }

    public String getCoverUrl(){ return coverUrl; }

    public void setDescription(String _description){ this.description = _description; }

    public String getDescription(){ return description; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }

    public void setImageUrls(List<String> _imageUrls){ this.imageUrls = _imageUrls; }

    public List<String> getImageUrls(){ return imageUrls; }

    public void setHasChoice(boolean _hasChoice){ this.hasChoice = _hasChoice; }

    public boolean getHasChoice(){ return hasChoice; }

    public void setChoice(String[] _choice){ this.choice = _choice; }

    public String[] getChoice(){ return choice; }

    public void setFlowerType(FlowerType _flowerType){ this.flowerType = _flowerType; }

    public FlowerType getFlowerType(){ return flowerType; }

}
