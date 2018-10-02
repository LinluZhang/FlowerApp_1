package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;
import java.util.List;

public class FlowerDetailResponse extends Response {
    private String name;
    private int amount;
    private double price;
    private String description;
    private List<String> imageUrls;
    private String typeName;
    private boolean hasSpecialChoices;
    private String[] specialChoices;

    public FlowerDetailResponse(){}

    public FlowerDetailResponse( String _name, int _amount, double _price, String _description, List<String> _imageUrls, String _typeName, boolean _hasSpecialChoices, String[] _specialChoices){
        this.name = _name;
        this.amount = _amount;
        this.price = _price;
        this.description = _description;
        this.imageUrls = _imageUrls;
        this.typeName = _typeName;
        this.hasSpecialChoices = _hasSpecialChoices;
        this.specialChoices = _specialChoices;
    }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }

    public void setAmount(int _amount){ this.amount = _amount; }

    public int getAmount(){ return amount; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }

    public void setDescription(String _description){ this.description = _description; }

    public String getDescription(){ return description; }

    public void setImageUrls(List<String> _imageUrls){ this.imageUrls = _imageUrls; }

    public List<String> getImageUrls(){ return imageUrls; }

    public void setTypeName(String _typeName){ this.typeName = _typeName; }

    public String getTypeName(){ return typeName; }

    public void setHasSpecialChoices(boolean _hasSpecialChoices){ this.hasSpecialChoices = _hasSpecialChoices; }

    public boolean getHasSpecialChoices(){ return hasSpecialChoices; }

    public void setSpecialChoices(String[] _specialChoices){ this.specialChoices = _specialChoices; }

    public String[] getSpecialChoices(){ return this.specialChoices; }
}
