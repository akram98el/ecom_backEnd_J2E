package org.sid.ecommerce.entities;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//SPECIFIER JPA ENTITY
@Entity
//pour generer setter getters
@Data
//constructor

public class Category implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String name;
    private String description;
    @OneToMany(mappedBy = "category" )
    private Collection<Product> products;

    public Category() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Category(Long id, String name, String description, Collection<Product> products) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
    }




}
