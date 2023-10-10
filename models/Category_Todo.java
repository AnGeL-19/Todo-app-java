package mx.com.gm.HolaMundo.models;


import jakarta.persistence.*;

@Entity
@Table
public class Category_Todo {

    @Id
    @SequenceGenerator(
            name = "category_todos_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_todos_sequence"
    )

    private Long id_categorytodo;

    private Long id_todo;

    private Long id_category;

    public Category_Todo() {
    }

    public Category_Todo(Long id_todo, Long id_category) {
        this.id_todo = id_todo;
        this.id_category = id_category;
    }

    public Category_Todo(Long id_categorytodo, Long id_todo, Long id_category) {
        this.id_categorytodo = id_categorytodo;
        this.id_todo = id_todo;
        this.id_category = id_category;
    }

    @Override
    public String toString() {
        return "Category_Todo{" +
                "id_categorytodo=" + id_categorytodo +
                ", id_todo=" + id_todo +
                ", id_category=" + id_category +
                '}';
    }

    public Long getId_categorytodo() {
        return id_categorytodo;
    }

    public void setId_categorytodo(Long id_categorytodo) {
        this.id_categorytodo = id_categorytodo;
    }

    public Long getId_todo() {
        return id_todo;
    }

    public void setId_todo(Long id_todo) {
        this.id_todo = id_todo;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }
}
