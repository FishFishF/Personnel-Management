package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Danger;

import java.util.List;

@Mapper
public interface DangerMapper {
    int insertDanger(@Param("eid") Long eid);

   int ifDanger(Long eid);
}
