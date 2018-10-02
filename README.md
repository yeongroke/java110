# java110
비트캠프 **자바 110기** 실습 프로젝트 

## java110-project-01
- 자바 프로젝트 폴더 생성
- `gradle init --type java-application` 실행
- *bulid.gradle* 파일에 `id 'eclipse'`플러그인 추가
- `gradle eclipse` 실행하여 이클립스 설정 파일을 생성
- 이클립스로 프로젝트를 임포트

## java110-project(tag v0.1)
- 반복 문 활용

## java110-project(tag v0.2)
- 배열을 활용

## java110-project(tag v0.3)
- 메서드를 이용하여 리팩토리

## java110-project(tag v0.4)
- 클래스활용

## java110-project (tag: v0.5)

- 조건문, 반복문, 메서드 활용

## java110-project (tag: v0.6)

- 패키지 활용 및 클래스의 접근 범위

## java110-project (tag: v0.7)

- 목록 다루기

## java110-project (tag: v0.8)

- 목록을 다루는 클래스를 리팩토링하기
- 다형적 변수를 사용하여 활용법
- 클래스 멤버(변수,메서드,블록)와 인스턴스 멤버의 차이점
- 생성자 사용

## java110-project (tag: v0.9)

- 제네릭 활용법
- arraylist에 제네릭 적용하기

## java110-project (tag: v0.9.1)

- LinkedList 생성 , add()/get() 구현 

## java110-project (tag: v1.0)

- Linkeclist 생성

## java110-project (tag: v1.1)

- 인터페이스 적용
- 데이터 목록을 다룰 때 호출하는 메서드의 규칙을 정의한다.
    - 다양한 방법으로 구현한 객체를 사용할 수 있다.
    - 즉 규칙을 따르기만 한다면 어떤 객체라도 대체할 수 있다.
- 인터페이스의 default
- 의존 객체 주입

## java110-project (tag: v1.2)

- 자바 컬렉션 API 사용

## java110-project (tag: v1.3)

- 인터페이스 활용
- App 클래스와 Controller 들 사이의 호출규칙(사용규칙)을 
인터페이스로 정의한다.

## java110-project (tag: v1.4)

- 리플렉션 API 활용
- 미니 IoC 컨네이너 작성
- File 클래스로 디렉토리 및 파일 다루기

## java110-project (tag: v1.4.1)

- 메서드의 애노테이션 적용

## java110-project (tag: v1.4.2)

- 애노테이션 적용

## java110-project (tag: v1.5)

- 리플렉션 API 활용 II
- 애노테이션 활용
- 미니 IoC 컨테이너 개선
- 작업
    - 자동으로 생성되어야 할 객체에 붙일 애노테이션 정의
    - 컨트롤러 객체에 애노테이션 적용
    - 애노테이션이 붙은 클래스만 객체를 생성

## java110-project (tag: v1.6)

- Command design pattern 적용
- Controller 구조 변경
- 작업
    - 컨트롤러에서 명령을 처리하는 각각의 메서드를 
    별도의 클래스로 분리한다.

## java110-project (tag: v1.7)

- DAO(Data Access Object) 도입하기
    - 데이터를 저장하는 방식이 바귀더라도 기존 클래스에 영향을
    주지 않게 하려면, 데이터를 다루는 부분을 List가 아니라 별도의 클래스로 정의해야 한다.
    - 즉 List를 통해 데이터를 메모리에 저장하는 대신에 파일이나
    데이터베이스에 저장한다면 기존 코드를 변경해야 하는 문제가 있다.
    - 이 부분을 해결하기 위함이다.
- 작업
    - 학생관리, 강사관라, 매니저관리 각각에 사용 할 DAO클래스를 정의한다.

## java110-project (tag: v1.8)

- 의존 객체 주입하기
- 미니 IoC 컨테이너 개선
- 작업
    - 의존 객체를 주입 받을 수 있도록 setter를 준비한다.
    - IoC 컨테이너가 setter를 자동으로 호출하도록 애노테이션으로 표시한다.
    
## java110-project (tag: v1.9)

- IoC 컨테이너가 객체 생성 후에 수행하는 작업을 별도의 클래스로 분리한다.
- 향후 객체 생성 후에 또 다른 작업을 추가하기 쉽도록 한다.
- 작업
    - 객체 생성 후에 수행할 작업 별도의 클래스로 분리한다.

## java110-project (tag: v2.0)

- DAO에 파일 입출력 도입
- DAO에 인터페이스 적용
- 작업
    - DAO에 데이터를 파일로 저장하고 읽는 기능 추가

## java110-project (tag: v2.0.1)

- DAO구현체를 별도의 패키지로 구현

## java110-project (tag: v2.1)

- 객체 Serialize/Deserialize 적용
- java.io.Serialize 인터페이스 활용
- transient modifier 사용법

## java110-project (tag: v2.2)

- 예외처리 적용
- 예외처리 문법이 없던 시절
    - 리턴 값으로 예외 상황을 호출자에게 알렸다.
    - 특정 타입의 값을 리턴하는 경우 이 방법을 쓰기 곤란하다.
- 그래서 예외처리 문법이 등장
    - 리턴 값이 아닌 별도의 경로로 예외 상황을 호출자에게 알린다.
    - 이전 방식에 비해 메서드의 리턴 타입에 영향을 받지 않는다.
    - 예외 상황을 자세하게 호출자에게 알릴 수 있다.
    
## java110-project (tag: v2.3)

- DAO에 JDBC 적용
- 작업
    - Data Modeling과 forward engineering 수행
    - 테이블 준비
    - JDBC API 활용
    - 트랜잭션 다루기

## java110-project (tag: v2.4)

- DB 커넥션 공유하기
- impl폴더를 각 mysql 하나씩 정리
- DB 연결 객체를 재사용하며 가비지를 줄이고, 실행 속도를 높이기 위함

## java110-project (tag: v2.5)

- Spring IoC 컨네이너 도입
- 기존에 만들었떤 ApplicationContext 대신에 Spring 프레임워크에서
제공하는 ApplicationContext 사용하기
- 작업
    - Spring IoC 컨테이너 라이브러리 추가(build.gradle 파일 편집)
        - "Spring context" 로 mvnrepositroy.com에서 검색한다.
        - 명령창에서 project폴더 안에서 ">gradle eclipse" 실행한다.
        - 이클립스에서 프로젝트를 새로고침한다.
    - Spring 설정 파일 추가(application_context.xml)
        - bitcamp/java110/cms/conf/application-context.xml

## java110-project (tag: v2.6)

- Client/Server 구조로 변경
- 소켓 프로그래밍 구현
- 멀티스레딩 구현
- 프로토코 개념 이해

## java110-project (tag: v2.7)

- 멀티스레드 적용하기(Connection-Oriented에서 Stateful방식으로 요청 처리)
- 별도의 스레드를 만들어 클라이언트의 요청을 처리하게 한다.
- 즉 동시에 여러 클라이언트 요청을 처리한다.

## java110-project (tag: v2.8)

- 멀티스레드 적용하기(Connection-Oriented에서 Stateless방식으로 요청 처리)

## java110-project (tag: v2.9)

- 웹브라우저를 클라이언트로 사용하기
- 서버에 HTTP 프로토콜을 처리하는 기능 추가

## java110-project (tag: v3.0)

- 웹서버를 중계 서버로 사용하기
- 서블릿 컨테이너 적용

## java110-project (tag: v3.1)

- 웹서버를 중계 서버로 사용하기
- 서블릿 컨테이너 적용

## java110-project (tag: v4.0)

- 서블릿 기술을 적용하여 서버 애플리케이션 만들기
- 작업
    - 클라이언트 요청을 처리하는 컨트롤러를 서블릿으로 전환한다.

## java110-project (tag: v4.1)

- 서블릿의 loadOnStartUp 배치 속성을 이용하여 공용 자원을 준비하기
- ServletContext를 이용하여 공용자원을 공유하기
- 작업
    - InitServlet 클래스 속성
    - InitServlet에서 DAO와 DataSource 준비하기
    - ServletContext에 DAO 보관하기

## java110-project (tag: v4.2)

- 리스너를 이용하여 공용 자원을 준비하기
- 작업
    - ContextLoaderListener 클래스 생성
    - 이 리스너에서 DAO 준비하기

## java110-project (tag: v4.3)

- HTML 출력하기
- 작업
    - 서블릿의 출력 콘텐트를 일반 텍스트에서 HTML로 바꾼다.

## java110-project (tag: v4.4)

- 리프래시. 리다이렉트 적용하기
- 작업
    - 등록, 삭제한 후에 목록 페이지를 자동으로 요청하도록 리프래시 적용

## java110-project (tag: v4.5 , v4.5.1)

- 포워드, 인클루드 적용하기
- 작업
    - 여러 서블릿에서 공통으로 수행하는 작업을 별도의 서블릿으로 분리한다.
    - 그 서블릿으로 포워드를 수행한다.
    - 예1) ErrorSerlvet 클래스 생성하고 포워드(forward)를 적용한다
    - 예2) HeaderServlet, FooterServlet 클래스를 생성하고 인클루드를 적용한다.

## java110-project (tag: v4.6)

- 쿠키 적용하기
- 작업
    - 로그인 폼을 작성한다.
    - 아이디 저장 기능을 쿠키로 구현한다.

## java110-project (tag: v4.7)

- 세션 적용하기
- 작업
    - 로그인 후 회원 정보를 세션에 저장한다.
    - 페이지 헤더에 로그인 사용자의 이름을 출려한다.
        -
    - 로그인 되어 있지 않은 경우, 로그인 링크를 출력한다.
    - 로그아웃 기능을 추가한다.