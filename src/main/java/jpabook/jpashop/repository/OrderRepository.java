package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class OrderRepository {

    @PersistenceContext // JPA 쓸 때, Entity 매니저를 선언하는 어노테이션
    private EntityManager em;

    public List<Order> findAllWithMemberDelivery(){ // fetch 조인. Order 객체 안에 member, delivery 객체값을 모두 채워서 보내줌. 이로써 1+N 문제 해결!
        return em.createQuery(  // 1+N 문제가 발생하는 부분은 이렇게 직접 쿼리문을 작성해서 fetch 조인으로 해결하자.
                "select o from Order o" +
                        "join fetch o.member m" +
                        "join fetch o.delivery d", Order.class
        ).getResultList();
    }

}
