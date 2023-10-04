package mx.com.gm.HolaMundo.Services;

import jakarta.transaction.Transactional;
import mx.com.gm.HolaMundo.interfaces.CategoryRepository;
import mx.com.gm.HolaMundo.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory() {
        return this.categoryRepository.findAll();

    }

    public void addNewCategory(Category category){

        /*
        if(optionalTodo.isPresent()){
            throw new IllegalStateException("name_todo taken");
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        todo.setCreate_at(date);

        System.out.println(todo);
*/
        this.categoryRepository.save(category);

    }

    public void deleteCategory(Long id) {

        /*
        Optional<Todo> optionalTodo = this.todoRepository.findTodoById(id);
        if(optionalTodo.isEmpty()){
            throw new IllegalStateException("id_todo no exists");
        }

        boolean exists = this.todoRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("id_todo no exists");
        }

        this.todoRepository.deleteById(id);
        */

    }

    @Transactional
    public void updateCategory(Long id, String name){

/*
        Todo todo = this.todoRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("id_todo"+id+"no exists")
        );

        if (!name.isEmpty() && !Objects.equals(todo.getName_todo(), name)){
            todo.setName_todo(name);
        }
*/


    }


}
