package suwu.flowerapp.response.flower;

public class SimpleFlowerTypeItem {
    private int id;
    private String typeName;

    public SimpleFlowerTypeItem(){}

    public SimpleFlowerTypeItem(int _id, String _typeName){
        this.id = _id;
        this.typeName = _typeName;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setTypeName(String _typeName){ this.typeName = _typeName; }

    public String getTypeName(){ return typeName; }
}
