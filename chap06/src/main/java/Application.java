import entity.Member;
import entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        Application app = new Application();
        //app.testSave();
        app.findsMemberByTeam();
    }

    private void findsMemberByTeam() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Team teamA = em.find(Team.class,1l);

        for(Member member :teamA.getMembers()) {
            System.out.println(member);
        }

        et.commit();
        em.close();
    }

    private void testSave() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Team teamA = em.find(Team.class, 1l);

        Member member = new Member();
        member.setUsername("세라드");

        member.setTeam(teamA);

        em.persist(member);
        et.commit();
        em.close();
    }
}


