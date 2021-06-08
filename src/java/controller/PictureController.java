/**
 * PictureController.java
 * All Rights Reserved.
 * Copyright(c) by QuyenNV
 */
package controller;

import context.DBContext;
import dal.GalleryDAO;
import dal.PictureDAO;
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
import model.Gallery;
import model.Picture;
import model.Setting;

/**
 * PictureController<br>
 *
 * <pre>
 * Class handling with data in database
 * In this class, it handle the process below.
 *
 * get properties of galleries
 * get picture by Id
 *
 * </pre>
 *
 *
 * @author AM
 * @version 1.0
 *
 */
@WebServlet(name = "PictureController", urlPatterns = {"/PictureController"})
public class PictureController extends HttpServlet {

    /**
     * put all the properties of galleries and picture to servlet.<br>
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            DBContext context = new DBContext();
            GalleryDAO gDao = new GalleryDAO();
            PictureDAO dao = new PictureDAO();
            SettingDAO settingDAO = new SettingDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("gId", id);
            Setting setting = settingDAO.getWebSetting();
            request.setAttribute("setting", setting);
            request.setAttribute("imagePath", context.getImagePath());
            List<Gallery> galleries = gDao.getGalleries();
            List<Picture> pictures = dao.getPicturesById(id);
            request.setAttribute("galleries", galleries);
            if (pictures.isEmpty()) {
                request.setAttribute("error", "Gallary not found.");
            } else {
                request.setAttribute("pictures", pictures);
            }
            request.getRequestDispatcher("picture.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(PictureController.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PictureController.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PictureController.class.getName()).log(Level.SEVERE, null, ex);
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
