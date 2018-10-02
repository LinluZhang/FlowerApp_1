package suwu.flowerapp.entity.account;

import suwu.flowerapp.entity.flower.Flower;
import suwu.flowerapp.entity.order.Order;
import suwu.flowerapp.entity.token.Token;
import suwu.flowerapp.publicdatas.account.Role;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "avatarUrl")
    private String avatarUrl;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Role role;
    @Column(name = "credits")
    private int credits;
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Token> tokens;
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Order> orders;
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Flower> flowers;

    public User() {
    }

    public User(String _avatarUrl, String _username, String _password, Role _role, int _credits, List<Token> _tokens, List<Order> _orders, List<Flower> _flowers) {
        this.avatarUrl = _avatarUrl;
        this.username = _username;
        this.password = _password;
        this.role = _role;
        this.credits = _credits;
        this.tokens = _tokens;
        this.orders = _orders;
        this.flowers = _flowers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getCredits(){ return credits; }

    public void setCredits(int _credits){ this.credits = _credits; }

    public List<Token> getTokens(){ return tokens; }

    public void setTokens(List<Token> _tokens){ this.tokens = _tokens; }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Flower> getFoods() {
        return flowers;
    }

    public void setFoods(List<Flower> _flowers) {
        this.flowers = _flowers;
    }
}
