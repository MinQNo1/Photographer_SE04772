/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Setting;

/**
 *
 * @author QuyenNV
 */
public class SettingDAO {
    
    public Setting getWebSetting() throws SQLException{
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Setting setting = new Setting();
        try {
            String sql = "SELECT * FROM setting";
            //open connecion
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                setting.setSrc(rs.getString("src"));
                setting.setDesc(rs.getString("desc"));
                setting.setTitle(rs.getString("title"));
                setting.setSubTitle(rs.getString("subtitle"));
            }
        } catch (Exception ex) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
        return setting;
    }
}
