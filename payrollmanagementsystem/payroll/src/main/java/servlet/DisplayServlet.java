/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Radhika Swaminathan
 */
public class DisplayServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
            String code = (String) request.getAttribute("code");
            String metacode = "<meta charset=\"UTF-8\">\n" +
            "	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
            String csscode = "<link rel=\"stylesheet\" href=\"styling.css\">";
            String discode = "";
            
            Statement s1=conn.createStatement();
            ResultSet rs1=s1.executeQuery("select * from employee where empcode='"+code+"'"); 
            Statement s2=conn.createStatement();
            ResultSet rs2=s2.executeQuery("select * from salary where empcode='"+code+"'");
            while (rs1.next() && rs2.next()) {
                discode += "<div id=\"details\">\n" +
                "                <p id=\"code1\">EMPLOYEE CODE: "+rs1.getString(1)+"</p>\n" +
                "                <p id=\"des1\">DESIGNATION: "+rs1.getString(2)+"</p>\n" +
                "                <p id=\"dob1\">D.O.B: "+rs1.getString(3)+"</p>\n" +
                "                <p id=\"name1\">NAME: "+rs1.getString(4)+"</p>\n" +
                "                <p id=\"doj1\">D.O.J: "+rs1.getString(5)+"</p>\n" +
                "                <p id=\"age1\">AGE: "+rs1.getInt(6)+"</p>\n" +
                "                <p id=\"exp1\">EXPERIENCE: "+rs1.getString(7)+"</p>\n" +
                "                <p id=\"gen1\">GENDER: "+rs1.getString(8)+"</p>\n" +
                "                <p id=\"id2\">PROOF ID: "+rs1.getString(9)+"</p>\n" +
                "                <p id=\"email1\">EMAIL: "+rs1.getString(10)+"</p>\n" +
                "                <p id=\"num1\">CONTACT: "+rs1.getString(11)+"</p>\n" +
                "                <p id=\"loc1\">HIRED LOCATION: "+rs1.getString(12)+"</p>\n" +
                "                <p id=\"stat1\">EMPLOYEE STATUS: "+rs1.getString(13)+"</p>\n" +
                "                <p id=\"add1\">ADDRESS: "+rs1.getString(14)+"</p>\n" +
                "                <p id=\"net1\">NET SALARY: "+rs2.getDouble(9)+"</p>\n" +
                "            </div>";
            }
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(metacode);
            out.println(csscode);
            out.println("<title>Display Page</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("Display");

            out.println(discode);
            out.println("</body>");
            out.println("</html>");
            
        }
        catch(Exception e)
        {
            out.print("Something went wrong! Try again later");
        }
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
