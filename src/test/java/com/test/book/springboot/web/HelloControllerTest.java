package com.test.book.springboot.web;

import com.test.book.springboot.config.auth.SecurityConfig;
import com.test.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 스프링 부트 테스트와 JUnit 사이의 연결 역할 => JUit 내장 실행자 외의 다른 실행자 실행
@RunWith(SpringRunner.class)
// spring MVC에 집중 => controller,controllerAdvice 사용o / service,repository,componen 사용xa
@WebMvcTest(controllers = HelloController.class,
            excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
            })
public class HelloControllerTest {

    // spring이 관리하는 bean 주입받는다 (DI)
    @Autowired
    private MockMvc mvc; // 웹 API 테스트 시작점 => GET,POST 등의 API 테스트 가능

    @Test
    @WithMockUser(roles = "USER")
    public void returnHello() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // /hello 주수로 HTTP GET 요청
                .andExpect(status().isOk()) // 응답이 200인지 체크
                .andExpect(content().string(hello)); // hello와 동일값 리턴인지 체크
    }

    @Test
    @WithMockUser(roles = "USER")
//callHelloDto  ===> 괄호안붙여서 에러...
    public void returnHelloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount))) //value는 String만 허용
// 여기서 perform은 끝남... 괄호 잘 못닫았음
                .andExpect(status().isOk())
                // json응답값을 필드별로 검증 / $ 기준으로 필드명 명시
// is함수 import 잘못해서 에러 뜸...
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
