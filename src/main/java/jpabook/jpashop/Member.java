package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity; // org.springframework.data.annotation.Id 안됨 시발!!!!!!!!
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // Entity 클래스 선언(하나의 테이블에 대응하는 클래스)
@Getter
@Setter
public class Member {

    @Id // 식별자로 선언
    @GeneratedValue // 자동생성되게
    private Long id;
    private String username;
}
