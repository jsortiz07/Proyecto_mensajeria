<%-- 
    Document   : editar
    Created on : May 30, 2023, 10:28:32 AM
    Author     : Lenovo
--%>

<%@page import="com.mycompany.mensajes.Mensaje"%>
<%@page import="com.mycompany.mensajes.MensajeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar mensaje Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
         <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form action="editar.jsp" method="POST">
                    <div class="modal-header">
                        <h5 class="modal-title" >Crear mensaje</h5>

                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
                            <label >Ingrese mensaje </label>
                            <textarea class="form-control" name="mensaje" rows="3" required="true" >
                                <%=request.getParameter("mensaje")%>
                            </textarea>
                        </div>
                        <div class="form-group">
                            <label>Autor</label>
                            <input type="text" class="form-control" value="<%=request.getParameter("autor")%>"name="autor" required="true">
                        </div>


                    </div>
                    <div class="modal-footer">
                        <a href="index.jsp"  class="btn btn-danger" name="regresar">Regresar</a>
                        <button type="submit" class="btn btn-primary" name="enviarEdit">Guardar cambios</button>

                    </div>
                </form>
            </div>
        </div>
                        
                        <%
                            //se instancia el metodo contructor para enviar los cambios de los parametros asociados
            MensajeDao mensajeDaoIns = new MensajeDao();
            
            String id = request.getParameter("id");
            if (request.getParameter("enviarEdit") == null) {
                    out.print("Hay campos nulos");
                } else {
                Mensaje mensajeNuevo = new Mensaje(
                    Integer.parseInt(id),
                    request.getParameter("mensaje"), 
                    request.getParameter("autor"));
                    
                    mensajeDaoIns.update(mensajeNuevo);
                
                }
                
                
            
        %>
    </body>
</html>
