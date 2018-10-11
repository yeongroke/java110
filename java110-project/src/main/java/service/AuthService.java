package service;

import bitcamp.java110.cms.domain.Member;

public interface AuthService {
    Member get(String email,String password,String memberType);
    
}
