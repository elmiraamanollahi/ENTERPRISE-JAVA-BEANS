/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import todo.ejb.TodoDataEJB;
import todo.ejb.TodoDataEJBRemote;
import todo.entities.TodoItem;

/**
 *
 * @author ipd
 */
public class TodoListServlet extends HttpServlet {

    @EJB
    //interface name

    TodoDataEJBRemote todoService;

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
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet TodoListServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> " + request.getContextPath() + "</h1>");

                TodoItem[] itemList = todoService.getAllTodoItems();
                out.println(" <table border=\"1\">");
                out.println("<tr><th>id</th><th>Task</th><th>DueDate</th><th>Is Done</th></tr>");
                for (TodoItem item : itemList) {
                    /* out.printf("<p>%d : %s by %s is %s</p>\n", item.getId(),
                            item.getTask(), item.getDueDate(), item.isIsDone());*/
                    out.println("<tr><td>"+item.getId()+ "</td>" );
                    out.printf("<td> %s </td>" ,item.getTask());
                    out.printf("<td>%s </td>" , item.getDueDate());
                    out.printf("<td>%s </td><tr>" , item.isIsDone());

                }
                out.println("</table>");
               

                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("Excetion ");
            }

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
