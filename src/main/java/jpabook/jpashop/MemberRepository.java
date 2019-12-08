package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // 기본 component
public class MemberRepository {

    @PersistenceContext // JPA 쓸 때, Entity 매니저를 선언하는 어노테이션
    private EntityManager em;

    public Long save(Member member){    // 저장 메소드
        em.persist(member);
        return member.getId();  // 강사스타일, command와 query를 분리하기 위해, 저장 이후에는 객체를 부르지 않는다. 최대 아이디정도
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }




}
