package com.example.lab6_20215433.servlets;

import com.example.lab6_20215433.model.beans.Pelicula;
import com.example.lab6_20215433.model.daos.PeliculaDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));

        PeliculaDao peliculaDao = new PeliculaDao();

        Pelicula pelicula = peliculaDao.detallesPelicula(idPelicula);

        //OBJETO A ENVIAR
        request.setAttribute("peliculaReferenciada",pelicula);

        String vista = "Vistas/viewPelicula.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
