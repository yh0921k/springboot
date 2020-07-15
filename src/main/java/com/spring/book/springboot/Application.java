package com.spring.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부트의 자동 설정, 스프링 빈 읽기와 생성을 모두 자동으로 설정
// 특히 해당 어노테이션의 위치로부터 설정을 읽어나가기 때문에 프로젝트 최상단에 위치해야함
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS 실행(톰캣 설치 필요없음)
        // 이후 스프링 부트로 만들어진 Jar 파일을 실행하면됨
        SpringApplication.run(Application.class, args);
    }
}
