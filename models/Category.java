package mx.com.gm.HolaMundo.models;

import jakarta.persistence.*;

@Entity
@Table
public class Category {


    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )

    private Long id_category;
    private String name_category;
    private String color;

    public Category(){

    }

    public Category(Long id_category, String name_category, String color) {
        this.id_category = id_category;
        this.name_category = name_category;
        this.color = color;
    }

    public Category(String name_category, String color) {
        this.name_category = name_category;
        this.color = color;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_category=" + id_category +
                ", name_category='" + name_category + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
