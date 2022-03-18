package ca.sait.lab6jdbc.servlets;

import ca.sait.lab6jdbc.models.Role;
import ca.sait.lab6jdbc.models.User;
import ca.sait.lab6jdbc.services.RoleService;
import ca.sait.lab6jdbc.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Madhu
 */
public class UserServlet extends HttpServlet {
  
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        UserService uservice = new UserService();
        try {
            if (request.getParameter("action") != null) {
                if (request.getParameter("action").equals("delete")) {
                    String email = request.getParameter("email");
                    uservice.delete(email);
                    request.setAttribute("message", "User " + email + " has been deleted!");
                }
           }
            List<User> users = uservice.getAll();
            request.setAttribute("users", users);
            
            RoleService rservice = new RoleService();
            List<Role> roles = rservice.getAll();
            request.setAttribute("roles", roles);
            
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
   }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        UserService uservice = new UserService();
        RoleService rservice = new RoleService();
        
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String stringRole = "";
        Role role = new Role();
        int intRole = 0;
        try {
            switch(action) {
                case "add":
                    stringRole = request.getParameter("addrole");
                    switch(stringRole) {
                        case "system admin": intRole = 1; break;
                        case "regular user": intRole = 2; break;
                        case "company admin": intRole = 3; break;
                        default: break;
                    }
                    role.setRole_id(intRole);
                    email = request.getParameter("add_email");
                    uservice.insert( email, 
                            Boolean.parseBoolean(request.getParameter("add_active")), 
                            request.getParameter("add_first_name"), 
                            request.getParameter("add_last_name"), 
                            request.getParameter("add_password"),role );
                    request.setAttribute("message", "New user " + email + " has been added!");
                    break;

                case "edit":
                    stringRole = request.getParameter("editrole");
                    switch(stringRole) {
                        case "system admin": intRole = 1; break;
                        case "regular user": intRole = 2; break;
                        case "company admin": intRole = 3; break;
                        default: break;
                    }
                    role.setRole_id(intRole);
                    email = request.getParameter("edit_email");
                    uservice.update(email, 
                            Boolean.parseBoolean(request.getParameter("edit_active")), 
                            request.getParameter("edit_first_name"), 
                            request.getParameter("edit_last_name"), 
                            request.getParameter("edit_password"),role);
                    request.setAttribute("message", "User " + email + " has been updated!");
                    break;
                
                default:
                    break;
            }
            List<User> users = uservice.getAll();
            request.setAttribute("users", users);
            
            List<Role> roles = rservice.getAll();
            request.setAttribute("roles", roles);
            
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        
    }
}