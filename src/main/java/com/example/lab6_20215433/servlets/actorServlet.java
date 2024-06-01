package com.example.lab6_20215433.servlets;

import com.example.lab6_20215433.model.beans.Actor;
import com.example.lab6_20215433.model.beans.Pelicula;
import com.example.lab6_20215433.model.daos.PeliculaDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "actorServlet", value = "/actorServlet")
public class actorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        PeliculaDao peliculaDao = new PeliculaDao();

        // Obtener el título de la película
        String tituloPelicula = peliculaDao.obtenerTituloPelicula(idPelicula);

        // Obtener la lista de actores
        ArrayList<Actor> listaActores = peliculaDao.listarActores(idPelicula);

        // Establecer los atributos en el request
        request.setAttribute("tituloPelicula", tituloPelicula);
        request.setAttribute("listaActores", listaActores);

        // Enviar la solicitud al JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vistas/listaActores.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
