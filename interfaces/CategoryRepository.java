package mx.com.gm.HolaMundo.interfaces;

import mx.com.gm.HolaMundo.models.Category;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    @Query("SELECT s FROM Todo s WHERE s.name_todo = ?1")
    Optional<Todo> findTodoByName(String name);

}

