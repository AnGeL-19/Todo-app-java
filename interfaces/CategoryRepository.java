package mx.com.gm.HolaMundo.interfaces;

import mx.com.gm.HolaMundo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}

