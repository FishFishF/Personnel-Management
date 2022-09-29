package org.sang.service;

import org.sang.bean.Danger;
import org.sang.mapper.DangerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangerService {
    @Autowired
    DangerMapper dangerMapper;

    public int insertDanger(Long eid){
        return dangerMapper.insertDanger(eid);
    }

    public int ifDanger(Long eid){
        return dangerMapper.ifDanger(eid);
    }
}
