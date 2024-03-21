package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private int quantity = 0;
    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Users> usersSubscribe = new HashSet<>();

    public Product() {
    }

    public Product(UUID id, String name, int quantity, Set<Users> usersSubscribe) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.usersSubscribe = usersSubscribe;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getUsersSubscribe() {
        return usersSubscribe;
    }

    public void setUsersSubscribe(Set<Users> usersSubscribe) {
        this.usersSubscribe = usersSubscribe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
