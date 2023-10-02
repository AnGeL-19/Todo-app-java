package mx.com.gm.HolaMundo.models;

import jakarta.persistence.*;

import java.util.Date;

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

    private Integer id_todo;
    private String name_todo;

    private Date create_at;


    public Todo(){}

    public Todo(String name_todo) {
        this.name_todo = name_todo;
    }

    public Todo(String name_todo, Date create_at) {
        this.name_todo = name_todo;
        this.create_at = create_at;
    }

    public Todo(Integer id_todo, String name_todo, Date create_at) {
        this.id_todo = id_todo;
        this.name_todo = name_todo;
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "idTodo=" + id_todo +
                ", nameTodo='" + name_todo + '\'' +
                ", create_at=" + create_at +
                '}';
    }

    public Integer getId_todo() {
        return id_todo;
    }

    public void setId_todo(Integer id_todo) {
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
