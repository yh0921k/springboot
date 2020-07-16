package com.spring.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA 엔티티 클래스들이 BaseTimeEntity를 상속할 경우 날짜 필드도 컬럼으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class) // 이 클래스에 Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity { // 모든 엔티티의 상위 클래스가 되어 엔티티들의 생성, 수정 날짜를 자동으로 관리한다.

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
