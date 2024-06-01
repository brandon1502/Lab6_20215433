<%@ page import="com.example.lab6_20215433.model.beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Pelicula> lista = (ArrayList<Pelicula>) request.getAttribute("listaPeliculas");
    String searchQuery = request.getParameter("titulo");
%>

<html>
    <head>
        <title>Peliculas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Lista de Peliculas</h1>

            <!-- Buscador -->
            <form action="PeliculaServlet" method="get" class="mb-3" style="width: 300px;">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Buscar película ..." name="titulo" value="<%= searchQuery != null ? searchQuery : "" %>">
                    <button type="submit" class="btn btn-outline-secondary" style="background-color: #d3d3d3; border-radius: 0;">Buscar</button>
                </div>
            </form>

            <table class="table table-bordered">
                <tr>
                    <th>Titulo</th>
                    <th>Director</th>
                    <th>Año Publicacion</th>
                    <th>Rating</th>
                    <th>BoxOffice</th>
                    <th>Genero</th>
                    <th>Actores</th>
                </tr>

                <% for(Pelicula pelicula : lista) { %>
                <tr>
                    <td><a href="DetallesServlet?idPelicula=<%= pelicula.getIdPelicula() %>"><%= pelicula.getTitulo() %></a></td>
                    <td><%= pelicula.getDirector() %></td>
                    <td><%= pelicula.getAnoPublicacion() %></td>
                    <td><%= pelicula.getRating() %>/10</td>
                    <td>$<%= String.format("%,.0f", pelicula.getBoxOffice()) %></td>
                    <td><%= pelicula.getGenero() %></td>
                    <td><a href="actorServlet?idPelicula=<%= pelicula.getIdPelicula() %>">Ver actores</a></td>
                </tr>
                <%      }
                %>
            </table>
        </div>
    </body>
</html>
