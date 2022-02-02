package com.qa.ItemInventory.Item;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(min = 1, message = "Names cannot be empty")
    private String name;

    @NotNull
    @Length(min = 1, message = "Description cannot be empty")
    private String description;


    public Item() {
        super();
    }

    public Item(String name,
                String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public Item(long id,
                String name,
                String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
