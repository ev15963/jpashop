package jpabook.jpashop.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
// 순수하게 Entity와의 관계를 가지는 Repository가 아닌, 쿼리문을 직접 작성해 DTO와 관계를 가지는 쿼리 리퍼지토리(쿼리서비스도 따로 있으면 좋겠지?)
public class OrderSimpleQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos(){
        return em.createQuery(     // 해당 쿼리문으로 원하는 값만 select해서 dto를 초기화시킬 수 있다.
                "select new jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
                        " from Order order by " +
                        "join o.member m" +
                        "join o.delivery d, OrderSimpleQueryDto.class"
        ).getResultList();
        // 본래는 entity나 vo만을 반환할 수 있으나, 위와 같은 방법으로 dto를 즉각적으로 초기화 해서 반환할 수 있다.
        // 파라미터로 엔티티를 넘기면 엔티티 식별자값만 넘어간다. 위와 같이 모두 표기해주고, Dto의 생성자 또한 파라미터를 모두 받도록 설정해야 한다.
        // 리포지토리에 선언하면 API스펙이 들어가게 되기 때문에, 따로 패키지를 설정하는 것이 좋다. 즉, 리포지토리는 Entity만과 관계를 가지는게 좋다.
        // 화면 dependency한 조회!
    }

}
