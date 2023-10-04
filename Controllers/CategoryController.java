package mx.com.gm.HolaMundo.Controllers;

import mx.com.gm.HolaMundo.Services.CategoryService;
import mx.com.gm.HolaMundo.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> getCategory() {

        return this.categoryService.getCategory();

    }


    @PostMapping("/")
    public void registerCategory(@RequestBody Category category) {
        this.categoryService.addNewCategory(category);
    }

    /*
    @DeleteMapping("/{id_todo}")
    public void deleteTodo(@PathVariable("id_todo") Long id){
        this.todoService.deleteTodo(id);
    }

    @PutMapping("/{id_todo}")
    public void updateTodo(@PathVariable("id_todo") Long id, @RequestParam(required = false) String name_todo){
        this.todoService.updateTodo(id,name_todo);
    }
    */

}
