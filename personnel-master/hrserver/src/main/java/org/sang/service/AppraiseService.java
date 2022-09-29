package org.sang.service;

import org.sang.bean.Appraise;
import org.sang.mapper.AppraiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppraiseService {
    @Autowired
    AppraiseMapper appraiseMapper;

    public int addAppraise(Appraise appraise){
        return appraiseMapper.addAppraise(appraise);
    }

    public List<Appraise> getAllApprise(){
        return appraiseMapper.getAllApprise();
    }

    public int deleteAppraise(Long id){
        return appraiseMapper.deleteAppraise(id);
    }

    public Appraise findAppraiseByid(Long id){
        return appraiseMapper.findAppraiseByid(id);
    }
}
