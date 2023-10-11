package mx.com.gm.HolaMundo.Services;

import jakarta.transaction.Transactional;
import mx.com.gm.HolaMundo.interfaces.CategoryRepository;
import mx.com.gm.HolaMundo.interfaces.Category_TodoRespository;
import mx.com.gm.HolaMundo.models.Category;
import mx.com.gm.HolaMundo.models.Category_Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final Category_TodoRespository category_TodoRespository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, Category_TodoRespository category_TodoRespository) {
        this.category_TodoRespository = category_TodoRespository;
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

        Category respCategory = this.categoryRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("id_category "+id+" no exists")
        );

        List<Category_Todo> categoriesTodoDel = this.category_TodoRespository.
                findCategoryTodoByIdCategory(respCategory.getId_category());

        if (categoriesTodoDel != null && categoriesTodoDel.toArray().length != 0){
            this.category_TodoRespository.deleteAll(categoriesTodoDel);
        }

        this.categoryRepository.deleteById(id);

    }

    @Transactional
    public void updateCategory(Long id, Category category){


        Category respCategory = this.categoryRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("id_category "+id+" no exists")
        );


        if (category.getName_category() != null && !category.getName_category().isEmpty() && !Objects.equals(category.getName_category(),
                respCategory.getName_category())){
            respCategory.setName_category(category.getName_category());
        }

        if (category.getColor() != null && !category.getColor().isEmpty()  && !Objects.equals(category.getColor(),
                respCategory.getColor())){
            respCategory.setColor(category.getColor());
        }


    }


}
