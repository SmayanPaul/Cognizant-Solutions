package com.junit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

interface UserRepository extends CrudRepository<User, Long> {}

@Service
class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

@SpringBootTest(classes = UserIntegrationTest.Config.class)
public class UserIntegrationTest {
    @org.springframework.boot.autoconfigure.SpringBootApplication
    static class Config {}

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndGetUser() {
        User user = new User(10L, "Charlie");
        userService.saveUser(user);

        User retrieved = userService.getUserById(10L);
        assertNotNull(retrieved);
        assertEquals("Charlie", retrieved.getName());
    }
}
