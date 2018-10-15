package ex02;

public class MemberDaoFactory {
    
    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public MemberDao createMemberDao() throws Exception{
        
        MemberDao memberDao = new MemberDao();
        memberDao.setDataSource(dataSource);
        
        return memberDao;
    }
}
