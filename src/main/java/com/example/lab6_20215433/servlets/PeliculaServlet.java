package com.example.lab6_20215433.servlets;

import com.example.lab6_20215433.model.beans.Pelicula;
import com.example.lab6_20215433.model.daos.PeliculaDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", value = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tituloBusqueda = request.getParameter("titulo");  // Obtén el parámetro de búsqueda desde la solicitud
        PeliculaDao peliculaDao = new PeliculaDao();
        ArrayList<Pelicula> listaPeliculas;

        // Si se proporciona un título para la búsqueda, filtra las películas
        if (tituloBusqueda != null && !tituloBusqueda.trim().isEmpty()) {
            listaPeliculas = peliculaDao.buscarPeliculas(tituloBusqueda);
        } else {
            listaPeliculas = peliculaDao.listarPeliculasTabla();
        }

        // Establecer los atributos en el request
        request.setAttribute("listaPeliculas", listaPeliculas);

        // Enviar la solicitud al JSP
        String vista = "Vistas/listaPeliculas.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si necesitas manejar POST requests, puedes agregar tu lógica aquí
    }
}
