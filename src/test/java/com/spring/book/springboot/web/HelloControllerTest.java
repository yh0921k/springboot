package com.spring.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
// 테스트를 진행할 때 JUnit에 내장된 실행자 대신 SpringRunner라는 스프링 실행자를 사용한다.
// 즉, 스프링 부트 테스트와 JUnit 사이의 연결자 역할을 한다.
@RunWith(SpringRunner.class)

// 여러 스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션이다.
// 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
// 단, @Service, @Component, @Repository 등을 사용할 수 없다.
// 여기서는 컨트롤러만 사용하기 때문에 선언한다.
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

   // 빈 자동 주입
   @Autowired

   // 웹 API를 테스트할 때 사용한다.
   // 스프링 MVC 테스트의 시작점이다.
   // 이 클래스를 통해 HTTP의 GET, POST 등에 대한 API 테스트를 진행할 수 있다.
   private MockMvc mvc;

   @Test
   public void hello_리턴() throws Exception {
      String hello = "hello";

      mvc.perform(get("/hello")) // MockMvc를 통해 GET 요청, 체이닝을 통해 아래와 같이 검증한다.
              .andExpect(status().isOk())  // perform의 결과 검증, HTTP Header의 Status를 검증한다. 즉, 200, 404, 500 등의 상태를 검증하는데, 여기서는 OK(200)을 검증한다.
              .andExpect(content().string(hello)); // 응답 본문의 내용을 검증한다. 컨트롤러에서 리턴하는 값이 hello 이므로 이를 검증한다.
   }

   @Test
   public void HelloResponseDto_리턴() throws Exception {
      String name = "hello";
      int amount = 1234;

      mvc.perform(get("/hello/dto")
              .param("name", name) // 요청 파라미터 설정(값은 문자열만 가능)
              .param("amount", String.valueOf(amount)))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.name", is(name))) // json 응답을 필드별로 검증($를 사용하여 필드 명시)
              .andExpect(jsonPath("$.amount", is(amount)));
   }
}
