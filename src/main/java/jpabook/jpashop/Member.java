package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity; // org.springframework.data.annotation.Id 안됨 시발!!!!!!!!
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id // 식별자로 선언
    @GeneratedValue // 자동생성되게
    private Long id;
    private String username;
}
