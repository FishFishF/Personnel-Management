package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Appraise;

import java.util.List;

@Mapper
public interface AppraiseMapper {
    int addAppraise(@Param("appraise")Appraise appraise);

    List<Appraise> getAllApprise();

    int deleteAppraise(@Param("id") Long id);

    Appraise findAppraiseByid(Long id);
}
