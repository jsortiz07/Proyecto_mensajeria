<%-- 
    Document   : eliminar
    Created on : May 30, 2023, 11:58:38 AM
    Author     : Lenovo
--%>

<%@page import="com.mycompany.mensajes.MensajeDao"%>
<%@page import="com.mycompany.mensajes.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            // Logica para realizar la eliminacion del registro a nivel DB, getRequestDispatcher sirve para redirigir a otra pagina
            String id = request.getParameter("id");
            Mensaje mensaje = new Mensaje(Integer.valueOf(id));
            MensajeDao mensajeDao = new MensajeDao();
            mensajeDao.delete(mensaje);
            request.getRequestDispatcher("index.jsp").forward(request, response);

            %>
    </body>
</html>
