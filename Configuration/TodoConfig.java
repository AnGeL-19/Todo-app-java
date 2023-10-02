package mx.com.gm.HolaMundo.Configuration;

import mx.com.gm.HolaMundo.interfaces.TodoRepository;
import mx.com.gm.HolaMundo.models.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class TodoConfig {

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository todoRepository){
        return args -> {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            Todo todo1 = new Todo("tarea 1", date);
            Todo todo2 = new Todo("tarea 2", date);

            todoRepository.saveAll(List.of(todo1,todo2));
        };


    }


}
