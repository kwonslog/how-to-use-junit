## 이 프로젝트에 대한 설명

### com.example.demo.case1 패키지
#### Controller1Test
 - HTTP 메소드 GET, POST, PUT, DELETE 에 대한 컨트롤러를 작성했다.
 - 각각 junit 으로 테스트 하였다.
---

### com.example.demo.case2 패키지
#### Controller2Test
 - 컨트롤러에서 UserDTO 를 리턴한다.
 - 리턴한 결과는 JSON 으로 변환되는데 해당 값에 대한 테스트를 작성 하였다.
 - @MockBean, org.mockito.BDDMockito.given 메소드를 사용하여 테스트 하였다.
---

### com.example.demo.case3 패키지
- 모두 동일한 케이스에 대한 테스트를 진행하지만 각각 테스트를 수행하는 방식에 차이점을 두었다.

#### Service3Test
 - @ExtendWith(SpringExtension.class), @Import 사용하여 테스트 케이스 작성.
#### Service31Test
 - @ExtendWith(SpringExtension.class), @Import, @MockBean 사용하여 테스트 케이스 작성.
#### Service32Test
 - @ExtendWith(MockitoExtension.class), @InjectMocks, @Mock 사용하여 테스트 케이스 작성.
---

### com.example.demo.case4 패키지
#### UserRepositoryTest
 - @DataJpaTest 를 사용하여 테스트 케이스 작성 하였다.
 - @Sql 을 사용하여 테스트 실행 insert 쿼리를 실행하고 다시 조회하는 테스트 케이스를 작성 하였다.

#### UserRepository2Test
 - @TestPropertySource 를 사용하여 테스트 DB 데이터소스를 직접 설정 하였다.
 - 마리아 DB를 사용 할 경우 @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 설정값이 필요했다.
 - @DataJpaTest는 클래스패스에 인메모리 db가 있을 경우 자동으로 구성하여 사용 한다.(@AutoConfigureTestDatabase 사용)
 - 그래서 @TestPropertySource 를 사용하는 경우에는 추가 설정값(replace = AutoConfigureTestDatabase.Replace.NONE)이 필요하다.

#### UserRepository3Test
- @DataJpaTest 를 사용하여 테스트 케이스 작성 하였다.
- @MockBean, org.mockito.Mockito.when 메소드를 사용하는 테스트도 작성 하였다.
```java
class UserRepositoryTest {
    
    // 하나는 실제, 하나의 모의(mock) 객체를 주입 받도록 동시에 사용하고 있다.
    // 이 경우 모의(mock) 객체가 실제 객체를 오버라이드 하게 되어 
    // userRepository 또한 모의 객체가 주입되는 것을 확인 하였다.
    // 그래서 userRepository 와 mockUserRepository 를 분리하여 테스트 하였다.
    @Autowired
    private UserRepository userRepository;

    @MockBean
    private UserRepository mockUserRepository;
    
    ...생략
}

```

### com.example.demo.case5 패키지
#### Service5Test, Service51Test
- @TestConfiguration 을 사용하는 테스트를 하였다.(간단하게 메소드 하나만 변경하여 테스트 실행.) 
- @TestConfiguration 은 테스트 환경을 위한 복잡한 설정값들이 필요할 경우 사용하면 된다.

### com.example.demo.case6 패키지
- Person 객체를 만들어 json 직렬화/역직렬화 테스트를 하였다.