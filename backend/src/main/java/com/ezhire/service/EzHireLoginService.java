package com.ezhire.service;

import com.ezhire.dto.EzHireUserDTO;
import com.ezhire.entity.User;
import com.ezhire.repository.IEzHireUserRepo;
import com.ezhire.util.EzHireObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EzHireLoginService implements IEzHireLoginService {
    private IEzHireUserRepo userRepo;

    @Autowired
    public EzHireLoginService(IEzHireUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public EzHireUserDTO login(EzHireUserDTO userDTO) {
        User user = userRepo.login(userDTO.getUserName(), userDTO.getPassWord());
        return EzHireObjectMapper.modelMapper.map(user, EzHireUserDTO.class);
    }
}
