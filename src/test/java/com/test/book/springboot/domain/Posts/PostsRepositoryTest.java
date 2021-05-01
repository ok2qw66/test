package com.test.book.springboot.domain.Posts;

import com.test.book.springboot.domain.posts.Posts;
import com.test.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest // h2 db 자동 실행
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @After // Junit 단위 테스트가 끝날 때마다 수행
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void callPosts(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        //id 있으면 update , id 없으면 insert 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("test@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void RegisterBaseTimeEntity(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,5,2,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>> createdTime="+posts.getCreatedDate()+
                            ", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}