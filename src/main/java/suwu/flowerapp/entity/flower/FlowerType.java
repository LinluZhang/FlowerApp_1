package suwu.flowerapp.entity.flower;

import suwu.flowerapp.publicdatas.flower.FlowerTypeState;
import suwu.flowerapp.publicdatas.port.PortState;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flowerType")
public class FlowerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "portState")
    private FlowerTypeState typeState;

    @OneToMany(mappedBy = "flowerType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Flower> flowers;

    public FlowerType(){

    }

    public FlowerType( String _name, FlowerTypeState _typeState, List<Flower> _flowers){
        this.name = _name;
        this.typeState = _typeState;
        this.flowers = _flowers;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setName(String _name){ this.name  = _name; }

    public String getName(){ return name; }

    public void setTypeState(FlowerTypeState _flowerTypeState){ this.typeState = _flowerTypeState; }

    public FlowerTypeState getTypeState(){ return typeState; }

    public void setFlowers(List<Flower> _flowers){ this.flowers = _flowers; }

    public List<Flower> getFlowers(){ return flowers; }
}
