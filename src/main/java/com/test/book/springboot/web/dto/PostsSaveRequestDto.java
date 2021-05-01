package com.test.book.springboot.web.dto;

import com.test.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
// Entity와 유사해보이지만 web화면에 띄울내용을 담는 역할(Entity는 실제db라 변경에 유의!)
// 여러 테이블끼리 조인해야할때 dto 새로 만들어서 사용 (Entity는 실제db이므로 변경되면 x)
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
