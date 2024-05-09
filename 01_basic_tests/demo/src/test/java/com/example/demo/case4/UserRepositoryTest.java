package com.example.demo.case4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @MockBean
    private UserRepository mockUserRepository;

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

    @Test
    @DisplayName("mock user save 테스트")
    void mockTestSaveUser() {

        // ArgumentMatchers.any() : 어떤값이든 상관없이 save 메소드가 호출 되면 thenReturn 에 설정한 값을 리턴한다.
        when(mockUserRepository.save(ArgumentMatchers.any())).thenReturn(
                User.builder()
                        .id(100L)
                        .name("John Doe")
                        .email("john.doe@example.com")
                        .build());

        User savedUser = mockUserRepository.save(null);

        System.out.println("savedUser : " + savedUser.toString());

        Assertions.assertNotNull(savedUser.getId());
    }


}