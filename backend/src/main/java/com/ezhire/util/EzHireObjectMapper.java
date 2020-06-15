package com.ezhire.util;


import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class EzHireObjectMapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public EzHireObjectMapper(){
    };

    public static <T, D> List<T> entityListToDTOList(List<D> entity, Class<T> destinationtype) {
        List<T> dtos= new ArrayList<>();
        entity.forEach(ent -> dtos.add(modelMapper.map(ent, destinationtype)));
        return dtos;
    }

}
