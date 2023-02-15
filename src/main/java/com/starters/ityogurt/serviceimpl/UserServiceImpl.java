package com.starters.ityogurt.serviceimpl;

import com.starters.ityogurt.dao.UserDAO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userservice")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userdao")
    UserDAO dao;

    @Override
    public int insertUser(UserDTO dto){
        return dao.InsertUser(dto);
    }
}
