package com.emergentes.controller;

import com.emergentes.dao.BlogDAO;
import com.emergentes.dao.BlogDAOimpl;
import com.emergentes.model.Blog;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            BlogDAO dao = new BlogDAOimpl();
            int id;
            Blog blog = new Blog();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            System.out.println(action);

            switch (action) {
                case "add":
                    request.setAttribute("blog", blog);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    blog=dao.getById(id);
                    
                    request.setAttribute("blog", blog);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    
                    response.sendRedirect(request.getContextPath()+"/MainServlet");
                    break;
                case "view":
                    List<Blog> lista = dao.getAll();
                                       
                    request.setAttribute("blogs", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");

        Blog blog = new Blog();

        blog.setId(id);
        blog.setFecha(fecha);
        blog.setTitulo(titulo);
        blog.setContenido(contenido);

        if (id == 0) {
            try {
                BlogDAO dao = new BlogDAOimpl();
                dao.insert(blog);
                response.sendRedirect(request.getContextPath() + "/MainServlet");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            try {
                BlogDAO dao = new BlogDAOimpl();
                dao.update(blog);
                response.sendRedirect(request.getContextPath() + "/MainServlet");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

}
