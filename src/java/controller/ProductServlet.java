/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.SanphamDAO;

/**
 *
 * @author VuQuang
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        try {
                SanphamDAO sanpham = new SanphamDAO();
                String listIDCheckbox[] = request.getParameterValues("checkboxXoa");
                if(listIDCheckbox == null) {
                    request.getRequestDispatcher("products.htm").forward(request, response);
                    return;
                }
                if (request.getParameter("btnXoa") != null) {
                    if(listIDCheckbox.length > 0) {
                        for(String id:listIDCheckbox) {
                            if(id != null) {
                                sanpham.xoaSanpham(Integer.valueOf(id));
                            }
                        }
                    }
                }
                request.getRequestDispatcher("products.htm").forward(request, response);
        }
        catch(Exception e) {
            e.printStackTrace();
            return;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
