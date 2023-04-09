/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Radhika Swaminathan
 */
public class InsertDataServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertDataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertDataServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out=response.getWriter();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
            String action=request.getParameter("action");
            switch(action){
                case "Save":{
                    String code=request.getParameter("code");
                    String des=request.getParameter("des");
                    String dob=request.getParameter("dob");
                    String name=request.getParameter("name");
                    String doj=request.getParameter("doj");
                    int age=Integer.parseInt(request.getParameter("age"));
                    int exp=Integer.parseInt(request.getParameter("exp"));
                    String gen=request.getParameter("gen");
                    String id=request.getParameter("id");
                    String email=request.getParameter("email");
                    String num=request.getParameter("num");
                    String loc=request.getParameter("loc");
                    String stat=request.getParameter("stat");
                    String add=request.getParameter("add");
                    
                    String mon=request.getParameter("mon");
                    int dat=Integer.parseInt(request.getParameter("dat"));
                    int day=Integer.parseInt(request.getParameter("day"));
                    int abs=Integer.parseInt(request.getParameter("abs"));
                    int med=Integer.parseInt(request.getParameter("med"));
                    double pf=Double.parseDouble(request.getParameter("pf"));
                    int con=Integer.parseInt(request.getParameter("con"));
                    double net=((day+med-abs)*1000)-pf-con;
                    
                    Statement s=conn.createStatement();
                    ResultSet rs=s.executeQuery("select * from employee where empcode='"+code+"'"); 
                    
                    if (rs.next()){
                        out.print("Record already exists");
                        break;
                    }
                    PreparedStatement ps1=conn.prepareStatement("insert into employee(empcode,designation,dob,name,doj,age,experience,gender,proofid,email,contact,hiredloc,status,address) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    ps1.setString(1,code);
                    ps1.setString(2, des);
                    ps1.setString(3,dob);
                    ps1.setString(4, name);
                    ps1.setString(5,doj);
                    ps1.setInt(6,age);
                    ps1.setInt(7,exp);
                    ps1.setString(8,gen);
                    ps1.setString(9, id);
                    ps1.setString(10, email);
                    ps1.setString(11,num);
                    ps1.setString(12,loc);
                    ps1.setString(13,stat);
                    ps1.setString(14, add);
                    ps1.executeUpdate();
                    
                    PreparedStatement ps2=conn.prepareStatement("insert into salary(empcode,month_year,date,totdays,absence,medical,pf,conveyance,net) values(?,?,?,?,?,?,?,?,?)");
                    ps2.setString(1,code);
                    ps2.setString(2,mon);
                    ps2.setInt(3,dat);
                    ps2.setInt(4,day);
                    ps2.setInt(5,abs);
                    ps2.setInt(6,med);
                    ps2.setDouble(7,pf);
                    ps2.setInt(8, con);
                    ps2.setDouble(9,net);
                    ps2.executeUpdate();
                    
                    out.print("Saved Successfully!");
                    break;
                }
                case "Update":{
                    String code=request.getParameter("code");
                    String des=request.getParameter("des");
                    String dob=request.getParameter("dob");
                    String name=request.getParameter("name");
                    String doj=request.getParameter("doj");
                    int age=Integer.parseInt(request.getParameter("age"));
                    int exp=Integer.parseInt(request.getParameter("exp"));
                    String gen=request.getParameter("gen");
                    String id=request.getParameter("id");
                    String email=request.getParameter("email");
                    String num=request.getParameter("num");
                    String loc=request.getParameter("loc");
                    String stat=request.getParameter("stat");
                    String add=request.getParameter("add");
                    
                    String mon=request.getParameter("mon");
                    int dat=Integer.parseInt(request.getParameter("dat"));
                    int day=Integer.parseInt(request.getParameter("day"));
                    int abs=Integer.parseInt(request.getParameter("abs"));
                    int med=Integer.parseInt(request.getParameter("med"));
                    double pf=Double.parseDouble(request.getParameter("pf"));
                    int con=Integer.parseInt(request.getParameter("con"));
                    double net=((day+med-abs)*1000)-pf-con;
                    
                    Statement s=conn.createStatement();
                    ResultSet rs=s.executeQuery("select * from employee where empcode='"+code+"'"); 
                    
                    if(rs.next()){
                        PreparedStatement ps1=conn.prepareStatement("update employee set designation=?,dob=?,name=?,doj=?,age=?,experience=?,gender=?,proofid=?,email=?,contact=?,hiredloc=?,status=?,address=? where empcode=?");
                        ps1.setString(14,code);
                        ps1.setString(1, des);
                        ps1.setString(2,dob);
                        ps1.setString(3, name);
                        ps1.setString(4,doj);
                        ps1.setInt(5,age);
                        ps1.setInt(6,exp);
                        ps1.setString(7,gen);
                        ps1.setString(8, id);
                        ps1.setString(9, email);
                        ps1.setString(10,num);
                        ps1.setString(11,loc);
                        ps1.setString(12,stat);
                        ps1.setString(13, add);
                        ps1.executeUpdate();
                        
                        PreparedStatement ps2=conn.prepareStatement("update salary set month_year=?,date=?,totdays=?,absence=?,medical=?,pf=?,conveyance=?,net=? where empcode=?");
                        ps2.setString(9,code);
                        ps2.setString(1,mon);
                        ps2.setInt(2,dat);
                        ps2.setInt(3,day);
                        ps2.setInt(4,abs);
                        ps2.setInt(5,med);
                        ps2.setDouble(6,pf);
                        ps2.setInt(7, con);
                        ps2.setDouble(8,net);
                        ps2.executeUpdate();
                        
                        out.print("Updated Successfully!");
                        break;
                    }
                    else{
                        out.print("Record does not exist");
                        break;
                    }
                }
                case "Delete":{
                    String code=request.getParameter("code");
                    
                    Statement s=conn.createStatement();
                    ResultSet rs=s.executeQuery("select * from employee where empcode='"+code+"'"); 
                    
                    if(rs.next()){
                        PreparedStatement ps2=conn.prepareStatement("delete from salary where empcode=?");
                        ps2.setString(1,code);
                        ps2.executeUpdate();
                        
                        PreparedStatement ps1=conn.prepareStatement("delete from employee where empcode=?");
                        ps1.setString(1,code);
                        ps1.executeUpdate();
                        
                        out.print("Deleted Successfully!");
                        break;
                    }
                    else{
                        out.print("Record does not exist");
                        break;
                    }
                    
                }
                case "Display":{
                    String code=request.getParameter("code");
                    
                    Statement s1=conn.createStatement();
                    ResultSet rs1=s1.executeQuery("select * from employee where empcode='"+code+"'"); 
                    Statement s2=conn.createStatement();
                    ResultSet rs2=s2.executeQuery("select * from salary where empcode='"+code+"'");
                    
                    if(rs1.next()){
                        request.setAttribute("code", code);
                        RequestDispatcher rd = request.getRequestDispatcher("/DisplayServlet");
                        rd.forward(request, response);
                        //response.sendRedirect("DisplayServlet");
                    }
                    else{
                        out.print("Record does not exist");
                        break;
                    }
                }
                default:{
                    break;
                }   
            }
            //response.sendRedirect("signup.jsp");
        }
        catch(Exception e)
        {
            out.print("Something went wrong! Try again later");
        }
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
