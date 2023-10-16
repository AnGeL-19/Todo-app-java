package mx.com.gm.HolaMundo.Services;

import jakarta.transaction.Transactional;
import mx.com.gm.HolaMundo.Helpers.FilterFindObj;
import mx.com.gm.HolaMundo.interfaces.Category_TodoRespository;
import mx.com.gm.HolaMundo.interfaces.TodoRepository;
import mx.com.gm.HolaMundo.models.Category;
import mx.com.gm.HolaMundo.models.Category_Todo;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final Category_TodoRespository category_TodoRespository;

    @Autowired
    public TodoService(TodoRepository todoRepository, Category_TodoRespository category_TodoRespository) {
        this.todoRepository = todoRepository;
        this.category_TodoRespository = category_TodoRespository;
    }


    public List<Todo> getTodos() {
        return this.todoRepository.findAll();

    }

    public Todo getTodoById(Long id) {

        Todo todo = this.todoRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("id_todo " + id + " no exists")
        );

        return todo;
    }

    public void addNewTodo(Todo todo){

        Optional<Todo> optionalTodo = this.todoRepository.findTodoByName(todo.getName_todo());
        if(optionalTodo.isPresent()){
            throw new IllegalStateException("name_todo taken");
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        Todo newTodo = new Todo(todo.getName_todo(), date );

        Long idTodo = this.todoRepository.save(newTodo).getId_todo();


        List<Category_Todo> categoriesTodo = new ArrayList<Category_Todo>();

        for (Category category: todo.getCategories()) {
            categoriesTodo.add(new Category_Todo(idTodo, category.getId_category()));
        }

        this.category_TodoRespository.saveAll(categoriesTodo);

    }

    public void deleteTodo(Long id) {

        boolean exists = this.todoRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("id_todo no exists");
        }

        this.todoRepository.deleteById(id);
    }

    @Transactional
    public void updateTodo(Long id, Todo todo){


        Todo respTodo = this.todoRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("id_todo "+id+" no exists")
        );

        if (!todo.getName_todo().isEmpty() && !Objects.equals(respTodo.getName_todo(), todo.getName_todo())){
            respTodo.setName_todo(todo.getName_todo());
        }

        List<Category> categoryTodosAdd = new ArrayList<>();
        List<Category> categoryTodosDel = new ArrayList<>();

        if (respTodo.getCategories().toArray().length == 0 && todo.getCategories().toArray().length == 0){
        }else if (respTodo.getCategories().toArray().length == 0) {

            categoryTodosAdd.addAll(todo.getCategories());

        }else if (todo.getCategories().toArray().length == 0) {

            categoryTodosDel.addAll(respTodo.getCategories());

        }else {

            categoryTodosDel.addAll(FilterFindObj.filterFindTwoObjets(
                    respTodo.getCategories(),
                    todo.getCategories())
            );

            categoryTodosAdd.addAll(FilterFindObj.filterFindTwoObjets(
                    todo.getCategories(),
                    respTodo.getCategories()
            ));
        }

        List<Category_Todo> categoriesTodoAdd = new ArrayList<>();
        List<Category_Todo> categoriesTodoDel = new ArrayList<>();

        if (categoryTodosAdd.toArray().length != 0){

            for ( Category category: categoryTodosAdd) {
                categoriesTodoAdd.add(new Category_Todo(respTodo.getId_todo(), category.getId_category()));
            }
            this.category_TodoRespository.saveAll(categoriesTodoAdd);
        }


        if (categoryTodosDel.toArray().length != 0) {

            for ( Category category: categoryTodosDel) {

                Long id_categorytodo = this.category_TodoRespository.findCategoryTodo(
                        category.getId_category(),
                        respTodo.getId_todo()
                );

                categoriesTodoDel.add(new Category_Todo(id_categorytodo ,respTodo.getId_todo(), category.getId_category()));
            }
            this.category_TodoRespository.deleteAll(categoriesTodoDel);
        }

    }

}
