package com.spring.book.springboot.web;

import com.spring.book.springboot.web.dto.HelloResponseDto;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 반환하는 컨트롤러, @ResponseBody 포함
public class HelloController {
   // HTTP의 메서드인 GET 요청 처리
   // 예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용했었음
   @GetMapping("/hello")
   public String hello() {
      return "hello";
   }

   @GetMapping("/hello/dto")
   // @RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
   public HelloResponseDto helloDto(@RequestParam("name") String name,
                                    @RequestParam("amount") int amount) {
      return new HelloResponseDto(name, amount);
   }
}
