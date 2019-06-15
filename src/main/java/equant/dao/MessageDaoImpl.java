package equant.dao;


import equant.model.MessageMod;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.TypedQuery;

public class MessageDaoImpl implements MessageDao {
    EntityManagerFactory entityManagerFactory;


    public MessageDaoImpl() {
        entityManagerFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void add(MessageMod messageMod) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(messageMod);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public MessageMod getMinIdAndRemove() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<MessageMod> messageModTypedQuery = (TypedQuery<MessageMod>) entityManager.createQuery(
                "SELECT  m From MessageMod m WHERE m.id = (SELECT min(m.id) FROM m)");
        MessageMod messageMod = messageModTypedQuery.getSingleResult();
        entityManager.remove(messageMod);
        entityManager.getTransaction().commit();
        entityManager.close();
        return messageMod;
    }
}
