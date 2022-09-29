package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResetMapper {
    int resetAppraise();

    int resetEmpolyee();

    int resetEmployeeec();

    int resetEmployeeremove();

    int resetEmployeeTrain();

    int resetEmpSalary();

    int resetPoint();

    int resetAdjustSalary();

    int resetDanger();

}
