package mx.com.gm.HolaMundo.interfaces;

import mx.com.gm.HolaMundo.models.Category;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT s FROM Todo s WHERE s.name_todo = ?1")
    Optional<Todo> findTodoByName(String name);

    @Query("SELECT s FROM Todo s WHERE s.id_todo = ?1")
    Optional<Todo> findTodoById(Long id);


    /*

    */
}

