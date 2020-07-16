package com.spring.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // Posts 클래스로 데이터베이스에 접근하게 해줄 JpaRepository
    // 보통 ibatis나 MyBatis에서 DAO로 불리는 DB 레이어 접근자이다.
    // JPA에서는 Repository라고 부르며, 인터페이스로 생성한다.
    // 이후 JpaRepository<Entity Type, PK Type>를 상속하면 기본적인 CRUD 메서드가 자동으로 생성된다.
    // 주의할 점은 Entity 클래스와 Repository는 같은 위치에 있어야 한다는 것이다.
}
