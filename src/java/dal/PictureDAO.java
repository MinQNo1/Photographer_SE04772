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
    public List<Picture> getPicturesById(int id) throws Exception {
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
            // get result set
            rs = ps.executeQuery();
            while (rs.next()) {
                Picture p = new Picture();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("picture"));
                list.add(p);
            }
        }catch(Exception ex){
            // throw exception
            Logger.getLogger(PictureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
        return list;
    }
    public List<Picture> pagging(int pageIndex, int pageSize, int galId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Picture> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "select * from (select ROW_NUMBER() over (order by galleryId ASC) as No,\n" +
"                p.id, p.picture from Gallery g INNER JOIN Gallery_Picture gp ON g.id = gp.galleryId "
                + "INNER JOIN Picture p ON gp.pictureId = p.id and g.id = ?) as x where No between ? and ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galId);
            ps.setObject(2, start);
            ps.setObject(3, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                Picture p = new Picture();
                p.setNo(rs.getInt("No"));
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("picture"));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
    
    public int totalPictureByGallery(int galId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        String sql = "Select count(pictureId) from Gallery_Picture where galleryId = ?";
        int count = 0;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galId);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return count;
    }
    
}
