package hellojpa;

import jakarta.persistence.*;
import jpql.Member;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUserName("member1");
            member.setAge(10);

            em.persist(member);

            Member result = em.createQuery("SELECT m FROM Member m where m.userName=:username ", Member.class)
                            .setParameter("username", "member1")
                            .getSingleResult();

            System.out.println("result = " + result.getUserName());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
