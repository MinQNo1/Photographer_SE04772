/**
 * PictureDAO.java
 * All Rights Reserved.
 * Copyright(c) by QuyenNV
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Picture;

/**
 * PictureDAO.<br>
 *
 * <pre>
 * Class handling with data in database
 * In this class, it handle the process below.
 *
 * .getPicturesById
 *
 *
 * </pre>
 *
 * @author AM
 * @version 1.0
 */
public class PictureDAO {
    /**
     * getPicturesById.<br>
     * 
     * Get all pictures by id of the gallery in database
     *
     * @param id
     * @return a list of Gallery
     * @throws java.sql.SQLException
     */
    public List<Picture> getPicturesById(int id) throws SQLException {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Picture> list = new ArrayList<>();
        try {
            String sql = "SELECT p.id,p.picture FROM Gallery g INNER JOIN Gallery_Picture gp ON g.id = gp.galleryId INNER JOIN Picture p ON gp.pictureId = p.id and g.id = ?";
            //open connecion
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Picture p = new Picture();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("picture"));
                list.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
        return list;
    }
}
