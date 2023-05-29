<%-- 
    Document   : index
    Created on : May 28, 2023, 10:35:07 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>


        <!-- Modal -->
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form action="index.jsp" method="POST">
                    <div class="modal-header">
                        <h5 class="modal-title" >Crear mensaje</h5>

                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label >Ingrese mensaje </label>
                            <textarea class="form-control" name="mensaje" rows="3"  placeholder="Enter email"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Autor</label>
                            <input type="text" class="form-control" name="autor" placeholder="Password">
                        </div>


                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Submit</button>

                    </div>
                </form>
            </div>
        </div>
        <%
          String mensaje = request.getParameter("mensaje");
          String autor = request.getParameter("autor");
        %>
        
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" >Todos mensajes</h5>

                </div>
                <div class="modal-body">
                    <div class="card" >
                        <div class="card-body">
                            <h5 class="card-title"><%=autor%></h5>
                            <p class="card-text"><%=mensaje%></p>
                            <a href="#" class="card-link">Editar</a>
                            <a href="#" class="card-link">Eliminar</a>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>

                </div>
            </div>
        </div>


    </body>
</html>
