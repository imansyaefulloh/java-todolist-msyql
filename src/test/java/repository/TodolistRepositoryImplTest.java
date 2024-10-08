package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodolistRepository todolistRepository;

    @BeforeEach
    public void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
    }

    @AfterEach
    public void tearDown() {
        dataSource.close();
    }

    @Test
    public void testAdd() {
        Todolist todolist = new Todolist();
        todolist.setTodo("Syaefulloh");

        todolistRepository.add(todolist);
    }

    @Test
    public void testRemove() {
        System.out.println(todolistRepository.remove(1));
        System.out.println(todolistRepository.remove(2));
        System.out.println(todolistRepository.remove(3));
        System.out.println(todolistRepository.remove(4));
    }

    @Test
    public void testGetdAll() {
        todolistRepository.add(new Todolist("Iman"));
        todolistRepository.add(new Todolist("Syaefulloh"));
        todolistRepository.add(new Todolist("Syaefulloh XXX"));

        Todolist[] todolists = todolistRepository.getAll();

        for (var todo : todolists) {
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }
}
