package mx.com.gm.HolaMundo.Services;

import jakarta.transaction.Transactional;
import mx.com.gm.HolaMundo.interfaces.TodoRepository;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return this.todoRepository.findAll();

    }

    public void addNewTodo(Todo todo){

        Optional<Todo> optionalTodo = this.todoRepository.findTodoByName(todo.getName_todo());
        if(optionalTodo.isPresent()){
            throw new IllegalStateException("name_todo taken");
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        todo.setCreate_at(date);

        System.out.println(todo);

        this.todoRepository.save(todo);

    }

    public void deleteTodo(Long id) {

        /*
        Optional<Todo> optionalTodo = this.todoRepository.findTodoById(id);
        if(optionalTodo.isEmpty()){
            throw new IllegalStateException("id_todo no exists");
        }
        */
        boolean exists = this.todoRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("id_todo no exists");
        }

        this.todoRepository.deleteById(id);
    }

    @Transactional
    public void updateTodo(Long id, String name){


        Todo todo = this.todoRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("id_todo"+id+"no exists")
        );

        if (!name.isEmpty() && !Objects.equals(todo.getName_todo(), name)){
            todo.setName_todo(name);
        }



    }

}
