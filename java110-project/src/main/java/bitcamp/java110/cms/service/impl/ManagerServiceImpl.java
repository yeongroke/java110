package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    MemberDao memberDao;
    ManagerDao managerDao;
    PhotoDao photoDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public void add(Manager manager) {
        // 매니저 등록관 관련된 업무는 Service 객체에서 처리한다.
        try {
            memberDao.insert(manager);
            managerDao.insert(manager);

            if (manager.getPhoto() != null) {
                HashMap<String, Object> params = new HashMap<>();
                params.put("no", manager.getNo());
                params.put("photo", manager.getPhoto());
                photoDao.insert(params);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public List<Manager> list(int pageNo , int pageSize) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("rowNo", (pageNo-1)*pageSize);
        params.put("size", pageSize);

        return managerDao.findAll(params);
    }

    @Override
    public Manager get(int no) {
        return managerDao.findByNo(no);
    }

    @Override
    public void delete(int no) {
            if (managerDao.delete(no) == 0) {
                throw new RuntimeException("해당 번호의 데이터가 없습니다.");
            }
            photoDao.delete(no);
            memberDao.delete(no);
    }
}










