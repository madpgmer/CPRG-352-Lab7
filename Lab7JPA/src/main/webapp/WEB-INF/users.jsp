<%-- 
    Document   : users
    Created on : Mar 5, 2022, 2:12:47 PM
    Author     : Madhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1><center>USER  MANAGEMENT  SYSTEM</center></h1>
                      
 <div class="container">
    <div class="row">
        <div class="col order-first">        
           
            <div class="column">
                <div class="border border-dark">
                    <div class="border border-3">
                    <form class="forms" method="post" action="user">
                    <h3>ADD</h3>
                    <input id="add_email" class="box" type="email" name="add_email" placeholder="Email" value="${add_email}" required><br>
                    <label>Active:</label> 
                        <input id="add_active_yes" type="radio" name="add_active" value="true"><label for="add_active_yes" required>Yes</label>
                        <input id="add_active_no" type="radio" name="add_active" value="false"><label for="add_active_no" required>No</label>
                        <input id="add_first_name" class="box" type="text" name="add_first_name" placeholder="First Name" value="${add_first_name}" required><br><br>
                    <input id="add_last_name" class="box" type="text" name="add_last_name" placeholder="Last Name" value="${add_last_name}" required><br><br>
                    <input id="add_password" class="box" type="password" name="add_password" placeholder="Password" value="${add_password}" required><br><br>
                
                    <select class="select" name="addrole">
                    <option value="">--Roles--</option>
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.role_name}" ${addrole == roles ? 'selected="selected"' : ''} >${role.role_name}</option>
                    </c:forEach>
                    </select><br><br>
                    <center> 
                        <input class="btn btn-secondary btn-sm" type="submit" value="Save">
                        <input type="hidden" name="action" value="add">
                    </center> 
                    </form> 
                    </div>
                 </div>
            </div>
        </div>
     
    
        <div class="col">
        
            <div class="column">
                
               <table class = "table table-bordered table-dark">
                <thead>
                <tr>
                    <th> Email </th>
                    <th> First Name </th>
                    <th> Last Name </th>
                    <th> Active </th>
                    <th> Role </th>
                    <th> Delete </th>
                </tr>
            
                </thead>
                <tbody>
                <c:forEach items="${users}" var = "user">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.active ? "YES": "NO"}</td>
                        <td>${user.getRole().getRole_name()}</td>
                        <td>
                            <a href="user?action=delete&amp;email=${user.email}">Delete</a>                            
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
               </table> 
            </div>
          
        </div>
        
                    
      
    
      
      
        <div class="col order-last"> 
        
        <div class="column">
            <div class="border border-dark">
            <div class="border border-3">
                <form class="forms" method="post" action="user">
                <h3>EDIT</h3>
                <input id="edit_email" class="box" type="email" name="edit_email" placeholder="Email" value="${edit_email}" required><br>
                <label>Active:</label> 
                    <input id="edit_active_yes" type="radio" name="edit_active" value="true"><label for="edit_active_yes" required>Yes</label>
                    <input id="edit_active_no" type="radio" name="edit_active" value="false"><label for="edit_active_no" required>No</label>
                <input id="edit_first_name" class="box" type="text" name="edit_first_name" placeholder="First Name" value="${edit_first_name}" required><br><br>
                <input id="edit_last_name" class="box" type="text" name="edit_last_name" placeholder="Last Name" value="${edit_last_name}" required><br><br>
                <input id="edit_password" class="box" type="password" name="edit_password" placeholder="Password" value="${edit_password}" required><br><br>
                <select class="select" name="editrole" required>
                    <option value="">--Roles--</option>
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.role_name}" ${editrole == roles ? 'selected="selected"' : ''} >${role.role_name}</option>
                    </c:forEach>
                </select><br><br>
                    <center>
                        <input class="btn btn-secondary btn-sm" type="submit" value="Update">
                        <input type="hidden" name="action" value="edit">
                    </center>
                
            </form>
            </div>
        </div>
        </div>
        
        </div>
                
  </div>
</div> 
    <center><p>${message} </p> </center>     
</body>
</html>




