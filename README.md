12.7 (ch1.실습 환경 설정)
  JPA 
  : CRUD 메소드 기본제공.
  쿼리 작성 X
  Mybatis는 쿼리가 수정되어 데이터 정보가 바뀌면 DTO도 수정해야함. 
  -> JPA는 객체만 수정(객체중심개발)
  Mybatis 
  : SQL문을 통해 RDB에 접급.
  SQL문을 직접 작성하여 쿼리 수행 결과를 객체와 매핑.
  
12.8 (ch2.REST API 개발)
  view Resolver
  : 실행한 View를 찾는 역할.
  : 페이지 컨트롤러가 리턴한 View 이름에 해당되는 viewComponent를 찾는 역할 .
    (return 값으로 jsp를 찾음)
  @Controller
  : Spring MVC의 Controller로 주로 View를 반환.
  -> 만약 Data를 반환해야 한다면, @ResponseBody를 활용하여 JSon 형태로 데이터 반환.
  @RestController
  : Contoller에 ResponseBody가 추가된것.
  JSon
  : JavaScript 객체 문법으로 구조화된 데이터를 표현하기 위한 문자 포멧
  (속석-값 쌍)
  Builder 패턴
  : 생성자에 값을 넣어야하는데 인자가 너무 많을 때 사용.

12.9-10 (ch3.JPA 연동)
  - Mapper를 XML이 아니라 Java 파일로 생성.
  - 추상 메소드에 @Insert, @Update, @Delete, @Select를 이용하여 SQL문 등록.
  - @Mapper가 설정된 인터페이스를 작성하면, Mybatis에서 자동으로 Mapper Interface가 구현된 클래스를 제공.
  - 요청 URL에 포함된 id 정보를 매개변수인 id에 할당하기 위해 @PathVariable을 사용.
