package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.Appraise;
import org.sang.bean.EmpEc;
import org.sang.bean.EmpMove;
import org.sang.bean.EmpTrain;

import java.util.List;

@Mapper
public interface EmpAdvMapper {
    List<Appraise> findAppraiseByEid(Long eid);

    List<EmpTrain> findTrainByEid(Long eid);

    List<EmpEc> findEmpEcByEid(Long eid);

    List<EmpMove> findMoveByEid(Long eid);
}
