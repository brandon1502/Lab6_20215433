package com.example.lab6_20215433.model.daos;

import com.example.lab6_20215433.model.beans.Actor;
import com.example.lab6_20215433.model.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDao {

    public ArrayList<Pelicula> listarPeliculasTabla(){

        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Parametros de conexion a que base de datos me voy a unir//
        String url ="jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = " SELECT p.idPelicula,p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero\n" +
                "FROM pelicula p\n" +
                "INNER JOIN genero g ON p.idGenero = g.idGenero\n" +
                "ORDER BY p.rating DESC, p.boxOffice DESC;";

        try (Connection conn= DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()){
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setDirector(rs.getString(3));
                pelicula.setAnoPublicacion(rs.getInt(4));
                pelicula.setRating(rs.getDouble(5));
                pelicula.setBoxOffice(rs.getDouble(6));
                pelicula.setGenero(rs.getString(7));

                listaPeliculas.add(pelicula);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPeliculas;



    }

    public Pelicula detallesPelicula(int idPelicula){

        Pelicula pelicula = new Pelicula();

        try{
            Class.forName( "com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Parametros de conexion a que base de datos me voy a uniSr//
        String url ="jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero\n" +
                "FROM pelicula p\n" +
                "INNER JOIN genero g ON p.idGenero = g.idGenero\n" +
                "WHERE p.idPelicula = ?;"; // Agregar el filtro por idPelicula

        try (Connection conn= DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getInt(4));
                    pelicula.setRating(rs.getDouble(5));
                    pelicula.setBoxOffice(rs.getDouble(6));
                    pelicula.setGenero(rs.getString(7));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pelicula;


    }

    public ArrayList<Actor> listarActores(int idPelicula) {
        ArrayList<Actor> listaActor = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT a.idActor, a.Nombre, a.Apellido, a.anoNacimiento, a.premioOscar\n" +
                "FROM Protagonistas p\n" +
                "INNER JOIN Actor a ON p.idActor = a.idActor\n" +
                "WHERE p.idPelicula = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Establecer el valor del parámetro idPelicula en la consulta preparada
            pstmt.setInt(1, idPelicula);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setIdActor(rs.getInt(1));
                    actor.setNombre(rs.getString(2));
                    actor.setApellido(rs.getString(3));
                    actor.setAnoNacimiento(rs.getInt(4));
                    actor.setGanador(rs.getInt(5));

                    listaActor.add(actor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaActor;
    }


    public String obtenerTituloPelicula(int idPelicula){

        String tituloPelicula = null;

        try{
            Class.forName( "com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Parametros de conexion a qué base de datos me voy a unir
        String url ="jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT titulo\n" +
                "FROM mydb.pelicula\n" +
                "\n" +
                "WHERE idPelicula = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    tituloPelicula = rs.getString("titulo");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tituloPelicula;
    }



    public ArrayList<Pelicula> buscarPeliculas(String tituloBusqueda) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";


        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero " +
                "FROM pelicula p " +
                "INNER JOIN genero g ON p.idGenero = g.idGenero " +
                "WHERE p.titulo LIKE ? " +
                "ORDER BY p.rating DESC, p.boxOffice DESC;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + tituloBusqueda + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();

                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getInt(4));
                    pelicula.setRating(rs.getDouble(5));
                    pelicula.setBoxOffice(rs.getDouble(6));
                    pelicula.setGenero(rs.getString(7));

                    listaPeliculas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPeliculas;
    }



}
