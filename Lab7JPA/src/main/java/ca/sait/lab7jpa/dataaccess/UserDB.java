package ca.sait.lab7jpa.dataaccess;

import java.util.List;
import ca.sait.lab7jpa.models.User;
import javax.persistence.*;

public class UserDB {

    public List<User> getAll() throws Exception {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("User.findAll");
            return query.getResultList();
            // returns a list of user instances
        } finally {
            em.close();
        } 
    }

    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        } 
    }

    public boolean insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //Creates Entity manager that maintains all entities
        EntityTransaction trans = em.getTransaction();
        // transaction for DML activities
        
        try {
            trans.begin(); 
            //begining transaction with DB
            em.persist(user);
            em.merge(user); 
            //update entity manager if changes were made
            trans.commit(); 
            //tells db to commit changes
            return true;
        } catch (Exception ex) {
            trans.rollback();
            
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
           em.merge(user);
            trans.commit();
            
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            //em.remove(em.merge(user));
            Query query = em.createNamedQuery("User.softDelete", User.class);
            query.setParameter("email", user.getEmail());
            query.executeUpdate();
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        } finally {
            em.close();
        }

    }
}
