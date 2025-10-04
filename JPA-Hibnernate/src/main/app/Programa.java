package app;

import entidades.Pessoa;
import entidades.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
            Pessoa p1 = new Pessoa(null, "Giorgian de Arrascaeta", "jc@gmail.com");
            Pessoa p2 = new Pessoa(null, "Helena de Arrascaeta", "hc@gmail.com");
            Pessoa p3 = new Pessoa(null, "Cleiton de  Arrscaeta", "cc@gmail.com");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
            EntityManager em = emf.createEntityManager();

            Produto pr1 = new Produto(null, "Playstation", 3600.0);
            Produto pr2 = new Produto(null, "Iphone", 6300.0);
            Produto pr3 = new Produto( null, "Notebook", 5800.0);

            //Pessoa p = em.find(Pessoa.class, 7);
            Produto pr = em.find(Produto.class, 3);

            em.getTransaction().begin();

            //pr.setNome("Televisao");
            //em.persist(pr1);
            //em.persist(pr2);
            //em.persist(pr3);
            em.remove(pr);
            em.getTransaction().commit();
            System.out.println(pr);

            em.close();
            emf.close();
    }
}
