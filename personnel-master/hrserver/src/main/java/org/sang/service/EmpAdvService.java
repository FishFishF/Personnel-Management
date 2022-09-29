package org.sang.service;


import org.sang.bean.Appraise;
import org.sang.bean.EmpEc;
import org.sang.bean.EmpMove;
import org.sang.bean.EmpTrain;
import org.sang.mapper.EmpAdvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class EmpAdvService {
    @Autowired
    EmpAdvMapper empAdvMapper;


    public List<Appraise> findAppraiseByEid(Long eid){
        return empAdvMapper.findAppraiseByEid(eid);
    }

    public List<EmpTrain> findTrainByEid(Long eid){
        return empAdvMapper.findTrainByEid(eid);
    }

    public List<EmpEc> findEmpEcByEid(Long eid){
        return empAdvMapper.findEmpEcByEid(eid);
    }

    public List<EmpMove> findMoveByEid(Long eid){
        return empAdvMapper.findMoveByEid(eid);
    }


}
