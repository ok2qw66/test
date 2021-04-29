package com.test.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void lombok_test() throws Exception {
        //given
        String name = "test";
        int amount = 2000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertThat : 테스트 검증 라이브러리의 검증 메소드
        // assertj의 assertThat 사용 => 추가 라이브러리 필요x, 자동완성 더 확실히 지원
    }
}
