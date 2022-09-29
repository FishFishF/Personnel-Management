package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.Point;

import java.util.List;

@Mapper
public interface PointMapper {
    //生成员工积分的方法
    int formPoint(Long eid,String name);

    //更新员工积分的方法
    int updatePoint(Long eid,int point);

    //查找当前员工的积分
    int findPointsByEid(Long eid);

    //全查
    List<Point> getAllPoint();

    //查积分为负的
    List<Point> getPointDanger();
}
