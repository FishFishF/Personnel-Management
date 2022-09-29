package org.sang.service;

import org.sang.bean.Point;
import org.sang.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PointService {
    @Autowired
    PointMapper pointMapper;

    public int formPoint(Long eid,String name){
        return pointMapper.formPoint(eid,name);
    }

    public int updatePoint(Long eid,int point){
        return pointMapper.updatePoint(eid,point);
    }

    public int findPointsByEid(Long eid){
        return pointMapper.findPointsByEid(eid);
    }

    public List<Point> getAllPoint(){
        return pointMapper.getAllPoint();
    }

    public List<Point> getPointDanger(){
        return pointMapper.getPointDanger();
    }
}
