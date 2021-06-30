/**
 * GalleryDAO.java
 * All Rights Reserved.
 * Copyright(c) by QuyenNV
 */
package dal;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
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

    
        public Gallery getGalleryById(int id) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Gallery gallery = null;
        try {
            String sql = "SELECT * FROM [photographer].[dbo].[Gallery] where id = ?";
            //open connection
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            //add resultset items to result list
            while (rs.next()) {
                gallery = new Gallery();
                gallery.setId(rs.getInt("id"));
                gallery.setName(rs.getString("name"));
                gallery.setFeturedPicture(rs.getString("featuredPicture"));
                gallery.setDescription(rs.getString("description"));
            }
        } catch (Exception ex) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return gallery;
    }
    
    /**
     * getGalleries.<br>
     *
     * Get all the properties of each Gallery in database
     *
     *
     * @return a list of Gallery
     * @throws java.sql.SQLException
     */
    public List<Gallery> getTop3Galleries() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Gallery> list = new ArrayList<>();
        try {
            String sql = "SELECT top 3 * FROM [photographer].[dbo].[Gallery]";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //add resultset items to result list
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
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return list;
    }
    
    public List<Gallery> getGalleries(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Gallery> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "select * from (select ROW_NUMBER() over (order by id ASC) as No,\n"
                + " * from Gallery) as x where No between ? and ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            rs = ps.executeQuery();
            //add resultset items to result list
            while (rs.next()) {
                Gallery g = new Gallery();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setFeturedPicture(rs.getString("featuredPicture"));
                g.setDescription(rs.getString("description"));
                list.add(g);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
    
    public Integer getTotalGalleries() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        
        try {
            String sql = "SELECT count(*) FROM [photographer].[dbo].[Gallery]";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // get total number of gallery
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return count;
    }

}
