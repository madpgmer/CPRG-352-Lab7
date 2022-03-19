package ca.sait.lab7jpa.dataaccess;

import ca.sait.lab7jpa.models.Role;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Query;


public class RoleDB {

    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("Role.findAll");
            return query.getResultList();
            // returns a list of user instances
        } finally {
            em.close();
        } 

    }

}
