/**
 * GalleryDAO.java
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
import model.Gallery;

/**
 * GalleryDAO.<br>
 *
 * <pre>
 * Class handling with data in database
 * In this class, it handle the process below.
 *
 * .getGalleries.
 *
 *
 * </pre>
 *
 * @author AM
 * @version 1.0
 */
public class GalleryDAO {

    /**
     * getGalleries.<br>
     * 
     * Get all the properties of each Gallery in database
     * 
     *
     * @return a list of Gallery
     * @throws java.sql.SQLException
     */
    public List<Gallery> getGalleries() throws SQLException {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Gallery> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [photographer].[dbo].[Gallery]";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery g = new Gallery();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setFeturedPicture(rs.getString("featuredPicture"));
                g.setDescription(rs.getString("description"));
                list.add(g);
            }
        } catch (Exception ex) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return list;
    }

}
