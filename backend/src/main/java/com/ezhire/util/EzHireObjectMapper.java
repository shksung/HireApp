package com.ezhire.util;


import com.ezhire.dto.EzHireJobStatusInfoDTO;
import com.ezhire.entity.JobStatusInfo;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
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

    public static void dtoToJobStatusInfo(EzHireJobStatusInfoDTO infoDTO, JobStatusInfo statusInfo) {
        statusInfo.setInitialStatus(infoDTO.getInitialStatus());
        statusInfo.setFeedBack(infoDTO.getFeedBack());
        statusInfo.setInPersonDate(statusInfo.getInPersonDate());
        statusInfo.setOutCome(infoDTO.getOutCome());
        statusInfo.setPhoneScreenDate(infoDTO.getPhoneScreenDate());
        statusInfo.setPhoneScreenStatus(infoDTO.getPhoneScreenStatus());
        statusInfo.setReviewDate(infoDTO.getReviewDate());
    }

}
