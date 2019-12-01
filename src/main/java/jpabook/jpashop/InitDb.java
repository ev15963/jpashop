package jpabook.jpashop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;

        public void dbInit1(){
            Member member= new Member();
            member.setName("userA");
            member.setAdd
        }

    }
}
