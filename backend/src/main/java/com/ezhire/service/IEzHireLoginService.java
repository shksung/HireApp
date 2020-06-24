package com.ezhire.service;

import com.ezhire.dto.EzHireUserDTO;

public interface IEzHireLoginService {
    EzHireUserDTO login(EzHireUserDTO userDTO);
}
