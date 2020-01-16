# Spring Boot Study
* 매주 금요일에 진행하는 스터디 내용과 개인 공부내용을 정리한다.

## 환경
* Spring version 5.x
* Boot 2.2
* Open JDK 11
* Junit5 + AssertJ + Mockito


## Mission
- 1주차 미션 : [네이버 Open API 연동 및 컨텐츠 API 구현](https://github.com/ohtaeg/boot-study-friday/blob/master/docs/mission1.md)
- 2주차 미션 : [2주차 미션](https://github.com/ohtaeg/boot-study-friday/blob/master/docs/mission2.md)
<br>

## I learn
### @SpringBootApplication
- @SpringBootConfiguration
- @ComponentScan
- @EnableAutoConfiguration <br>
@SpringBootApplication 어노테이션은 위 3가지의 어노테이션을 사용하는것과 같다.

### @EnableAutoConfiguration
- 어플리케이션 등록시, 빈을 두 단계를 거쳐 등록 한다.
    1. @ComponentScan
    2. @EnableAutoConfiguration

- 먼저 @ComponentScan으로 빈이 등록이 되는데, @SpringBootApplication 내부에 @ComponentScan을 살펴보면 filter로 AutoConfiguration을 통해 등록되는 빈들을 제외하라고 설정 되어 있다.
- @ComponentScan으로 빈이 등록 된 다음 @EnableAutoConfiguration이 추가적인 빈들을 등록 한다. (ex ServletWebServerFactory )
<pre>
    <code>@ComponentScan(</code>
    <code>    excludeFilters = {@Filter(</code>
    <code>        type = FilterType.CUSTOM,</code>
    <code>        classes = {TypeExcludeFilter.class}</code>
    <code>    ), @Filter(</code>
    <code>        type = FilterType.CUSTOM,</code>
    <code>        classes = {AutoConfigurationExcludeFilter.class} // <-</code>
    <code>    )}</code>
    <code>)</code>
</pre>

- @EnableAutoConfiguration은 추가된 jar dependency 기반으로 Spring application을 자동으로 설정하는 것을 시도한다
- @EnableAutoConfiguration이 빈을 등록하는 방법은 <br>
org.springframework.boot:spring-boot-autoconfigure Library 안의 META-INF/spring.factories 라는 파일에 있는 값들을 읽어 등록 한다. <br>
[spring.factories 파일](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-autoconfigure/src/main/resources/META-INF/spring.factories)
안에 키 밑에 설정되어있는 value(클래스들)들은 다 적용이 된다. <br> 
<pre>
    # Initializers
    org.springframework.context.ApplicationContextInitializer=\
    org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer,\
    org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener
    
    # Application Listeners
    org.springframework.context.ApplicationListener=\
    org.springframework.boot.autoconfigure.BackgroundPreinitializer
    
    # Auto Configuration Import Listeners
    org.springframework.boot.autoconfigure.AutoConfigurationImportListener=\
    org.springframework.boot.autoconfigure.condition.ConditionEvaluationReportAutoConfigurationImportListener
    
    # Auto Configuration Import Filters
    org.springframework.boot.autoconfigure.AutoConfigurationImportFilter=\
    org.springframework.boot.autoconfigure.condition.OnBeanCondition,\
    org.springframework.boot.autoconfigure.condition.OnClassCondition,\
    org.springframework.boot.autoconfigure.condition.OnWebApplicationCondition
    
    # Auto Configure
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
    ....
    ....
</pre>

- 파일 내용을 보면 다 클래스로 명시 되어 있고 각 클래스 내부에는 @Configuration 어노테이션을 통해 빈 설정파일로 등록 된다. <br>
  다만 @ConditionalOn.... 어노테이션에 맞는 조건에 따라 등록되거나 등록이 안되기도 한다. 
  
- ex) WebMvcAutoConfiguration.class
    - @ConditionalOnWebApplication(type = Type.SERVLET) : 웹 어플리케이션 타입이 servlet일 때만 AutoConfigure
    - @ConditionalOnClass({Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class}) <br>
      : 클래스패스에 Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class가 있을 때 AutoConfigure
    <pre>
        <code>@Configuration(</code>
        <code>    proxyBeanMethods = false</code>
        <code>)</code>
        <code>@ConditionalOnWebApplication(type = Type.SERVLET)</code>
        <code>@ConditionalOnClass({Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class})</code>
        <code>@ConditionalOnMissingBean({WebMvcConfigurationSupport.class})</code>
        <code>@AutoConfigureOrder(-2147483638)</code>
        <code>@AutoConfigureAfter({DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class, ValidationAutoConfiguration.class})</code>
        <code>public class WebMvcAutoConfiguration {</code>
        <code>  ...</code>
        <code>}</code>
    </pre>

- 만약 @ComponentScan과 @EnableAutoConfigure가 같은 빈을 등록한다면 @ComponentScan 때 등록한 빈을 @EnableAutoConfigure가 덮어 씌울 것이다. <br>
  덮어쓰는 걸 방지하려면 @ConditionalOnMissingBean를 통해 빈을 등록 못했을때 등록하도록 설정해준다.