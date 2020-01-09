# 스프링 기초 스터디

## github 으로 스터디를 진행하는 방법

1.https://github.com/spring-basic-study/openapi 에서 Fork 한다.

![Fork](https://user-images.githubusercontent.com/16934066/71980765-32493b80-3264-11ea-98e8-bc5e5eb504d4.PNG)

자신의 github 계정에서 fork 한 Repo 를 확인할 수 있다. 

![Fork](https://user-images.githubusercontent.com/16934066/71981322-86a0eb00-3265-11ea-8a25-301213a5723a.PNG)

2.STEP01 이라는 branch 를 생성하고
해당 STEP01 브랜치에 요구사항을 구현한다. 

3.개발이 완료되면 리뷰 요청을 위해 Pull Request 를 날린다.
공식 스터디 계정에 openapi 저장소에 자신의 이름으로 만들어진 브랜치에 PR 요청을 한다.
![Fork](https://user-images.githubusercontent.com/16934066/71981869-9f5dd080-3266-11ea-95fd-5f70de7f4690.PNG)


# 요구사항

## STEP01

1. 네이버 오픈API 를 연동해서, query(파라미터)로 검색어를 전달해서 블로그 정보를 조회한다.
https://developers.naver.com/docs/search/blog/
https://developers.naver.com/docs/common/openapiguide/apilist.md#%EA%B2%80%EC%83%89
2. OpenAPI 연동 URL,인증키 등 정보를 application 파일에 설정
3. application파일에 정의한 정보를 @ConfigurationProperties, @EnableConfigurationProperties 어노테이션을 사용해서 가져오기 
4. "local" profile 로 애플리케이션 실행
5. Embedded Tomcat Port, Max Thread 설정 변경해보기
6. Service or Repository 패키지 레이어로 분리해보기
7. Open API 호출 시 RestTemplate를 사용하며, 별도의 Bean 으로 정의한다.(@Configuration, @Bean 사용)
8. Lombok 버전을 내가 원하는 버전으로 디펜던시 변경해보기


## STEP02

1. STEP01 에서 진행한 블로그 연동과 유사하게, 영화 Open API 를 연동해서 간단한 검색을 제공한다.
2. 블로그, 영화 OpenAPI 구현시 사용한 RestTemplate 호출 구문의 중복을 최소화 해보자.
3. RestTemplate 의 쓰레드풀, TimeOut 등의 설정을 변경해보자.
4. 블로그, 또는 영화 정보 조회 시 LIMIT 로 개수를 제한해본다.


## STEP03

# 아직 미정
