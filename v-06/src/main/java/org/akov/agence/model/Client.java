package org.akov.agence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstName;
    private String telephone;
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Bien> biens = new ArrayList<>();

    // Constructors
    public Client() {
    }

    public Client(String name, String firstName, String telephone, String address) {
        this.name = name;
        this.firstName = firstName;
        this.telephone = telephone;
        this.address = address;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Bien> getBiens() {
        return biens;
    }

    public void setBiens(List<Bien> biens) {
        this.biens = biens;
    }

    // Utility method to add a bien to the client
    public void addBien(Bien bien) {
        biens.add(bien);
        bien.setClient(this);
    }

    // Utility method to remove a bien from the client
    public void removeBien(Bien bien) {
        biens.remove(bien);
        bien.setClient(null);
    }
}
