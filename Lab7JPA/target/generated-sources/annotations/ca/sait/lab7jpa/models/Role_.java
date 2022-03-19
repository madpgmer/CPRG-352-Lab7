package ca.sait.lab7jpa.models;

import ca.sait.lab7jpa.models.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-19T13:06:38")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> role_name;
    public static volatile SingularAttribute<Role, Integer> role_id;
    public static volatile ListAttribute<Role, User> user;

}