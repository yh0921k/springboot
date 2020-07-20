package com.spring.book.springboot.web;

import com.spring.book.springboot.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        // assertj라는 테스트 검증 라이브러리의 메서드
        // 검증하고 싶은 대상을 메서드 인자로 받는다.
        // isEqualTo는 assertThat에 있는 값과 같을 때만 성공한다.
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
