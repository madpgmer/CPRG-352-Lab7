package ca.sait.lab7jpa.dataaccess;

import javax.persistence.*;

public class DBUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("UsersPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
