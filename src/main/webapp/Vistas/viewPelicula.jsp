<%@ page import="com.example.lab6_20215433.model.beans.Pelicula" %><%--
  Created by IntelliJ IDEA.
  User: BRANDON
  Date: 30/05/2024
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Pelicula pelicula = (Pelicula) request.getAttribute("peliculaReferenciada");
%>

<html>

    <head>

        <title><%= pelicula.getTitulo() %></title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

    <body>
        <div class="container">
            <h1><%= pelicula.getTitulo() %></h1>

            <table class="table table-bordered">
                <tr>
                    <th>idPelicula</th>
                    <td><%= pelicula.getIdPelicula() %></td>

                </tr>

                <tr>
                    <th>Director</th>
                    <td><%= pelicula.getDirector()%></td>
                </tr>

                <tr>
                    <th>Año Publicacion</th>
                    <td><%= pelicula.getAnoPublicacion() %></td>
                </tr>

                <tr>
                    <th>Rating</th>
                    <td><%= pelicula.getRating() %>/10</td>

                </tr>

                <tr>
                    <th>BoxOffice</th>
                    <td>$<%= String.format("%,.0f", pelicula.getBoxOffice()) %></td>
                </tr>

                <tr>
                    <th>Genero</th>
                    <td><%= pelicula.getGenero() %></td>
                </tr>

                <tr>
                    <th>Actores</th>
                    <td><a href="actorServlet?idPelicula=<%= pelicula.getIdPelicula() %>">Ver actores</a></td>
                </tr>


            </table>
        </div>
    </body>
</html>