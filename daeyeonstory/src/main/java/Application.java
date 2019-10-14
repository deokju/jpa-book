import entity.as.AsCategory;
import entity.as.AsState;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        Application app = new Application();

        app.test_add_AS카테고리추가();
        app.test_ADD_AS상태();
    }

    private void test_add_AS카테고리추가() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(new AsCategory("통신이상"));
        em.persist(new AsCategory("장비이상"));
        em.persist(new AsCategory("화재"));
        em.persist(new AsCategory("모니터링"));
        em.persist(new AsCategory("기타"));

        et.commit();
        em.close();

    }

    private void test_ADD_AS상태() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(new AsState("접수"));
        em.persist(new AsState("진행"));
        em.persist(new AsState("처리완료"));
        em.persist(new AsState("미해결"));
        em.persist(new AsState("견적요청"));
        em.persist(new AsState("발주서대기중"));
        em.persist(new AsState("발주서전송완료"));

        et.commit();
        em.close();
    }
}
