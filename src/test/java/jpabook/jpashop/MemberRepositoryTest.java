package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)    // Spring관련 테스트임을 알려줌.
@SpringBootTest // 테스트 클래스 선언
public class MemberRepositoryTest {

    // MemberRepository 테스트하기 위한 주입
    @Autowired
    MemberRepository memberRepository;

    @Test   // Repository의 save, find 테스트
    @Transactional  // EntityManager를 통한 모든 데이터 변경은 항상 Transaction 안에서 이루어져야 하므로, 에너테이션 꼭!
    // Repository 클래스에 걸면 된다! 여기선 테스트용으로 걸어준거. test클래스에 Transactional을 걸면 자동으로 RollBack한다!!
    // 스프링 프레임워크꺼로 하면 됨.
    @Rollback(false) // 해당 옵션을 통해 롤백을 억제할 수 있다.
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member : "+(findMember == member));
        // 위의 두 코드는 모두 true이다. 같은 영속성 컨텍스트에서 비교했기 때문이다.
    }
}