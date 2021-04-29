package com.test.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


// Lombok : getter,setter,constructor, toString 자동 생성
// 선언된 모든 필드의 get메소드 생성해준다
@Getter
// 선언된 모든 final 필드가 포함된 constructor 생성(final아닌것은 미포함)
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
