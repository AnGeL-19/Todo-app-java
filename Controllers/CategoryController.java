package mx.com.gm.HolaMundo.Controllers;

import mx.com.gm.HolaMundo.Services.CategoryService;
import mx.com.gm.HolaMundo.models.Category;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public Map<String, Object> getCategory() {

        List<Category> categories = this.categoryService.getCategory();

        Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result

        map.put("status", true);
        map.put("message", "Data is found");
        map.put("data", categories);

        return map;

    }


    @PostMapping("/")
    public Map<String, Object> registerCategory(@RequestBody Category category) {

        this.categoryService.addNewCategory(category);

        Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result

        map.put("status", true);
        map.put("message", "Registered success");

        return map;

    }


    @DeleteMapping("/{id_todo}")
    public Map<String, Object> deleteCategory(@PathVariable("id_todo") Long id){
        this.categoryService.deleteCategory(id);

        Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result

        map.put("status", true);
        map.put("message", "Registered success");

        return map;

    }


    @PutMapping("/{id_todo}")
    public Map<String, Object> updateCategory(@PathVariable("id_todo") Long id, @RequestBody Category category){
        this.categoryService.updateCategory(id, category);

        Map<String, Object> map = new HashMap<String, Object>(); // use new HashMap<String, Object>(); for single result

        map.put("status", true);
        map.put("message", "Registered success");

        return map;
    }


}
