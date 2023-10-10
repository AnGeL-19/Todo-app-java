package mx.com.gm.HolaMundo.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Todo {

    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )

    private Long id_todo;
    private String name_todo;

    private Date create_at;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinTable(name="category_todo",
            joinColumns = {
                    @JoinColumn(name="id_todo", referencedColumnName="id_todo",
                            nullable=false, updatable=false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name="id_category", referencedColumnName="id_category",
                            nullable=false, updatable=false)
            })
    private List<Category> categories;
    /*
    private List<Category> categories;
*/

    public Todo(){}

    public Todo(String name_todo) {
        this.name_todo = name_todo;
    }

    public Todo(String name_todo, Date create_at) {
        this.name_todo = name_todo;
        this.create_at = create_at;
    }

    public Todo(Long id_todo, String name_todo, Date create_at) {
        this.id_todo = id_todo;
        this.name_todo = name_todo;
        this.create_at = create_at;
    }

    public Todo(String name_todo, Date create_at, List<Category> categories) {
        this.name_todo = name_todo;
        this.create_at = create_at;
        this.categories = categories;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "id_todo=" + id_todo +
                ", name_todo='" + name_todo + '\'' +
                ", create_at=" + create_at +
                ", categories=" + categories +
                '}';
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Long getId_todo() {
        return id_todo;
    }

    public void setId_todo(Long id_todo) {
        this.id_todo = id_todo;
    }

    public String getName_todo() {
        return name_todo;
    }

    public void setName_todo(String name_todo) {
        this.name_todo = name_todo;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
