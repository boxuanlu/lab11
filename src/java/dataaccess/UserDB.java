package dataaccess;

import javax.persistence.EntityManager;
import models.User;


public class UserDB {
    public User get(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.createNamedQuery("User.findByEmail", 
User.class).setParameter("email", email).getSingleResult();

            return user;
        } finally {
            em.close();
        }
    }
}
