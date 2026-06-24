package com.junit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Entity
@Table(name = "users")
class User {
    @Id
    private Long id;
    private String name;

    public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}

interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}

@DataJpaTest
public class UserRepositoryCustomQueryTest {
    @org.springframework.boot.autoconfigure.SpringBootApplication
    static class Config {}

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Bob");
        User user3 = new User(3L, "Alice");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> results = userRepository.findByName("Alice");
        assertEquals(2, results.size());
        assertEquals("Alice", results.get(0).getName());
        assertEquals("Alice", results.get(1).getName());
    }
}
