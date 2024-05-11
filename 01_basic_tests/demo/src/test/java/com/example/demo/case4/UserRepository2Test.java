package com.example.demo.case4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @TestPropertySource 를 사용하여 테스트 환경에 있는 h2 DB의 데이터소스를 설정하는 것을 확인해 본다.
 *
 */
@DataJpaTest

// 1. 자동 구성된 것이 아닌 직접 h2 db 데이터소스를 설정하였다.
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
        "spring.datasource.driverClassName=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
})
// 2. 기대한 결과는 설정한 스키마(testdb)가 사용되는 것이었지만 사용되지 않았다.
// 3. 이유를 확인해보니 @DataJpaTest 안에서 사용되는 @AutoConfigureTestDatabase 어노테이션과 관련이 있었다.
//    (@AutoConfigureTestDatabase의 기본값은 Replace.ANY)
// 4. 해당 설정값으로 인해 내가 직접 설정한 값이 사용되지 않았다.
// 5. 해결을 위해 아래 AutoConfigureTestDatabase.Replace.NONE 속성을 추가하였고, testdb 스키마가 사용되는 것을 확인 하였다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

/*
  추가. 인메모리 DB 가 아닌 경우에도 동일한지 마리아 db 로 테스트해 보았고 동일한 결과를 확인했다.
  ** 정리1
     @DataJpaTest 를 사용할때 내가 원하는 DB를 지정해야만 할 경우
     @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 설정값 적용이 필요하다.
  ** 정리2
     @DataJpaTest는 간결한 테스트를 위해 클래스패스에 인메모리 DB가 있으면 자동으로 구성하여 사용하기 때문에
     내가 직접 설정한 값이 무시 될 수 있다.
  ** 정리3
     마리아 DB를 사용한 경우 spring.jpa.hibernate.ddl-auto=create-drop 설정값을 추가해야 한다.
     추가하지 않을 경우 자동으로 테이블을 생성하지 않는다.
      - 특이점. h2 db를 사용하면 자동으로 테이블을 생성하기 때문에 추가 설정값이 필요없었다.

  ** 아래는 마라아 DB 를 사용하여 테스트한 순서를 정리하였다.
   0. 데이터 소스 설정.
      @TestPropertySource(properties = {
           "spring.datasource.url=jdbc:mariadb://localhost:3306/testdb",
           "spring.datasource.driverClassName=org.mariadb.jdbc.Driver",
           "spring.datasource.username=root",
           "spring.datasource.password=root",
           "spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect",
           "spring.jpa.hibernate.ddl-auto=create-drop"
      })
   1. 마리아 db 도커 컨테이너를 포트 3306, MARIADB_ROOT_PASSWORD=root 설정을 추가하고 실행.
   2. MariaDB JDBC 드라이버 추가 runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
   3. testdb 스키마 생성.
   4. 테스트 실행이 정상적으로 되는 것을 확인함.
 */

class UserRepository2Test {

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
}