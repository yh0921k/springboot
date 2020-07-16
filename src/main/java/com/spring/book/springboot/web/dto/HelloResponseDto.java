package com.spring.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 필드에 대한 get 메서드 생성
@RequiredArgsConstructor // final 필드를 모두 포함한 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
