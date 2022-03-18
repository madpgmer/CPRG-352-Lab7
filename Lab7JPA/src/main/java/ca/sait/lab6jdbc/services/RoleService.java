package ca.sait.lab6jdbc.services;


import ca.sait.lab6jdbc.dataaccess.RoleDB;
import ca.sait.lab6jdbc.models.Role;
import java.util.List;


public class RoleService {
    private RoleDB roleDB = new RoleDB();
    
     
    public List<Role> getAll() throws Exception {
        List<Role> roles = this.roleDB.getAll();
        return roles;
    }
    
    
}
