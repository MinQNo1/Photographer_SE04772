/**
 * ContactDAO.java
 * All Rights Reserved.
 * Copyright(c) by QuyenNV
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Contact;

/**
 * ContactDAO.<br>
 *
 * <pre>
 * Class handling with data in database
 * In this class, it handle the process below.
 *
 * .getContact
 *
 *
 * </pre>
 *
 * @author QuyenNV
 * @version 1.0
 */
public class ContactDAO {

    /**
     * getContact.<br>
     * Get all the properties of contact in database
     *
     * @return a Contact
     * @throws java.sql.SQLException
     */
    public Contact getContact() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Contact c = new Contact();
        try {
            String sql = "SELECT * FROM [Contact] WHERE id = (select MAX(id) from Contact)";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //get system setting result set
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setCountry(rs.getString("country"));
                c.setTel(rs.getString("tel"));
                c.setEmail(rs.getString("email"));
                c.setAbout_me(rs.getString("about_me"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return c;
    }

}
