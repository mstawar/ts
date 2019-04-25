/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xxx
 */
@WebServlet(name = "ManageBooks", urlPatterns = {"/ManageBooks"})
public class ManageBooks extends HttpServlet {

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
            out.println("<title>Servlet ManageBooks</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageBooks at " + request.getContextPath() + "</h1>");
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
        try{
             HttpSession session = request.getSession(false);
            
            List<Book> bookList = getBooks();
             if (session != null){
             Book book = (Book) session.getAttribute("edit");
            if (book!=null){
               
                bookList.set(Integer.valueOf(String.valueOf(book.getId()))-1, book);
            }
            book = (Book) session.getAttribute("add");
            if (  book  != null){              
                bookList.add(book);
            }
            
             }
            request.setAttribute("bookList", bookList);
            RequestDispatcher rd =  request.getRequestDispatcher("bookList.jsp");
           rd.forward(request, response);
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            response.sendError(500);
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

    private List<Book> getBooks() throws ClassNotFoundException{
        
        
        List<Book> bookList = new ArrayList<>();
        
        Book book = new Book(Long.valueOf("1"), "Buszujacy w zbozu", "James David Salinger", "12345678", "Koles wychodzi ze zboza po buszowaniu");
        boolean add;
        add = bookList.add(book);
        book = new Book(Long.valueOf("2"), "Kaczor Donald", "Samo życie", "1020304050", "Komiks o kaczorze co jest Donaldem");
        bookList.add(book);
        book = new Book(Long.valueOf("3"), "Przeminelo z wiatrem", "Maria Margareth Mitchel", "oko", "Zwialo nam parasol");
        bookList.add(book);
        book = new Book(Long.valueOf("4"), "Swietno nieistotnosci", "Milan Kundera", "11111111", "Dzisiaj wolne jest swieto");
        bookList.add(book);
        
        
        return bookList;
      
        
    }

}
