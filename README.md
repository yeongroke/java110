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