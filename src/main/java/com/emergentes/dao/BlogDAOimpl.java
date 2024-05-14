
package com.emergentes.dao;

import com.emergentes.config.Conexion;
import com.emergentes.model.Blog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOimpl extends Conexion implements BlogDAO {

    @Override
    public void insert(Blog blog) throws Exception {

        try {
            this.conectar();          
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO posts(fecha,titulo,contenido) VALUES(?,?,?)");
            ps.setString(1,blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Blog blog) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE posts SET fecha = ?, titulo = ?,contenido = ? WHERE id = ?");
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setInt(4, blog.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM posts WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Blog getById(int id) throws Exception {
        Blog blog = new Blog();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                blog.setId(rs.getInt("id"));
                blog.setFecha(rs.getString("fecha"));
                blog.setTitulo(rs.getString("titulo"));
                blog.setContenido(rs.getString("contenido"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return blog;

    }

    @Override
    public List<Blog> getAll() throws Exception {
        List<Blog> lista = null;
        try {
            this.conectar();
            
            System.out.println("antes de la consulta");
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts");
            
            System.out.println("hola mundo");
            ResultSet rs = ps.executeQuery();
            

            lista = new ArrayList<Blog>();
            while (rs.next()) {
                Blog blog = new Blog();

                blog.setId(rs.getInt("id"));
                blog.setFecha(rs.getString("fecha"));
                blog.setTitulo(rs.getString("titulo"));
                blog.setContenido(rs.getString("contenido"));
                
                lista.add(blog);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return lista;

    }
    
}
