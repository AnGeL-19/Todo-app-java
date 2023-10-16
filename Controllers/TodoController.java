package mx.com.gm.HolaMundo.Controllers;

import mx.com.gm.HolaMundo.Services.TodoService;
import mx.com.gm.HolaMundo.models.Category;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public Map<String, Object> getTodos() {

        List<Todo> todos = this.todoService.getTodos();

        Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result

        map.put("status", true);
        map.put("message", "Data is found");
        map.put("data", todos);

        return map;

    }

    @GetMapping("/{id_todo}")
    public Map<String, Object> getTodoById(@PathVariable("id_todo") Long id) {

        Todo todo = this.todoService.getTodoById(id);

        Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result

        map.put("status", true);
        map.put("message", "Data is found");
        map.put("data", todo);

        return map;



    }


    /*
    @RequestMapping(value = "/", method = RequestMethod.POST)
    */
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Map<String, Object>  registerTodo(@RequestBody Todo todo) {

        Map<String, Object> map = new HashMap<String, Object >();

        try {


            this.todoService.addNewTodo(todo);


            map.put("status", true);
            map.put("message", "Data updated success");

            return map;
        } catch (Exception error) {
            map.put("status", false);
            map.put("message", "Error" + error.getMessage());

            return map;
        }

    }

    @DeleteMapping("/{id_todo}")
    public void deleteTodo(@PathVariable("id_todo") Long id){
        this.todoService.deleteTodo(id);
    }

    @PutMapping("/{id_todo}")
    public Map<String, Object> updateTodo(@PathVariable("id_todo") Long id, @RequestBody Todo todo){

        Map<String, Object> map = new HashMap<String, Object>();

        try {
            this.todoService.updateTodo(id,todo);

             // use new HashMap<String, Object>(); for single result

            map.put("status", true);
            map.put("message", "Data updated success");

            return map;
        } catch (Exception error) {
            map.put("status", false);
            map.put("message", "Error" + error.getMessage());

            return map;
        }

    }

}
