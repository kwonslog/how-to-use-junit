package com.example.demo.case4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @DataJpaTest 를 사용하면 클래스패스에 인메모리 DB(여기서는 h2) 설정이 있을 경우 자동으로 설정을 잡아준다.
 */
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("user save 테스트")
    void testSaveUser() {
        User user = new User("John Doe", "john.doe@example.com");
        User savedUser = userRepository.save(user);

        System.out.println("savedUser : " + savedUser.toString());

        Assertions.assertNotNull(savedUser.getId());
    }

    @Test
    @DisplayName("user save and find 테스트")
    void testFindUserById() {
        User user = new User("Jane Doe", "jane.doe@example.com");
        User savedUser = userRepository.save(user);
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertNotNull(foundUser);
        Assertions.assertEquals("Jane Doe", foundUser.getName());
        Assertions.assertEquals("jane.doe@example.com", foundUser.getEmail());
    }

    @Sql(scripts = "classpath:test.sql")
    @Test
    @DisplayName("@Sql 을 사용하여 테스트 실행 전에 쿼리 실행하기")
    void testFindUserById2() {
        User user = userRepository.findById(1L).orElse(null);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("John Doe", user.getName());
    }
}