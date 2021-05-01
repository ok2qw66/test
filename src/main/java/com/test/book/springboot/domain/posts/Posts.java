package com.test.book.springboot.domain.posts;

import com.test.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //getter 자동 생성
@NoArgsConstructor //기본 생성자 추가 Posts(){}
@Entity //테이블과 링크될 클래스 ==> SalesManager.java -> sales_manager table로 인식
public class Posts extends BaseTimeEntity {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 : auto_increment
    private Long id;

    @Column(length =500, nullable = false) // VARCHAR(500)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 타입을 TEXT로 변경
    private String content;

    private String author; //@Column 선언 안해도 칼럼으로 설정됨

    @Builder // 생성자와 같은 역할이지만 어느 필드에 어떤 값을 채워야 할지 명확하게 인지가능
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
