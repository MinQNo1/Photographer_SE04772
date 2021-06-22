/**
 * GalleryController.java
 * All Rights Reserved.
 * Copyright(c) by QuyenNV
 */
package controller;

import context.DBContext;
import dal.ContactDAO;
import dal.GalleryDAO;
import dal.SettingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;
import model.Gallery;
import model.Setting;

/**
 * HomeController<br>
 *
 * <pre>
 * Class handling with data in database
 * In this class, it handle the process below.
 *
 * get properties of galleries
 * get properties of contacts
 *
 * </pre>
 *
 *
 * @author AM
 * @version 1.0
 *
 */
@WebServlet(name = "GalleryController", urlPatterns = {"/GalleryController"})
public class HomeController extends HttpServlet {

    /**
     * put all the properties of contact and galleries to servlet.<br>
     *
     * <pre>
     *
     * method receives id from jsp then get data from databse and put it to servlet
     * in case of method can't receive id ,handling exception.
     *
     * processing order:
     *      1.1 in case method has id
     *          1.1.1 create object with data get from database then send to jsp
     *      1.2 in case method hasn't id
     *          1.2.1 throw exception
     *
     * handing exception:
     *      redirect to error jsp
     * </pre>
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            GalleryDAO gDao = new GalleryDAO();
            ContactDAO cDao = new ContactDAO();
            SettingDAO settingDAO = new SettingDAO();
            DBContext context = new DBContext();

            String page = request.getParameter("page");
            int indexPage = 1;
            if (page != null) {
                try {
                    indexPage = Integer.parseInt(page);
                } catch (Exception e) {
                    indexPage = -1;
                }
            }

            request.setAttribute("fb", context.fb);
            request.setAttribute("gg", context.gg);
            request.setAttribute("tw", context.tw);
            //number of item in a page
            int pageSize = 3;
            if (indexPage != -1) {
                //number of items
                int rowCount = gDao.getTotalGalleries();
                //maximum of page
                int maxPage = rowCount / pageSize + (rowCount % pageSize > 0 ? 1 : 0);

                if (indexPage <= maxPage) {
                    List<Gallery> listGalleries = gDao.getGalleries(indexPage, pageSize);
                    request.setAttribute("galleries", listGalleries);
                    request.setAttribute("maxPage", maxPage);
                    request.setAttribute("pageIndex", indexPage);
                } else {
                    request.setAttribute("mess", "Page index is out of range");
                }
            } else {
                request.setAttribute("mess", "Page index must not include character");
            }

            Contact c = cDao.getContact();
            Setting setting = settingDAO.getWebSetting();
            request.setAttribute("imagePath", context.getImagePath());
            request.setAttribute("setting", setting);
            request.setAttribute("contact", c);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
