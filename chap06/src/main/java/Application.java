import entity.Member;
import entity.Order;
import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        Application app = new Application();
        app.testSave();
    }

    private void testSave() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Member member = new Member();
        member.setUserName("김덕주");
        em.persist(member);

        Product product = new Product();
        product.setName("JPA MASTER BOOK");
        em.persist(product);

        Order order = new Order();
        order.setMember(member);
        order.setProduct(product);
        order.setOrderAmount(4);

        em.persist(order);

        et.commit();
        em.close();
    }
}


