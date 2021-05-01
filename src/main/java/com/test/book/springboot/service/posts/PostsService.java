package com.test.book.springboot.service.posts;

import com.test.book.springboot.domain.posts.PostsRepository;
import com.test.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // final 필드 생성자를 알아서 lombok에서 생성 => 코드변경돼도 생성자코드수정 불필요
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
