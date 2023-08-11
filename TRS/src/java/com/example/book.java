/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rajda
 */
@WebServlet(name = "book", urlPatterns = {"/book"})
public class book extends HttpServlet {

    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            String name=req.getParameter("name");
            String email=req.getParameter("email");
            String phone=req.getParameter("phone");
            String pnr=req.getParameter("pnr");
            String from=req.getParameter("from");
            String to=req.getParameter("to");
            String date=req.getParameter("date");
            String time=req.getParameter("time");
            String person=req.getParameter("person");
            String note=req.getParameter("note");
            Query.insert_booking(name, email, phone, pnr, from, to, date, time, Integer.parseInt(person), note);
            PrintWriter out = resp.getWriter();
        out.println("<html><head><style>p{font-weight:200;font-size:20px;}span{font-weight:700;font-size:20px;}</style></head><body>");

        out.println("<script>"
                + "alert('Data Inserted Successfully');"
                + "window.location.replace('index.html');"
                + "</script>");
            out.println("</body></html>");
        }
        catch(Exception e){}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
