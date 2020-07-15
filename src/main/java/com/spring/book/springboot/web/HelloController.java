package com.spring.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 반환하는 컨트롤러, @ResponseBody 포함
public class HelloController {
   // HTTP의 메서드인 GET 요청 처리
   // 예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용했었음
   @GetMapping("/hello")
   public String hello() {
      return "hello";
   }
}
