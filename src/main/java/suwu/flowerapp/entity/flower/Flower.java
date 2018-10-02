package suwu.flowerapp.entity.flower;

import org.hibernate.annotations.Type;
import suwu.flowerapp.entity.account.User;
import suwu.flowerapp.publicdatas.flower.FlowerState;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flower")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "coverUrl")
    private String coverUrl;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "imageUrls")
    @ElementCollection(targetClass = String.class)
    private List<String> imageUrls;

   @Column(name = "flowerState")
   private FlowerState flowerState;

   @Column(name = "hasChoice")
   @Type(type = "yes_no")
   private boolean hasChoice;

    @Column(name = "choice")
    private String[] choice;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "flowerType_id")
    private FlowerType flowerType;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id")
   private User user;

    public Flower(){ }

    public Flower( String _name, String _coverUrl, double _price, String _description, List<String> _imageUrls, FlowerState _flowerState, boolean _hasChoice, String[] _choice, FlowerType _flowerType, User _user){
        this.name = _name;
        this.coverUrl = _coverUrl;
        this.price = _price;
        this.description = _description;
        this.imageUrls = _imageUrls;
        this.flowerState = _flowerState;
        this.hasChoice = _hasChoice;
        this.choice = _choice;
        this.flowerType = _flowerType;
        this.user = _user;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setName(String _name){ this.name = _name; }

    public String getName(){ return name; }

    public void setCoverUrl(String _coverUrl){ this.coverUrl = _coverUrl; }

    public String getCoverUrl(){ return coverUrl; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }

    public void setDescription(String _description){ this.description = _description; }

    public String getDescription(){ return description; }

    public void setImageUrls(List<String> _imageUrls){ this.imageUrls = _imageUrls; }

    public List<String> getImageUrls(){ return imageUrls; }

    public void setFlowerState(FlowerState _flowerState){ this.flowerState = _flowerState; }

    public FlowerState getFlowerState(){ return flowerState; }

    public void setHasChoice(boolean _hasChoice){ this.hasChoice = _hasChoice; }

    public boolean getHasChoice(){ return hasChoice; }

    public void setChoice(String[] _choice){ this.choice = _choice; }

    public String[] getChoice(){ return choice; }

    public void setFlowerType(FlowerType _flowerType){ this.flowerType = _flowerType; }

    public FlowerType getFlowerType(){ return flowerType; }

    public void setUser(User _user){ this.user = _user; }

    public User getUser(){ return user; }
}