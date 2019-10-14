import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        Application app = new Application();

       app.test_save_대연스토리();
    }

    private void test_save_대연스토리() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        NewBuild nb = new NewBuild();
        nb.setUserIdx(1L);
        nb.setServerIdx(3L);
        nb.setTitle("썬위드 삼우이엔지태양광 신규");
        nb.setOrderCode("DY-BH1907043T");
        nb.setCompanyName("썬위드");
        nb.setSiteName("삼우이엔지태양광");
        nb.setSiteUser("윤희만과장");
        nb.setSiteUserPhone("010-7141-9828");
        nb.setSiteUserEmail("dy@dycni.com");
        nb.setSiteAddress("대구시 달성군 논공읍 금포리 864");
        nb.setContent("건물 지붕 접속함 5면 통신선 485결선 작업완료. 1번접속함 기상 4종 통신선 연결 후\n" +
                "건물 뒤편 SMA인버터 75kW 5대 m-RTU 설치후 통신테스트 후 대연서버 연동 작업완료.\n" +
                "기존 CCTV 대연서버 연동완료");
        em.persist(nb);

        AsCategory asc = new AsCategory();
        asc.setCategoryName("통신이상");
        em.persist(asc);

        AsBoard board = new AsBoard();
        board.setUserIdx(1L);
        board.setServerIdx(3L);
        board.setTitle("KTE 부산산단 3개소 A/S");
        board.setOrderCode("DY1811066T");
        board.setCompanyName("아이오니아");
        board.setSiteName("그랜드160,두영산기(본점),일창공업사");
        board.setSiteUser("한해동부장");
        board.setSiteUserPhone("010-9848-8306");
        board.setSiteUserEmail("dy@dycni.com");
        board.setSiteAddress("부산 강서구 낙동남로");
        board.setContent("2019-10-02 19:32분 부터 통신두절입니다.\n" +
                "그랜드160 부산 강서구 낙동남로 549번길 34\n" +
                "두영산기 부산 강서구 낙동남로 549번길 21\n" +
                "일창공업사 부산 강서구 낙동남로 533번길 22\n" +
                "\n" +
                "현장 담당자가 라우터 및 인버터 업체 A/S 요청한 상태고, 대연에도 요청하였습니다.");
        board.setAsCategory(asc);
        em.persist(board);

        et.commit();
        em.close();

    }

    private void test_save_각각서브테이블() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        AlbumP albump = new AlbumP();
        albump.setArtist("모차르덕");
        em.persist(albump);

        et.commit();
        em.close();

    }

    private void test_find_각각서브테이블()
    {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        AlbumP albumP = em.find(AlbumP.class,3L);

        System.out.println(albumP);

        et.commit();
        em.close();
    }

    private void test_save_단일테이블() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        MovieS movie = new MovieS();
        movie.setActor("크리스챤베일");
        movie.setDirector("크리스토퍼놀란");
        movie.setName("배트맨 다크나이트");
        movie.setPrice(1000);
        em.persist(movie);

        AlbumS  albumS = new AlbumS();
        albumS.setArtist("모차르덕");
        em.persist(albumS);

        et.commit();
        em.close();
    }

    private void test_find_단일테이블() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        MovieS movie = em.find(MovieS.class, 1L);
        AlbumS albumS = em.find(AlbumS.class, 2L);

        System.out.println(movie);
        System.out.println(albumS);

        et.commit();
        em.close();
    }

    private void findMovie() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Movie movie = em.find(Movie.class, 1L);

        System.out.println(movie);

        et.commit();
        em.close();
    }

    private void testSave() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Movie movie = new Movie();
        movie.setActor("크리스챤베일");
        movie.setDirector("크리스토퍼놀란");
        movie.setName("배트맨 다크나이트");
        movie.setPrice(1000);
        em.persist(movie);
        et.commit();
        em.close();
    }

}
