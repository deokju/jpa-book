package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.util.List;

public class Application {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");


    public static void main(String[] args) {
        Application main = new Application();
        EntityManager em = emf.createEntityManager();
        // main.testSave(em);
        // main.testFind(em);
        // main.queryLogicJoin(em);
        // main.updateRelation(em);
        // main.biDirection(em);
        main.test순수한객체_양방향(em);
        //main.testORM_양방향_리팩토링(em);
        em.close();
    }




    public void testFind(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = em.find(Member.class, "member1");
        System.out.println("멤버 정보=" + member);
        System.out.println("멤버 팀 정보=" + member.getTeam());
    }

    public void testSave(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        //회원1 저장
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        //회원2 저장
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);

        tx.commit();
    }

    public void queryLogicJoin(EntityManager em) {
        String jpql = "select m from Member m join m.team t where "+
                "t.name=:teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName","팀1")
                .getResultList();

        for(Member member : resultList) {
            System.out.println("[query] member.username=" + member.getUsername());
        }
    }

    public void updateRelation(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);
        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);

        tx.commit();
    }

    public void biDirection(EntityManager em) {
        em.getTransaction().begin();
        Team team = em.find(Team.class, "team2");
        List<Member> members = team.getMembers();

        for(Member member : members) {
            System.out.println("member.username = " + member.getUsername());
        }
    }

    public void test순수한객체_양방향(EntityManager em) {
        //팀1
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);

        List<Member> members = team1.getMembers();
        System.out.println("members.size= " + members.size());
    }

    public void testORM_양방향_리팩토링(EntityManager em) {
        EntityTransaction etx = em.getTransaction();
        //팀1
        Team team1 = em.find(Team.class, "team1");
        Member member1 = new Member("member8", "회원8");
        Member member2 = new Member("member9", "회원9");

        member1.setTeam(team1);
        //team1.getMembers().add(member1);
        member2.setTeam(team1);
        //team1.getMembers().add(member2);
        em.persist(member1);
        em.persist(member2);


        List<Member> members = team1.getMembers();
        System.out.println("members.size= " + members.size());
    }
}
