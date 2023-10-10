package mx.com.gm.HolaMundo.interfaces;

import mx.com.gm.HolaMundo.models.Category_Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Category_TodoRespository extends JpaRepository<Category_Todo, Long> {

    /*

     */
    @Query(value = "SELECT MAX(ct.id_categorytodo) FROM category_todo ct WHERE ct.id_category = ?1 and ct.id_todo = ?2",
            nativeQuery = true)
    Long findCategoryTodo(Long id_category, Long id_todo);



}
