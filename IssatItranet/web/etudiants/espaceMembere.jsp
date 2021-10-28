<%-- 
    Document   : espaceMembere.jsp
    Created on : 22 oct. 2021, 13:27:01
    Author     : Mohamed
--%>

<%@page import="models.Etudiant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Etudiant e=(Etudiant) session.getAttribute("Etudiant") ; %>
        <h1> Bonjour nom prenom, vous êtes connecté comme login </h1>
        
            Vos paramètres sont : <br />
            Nom : <%=e.nom %> <br />
            Prénom : <%=e.prenom %><br />
            CIN : <%=e.cin %> <br />
            Groupe : <%=e.groupe %> <br />
            Genre : <%=e.genre %> <br />
            Login : <%=e.login %> <br />
            Mot de passe : <%=e.mdp %> <br />
        
    </body>
</html>
