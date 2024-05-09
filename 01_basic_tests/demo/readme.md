## 이 프로젝트에 대한 설명

### com.example.demo.case1 패키지
 - HTTP 메소드 GET, POST, PUT, DELETE 에 대한 컨트롤러를 작성했다.
 - 각각 junit 으로 테스트 하였다.

### com.example.demo.case2 패키지
 - 컨트롤러에서 UserDTO 를 리턴한다.
 - 리턴한 결과는 JSON 으로 변환되는데 해당 값에 대한 테스트를 작성 하였다.
 - @MockBean, org.mockito.BDDMockito.given 메소드를 사용하여 테스트 하였다.

### com.example.demo.case3 패키지
 1. @ExtendWith(SpringExtension.class), @Import 사용하여 테스트 케이스 작성.
 2. @ExtendWith(SpringExtension.class), @Import, @MockBean 사용하여 테스트 케이스 작성.
 3. @ExtendWith(MockitoExtension.class), @InjectMocks, @Mock 사용하여 테스트 케이스 작성.

 - 1~3번 모두 동일한 케이스에 대한 테스트를 진행하지만 각각 테스트를 수행하는 방식에 차이점을 두었다.

### com.example.demo.case4 패키지
 - @DataJpaTest 를 사용하여 테스트 케이스 작성 하였다.
 - @MockBean, org.mockito.Mockito.when 메소드를 사용하는 테스트도 작성 하였다.
