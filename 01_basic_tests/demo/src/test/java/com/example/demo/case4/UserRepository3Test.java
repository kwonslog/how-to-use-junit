package com.example.demo.case4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

/**
 * @DataJpaTest 를 사용하면 클래스패스에 인메모리 DB(여기서는 h2) 설정이 있을 경우 자동으로 설정을 잡아준다.
 */
@DataJpaTest
class UserRepository3Test {

    @MockBean
    private UserRepository mockUserRepository;

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