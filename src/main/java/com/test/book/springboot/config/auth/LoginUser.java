package com.test.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션이 생성될 수 있는 위치 지정
// PARAMETER로 지정 => 메소드의 파라미터 객체에서만 사용 가능
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// @interface : 어노테이션 클래스 , @LoginUser 어노테이션 생성
public @interface LoginUser {
}
