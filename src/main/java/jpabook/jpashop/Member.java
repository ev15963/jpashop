package jpabook.jpashop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity; // org.springframework.data.annotation.Id 안됨 시발!!!!!!!!
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity // Entity 클래스 선언(하나의 테이블에 대응하는 클래스)
@Getter
@Setter
public class Member {

    @Id // 식별자로 선언
    @GeneratedValue // 자동생성되게
    private Long id;

//  @JsonIgnore // 객체 반환시 JSON 안나오게 하지만, 엔티티에 넣는것은 올바르지 않다. 엔티티에 화면 출력을 위한 로직이 들어가는 것은 의존성 방향이 뒤틀린다.
    // controller의 CreateMemberRequest 클래스의 NotEmpty로 대체
    private String name;

}
