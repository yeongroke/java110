package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.util.DataSource;

public class PhotoMysqlDao implements PhotoDao {
    
    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int insert(int no, String filename) throws DaoException {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "insert into p1_memb_phot(mno,photo) values(?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, no);
            stmt.setString(2, filename);
            return stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    @Override
    public int delete(int no) throws DaoException {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "delete from p1_memb_phot where mno=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, no);
            return stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
}
























