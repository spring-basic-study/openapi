#과제  
[STEP01](#step01)  
[STEP02](#step02)  
[STEP03](#step03)


##STEP01
1. 네이버 오픈API 를 연동해서, query(파라미터)로 검색어를 전달해서 블로그 정보를 조회한다.  
https://developers.naver.com/docs/search/blog/ https://developers.naver.com/docs/common/openapiguide/apilist.md#%EA%B2%80%EC%83%89  
2. OpenAPI 연동 URL,인증키 등 정보를 application 파일에 설정  
3. application파일에 정의한 정보를 @ConfigurationProperties, @EnableConfigurationProperties 어노테이션을 사용해서 가져오기  
4. "local" profile 로 애플리케이션 실행
5. Embedded Tomcat Port, Max Thread 설정 변경해보기
6. Service or Repository 패키지 레이어로 분리해보기
7. Open API 호출 시 RestTemplate를 사용하며, 별도의 Bean 으로 정의한다.(@Configuration, @Bean 사용)
8. Lombok 버전을 내가 원하는 버전으로 디펜던시 변경해보기  

##STEP02  
1. STEP01 에서 진행한 블로그 연동과 유사하게, 영화 Open API 를 연동해서 간단한 검색을 제공한다.
2. 하나의 쿼리 요청에, 블로그 + 영화 정보를 함께 제공하는 API 를 만든다. (Response 스펙은 자유롭게...)
3. 블로그, 영화 OpenAPI 구현시 사용한 RestTemplate 호출 구문의 중복을 최소화 해보자.
4. RestTemplate 의 쓰레드풀, TimeOut 등의 설정을 변경해보자.
5. 블로그, 또는 영화 정보 조회 시 LIMIT 로 개수를 제한해본다. (Open API 호출할때가 아니라) Open API 에서 가져온 데이터를 제한해서 제공  

##STEP03  
1. Swagger 를 적용해본다. 
- 네이버 오픈 API 인증에 실패했을 때(RestTemplate 사용해서 호출하는 로직) 오류가 발생했을때 Exception (예외처리)를 구현해본다.
- @RestControllAdvice, @ExceptionHandler 어노테이션을 활용해본다.
2. 검색결과가 전혀 없는 경우(items가 빈리스트로 적용된 경우)에, 응답 상태코드를 204 로 사용자에게 응답해준다.  
3. 블로그, 영화 정보를 Open API 를 순차적으로 호출하는 방식이 아니라, 병렬 프로그래밍으로 동시에 호출해서 조합하는 방식으로 개선한다.
- 예를 들어서, 1회 요청시 걸리는 시간이 100ms 라고 가정했을 때, 블로그와 영화를 순차적으로 호출하면 200ms 가 걸리지만, 병렬 처리로 100ms 안에 처리되도록 개선해본다.
- 병렬 처리에 대한 쓰레드 설정도 별도로 추가해본다.
4. 네이버 OpenAPI 에서 조회한 데이터를 엔드포인트(컨트롤러)에서 그대로 사용하지말고, 중간에서 DTO 객체로 매핑해서 처리한다.
- 별도의 DTO 클래스를 정의해야 한다.
- 매퍼 라이브러리를 사용하거나, 또는 다른 방식으로 자유롭게 데이터를 매핑해본다.
5. 운영자에 의해 관리되는 "자주 검색되는 영화 쿼리" 정보를 사용해서 데이터를 제공해주는 API 를 심플하게 구현한다. 
- (요구사항이 명확하지 않으므로, 이 내용에 대해서는 스터디 시간에 한번더 논의할 예정)
- "자주 검색되는 쿼리"를 관리하는 RestAPI 엔드포인트를 생성한다.
- POST, GET, DELETE, PUT 등의 메서드를 활용해본다.
- "자주 검색되는 쿼리"는 애플리케이션 메모리에 저장한다.(휘발성)
- 저장하는 자료구조는 자유롭게하면 된다. 단, 심플하고 빠르게 개발하도록 하자.
- "자주 검색되는 데이터"를 사용자에게 제공하는 신규 Controller 를 구현한다.