package mx.com.gm.HolaMundo.Controllers;

import mx.com.gm.HolaMundo.Services.TodoService;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<Todo> getTodos() {

        return this.todoService.getTodos();

    }

    @PostMapping("/")
    public void registerTodo(@RequestBody Todo todo) {
        this.todoService.addNewTodo(todo);
    }

    @DeleteMapping("/{id_todo}")
    public void deleteTodo(@PathVariable("id_todo") Long id){
        this.todoService.deleteTodo(id);
    }

    @PutMapping("/{id_todo}")
    public void updateTodo(@PathVariable("id_todo") Long id, @RequestParam(required = false) String name_todo){
        this.todoService.updateTodo(id,name_todo);
    }

}
