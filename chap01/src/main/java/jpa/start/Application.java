package jpa.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastart");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            logic(em);
            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(EntityManager em) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("효진");
        member.setAge(36);

        em.persist(member);

        member.setAge(34);

        Member findMember = em.find(Member.class, "id1");
        System.out.println(findMember);

        //목록 조회
        List<Member> members = em.createQuery("SELECT m from Member m", Member.class).getResultList();
        System.out.println(members.size());
    }
}
