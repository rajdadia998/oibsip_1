package com.example;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, Exception {
        resp.setContentType("text/html;charset=UTF-8");
         try  {
            String fname=req.getParameter("fname");
            String lname=req.getParameter("lname");
            String uname=req.getParameter("uname");
            String pass=req.getParameter("pass");
            String age=req.getParameter("age");
            String state=req.getParameter("state");
            String city=req.getParameter("city");
            Query.insert(fname,lname,uname,pass,age,state,city);
            PrintWriter out = resp.getWriter();
        out.println("<html><head><style>p{font-weight:200;font-size:20px;}span{font-weight:700;font-size:20px;}</style></head><body>");

        out.println("<script>"
                + "alert('Data Inserted Successfully');"
                + "window.location.replace('Login.html');"
                + "</script>");
            out.println("</body></html>");

        }
        catch(Exception e){
        e.printStackTrace();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try
       {
            processRequest(request, response);
       }
       catch(IOException | ServletException e){} catch (Exception ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try
       {
            processRequest(request, response);
       }
       catch(IOException | ServletException e){} catch (Exception ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
