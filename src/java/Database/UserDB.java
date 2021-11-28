package Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 733357
 */


import models.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import models.Role;
public class UserDB {
    
}

public int insert(User user) throws NoteDBException {
        EntityManager em = DataBaseUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            Role role = em.find(Role.class, 2);  // 2 is for the regular user
            user.setRole(role);

            trans.begin();
            em.persist(user);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
            throw new NoteDBException("Error inserting user");
        } finally {
            em.close();
        }
    }

    public int update(User user) throws NoteDBException {
        EntityManager em = DataBaseUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot update " + user.toString(), ex);
            throw new NoteDBException("Error updating user");
        } finally {
            em.close();
        }
    }

    public List<User> getAll() throws NoteDBException {
        EntityManager em = DataBaseUtil.getEmFactory().createEntityManager();
        try {
            List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } finally {
            em.close();
        }
    }
