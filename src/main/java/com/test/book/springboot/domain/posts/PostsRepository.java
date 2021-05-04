package com.test.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// mybatis의 Dao == JPA의 Repository extens JpaRepository<Entity 클래스, PK 타입>
// Posts Entity 사용하려면 PostsRepository와 같은 위치에 있어야 한다
public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
