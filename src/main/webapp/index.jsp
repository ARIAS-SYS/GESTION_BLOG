
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>

        <div class="container mt-5">
            <h1 class="text-center">Blog de Tecnología</h1>
            <p class="text-center">Autor: Ronaldo Arias Mamani</p>

            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <a class="btn btn-primary" href="MainServlet?action=add">Nueva Entrada</a>
            </div>

            <div class="card mt-4">
                <div class="card-body">

                    <c:forEach var="item" items="${blogs}">
                        <div class="mb-4">
                            <h5 class="card-title">${item.titulo}</h5>
                            <h6 class="card-subtitle mb-2 text-body-secondary">${item.fecha}</h6>
                            <p class="card-text">${item.contenido}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                <a href="MainServlet?action=edit&id=${item.id}" class="card-link">Editar</a>
                                <a href="MainServlet?action=delete&id=${item.id}" onclick="return(confirm('Estas Seguro..??'))" class="card-link">Eliminar</a>
                            </div>
                            <hr>
                        </div>
                    </c:forEach>
                        
                    



                </div>
            </div>


        </div>





        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
