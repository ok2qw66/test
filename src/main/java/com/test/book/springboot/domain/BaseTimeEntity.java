package com.test.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 해당 클래스 상속하면 createdDate/modifiedDate 칼럼으로 인식해 사용가능
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 추가
public abstract class BaseTimeEntity {

    @CreatedDate // entity 생성시 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //entity 수정시 시간 자동 저장
    private LocalDateTime modifiedDate;
}
