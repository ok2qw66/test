package com.test.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부트의 자동설정/스프링 bean 읽기,생성 자동 설정
// 현위치부터 설정 읽는다 ==>**항상 프로젝트 최상단에 위치!!**
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 was 실행 => 언제나 같은 환경에서 스프링 부트 배포 가능
        SpringApplication.run(Application.class,args);
    }
}
