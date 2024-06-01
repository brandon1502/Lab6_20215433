<%@ page import="com.example.lab6_20215433.model.beans.Actor" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: BRANDON
  Date: 31/05/2024
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Actor> lista = (ArrayList<Actor>) request.getAttribute("listaActores");
    String titulo = (String) request.getAttribute("tituloPelicula");

%>
<html>
    <head>
        <title><%= titulo %></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1><%= titulo %></h1>

            <table class="table table-bordered">
                <tr>
                    <th>idActor</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Año Nacimiento</th>
                    <th>Ganador Premio Oscar</th>
                </tr>

                <% for(Actor actor : lista) { %>
                <tr>
                    <td><%=actor.getIdActor()%></td>
                    <td><%=actor.getNombre()%></td>
                    <td><%=actor.getApellido()%></td>
                    <td><%=actor.getAnoNacimiento()%></td>
                    <td><%= actor.getGanador() == 1 ? "True" : "False" %></td>


                </tr>
                <%      }
                %>
            </table>
        </div>
    </body>
</html>

