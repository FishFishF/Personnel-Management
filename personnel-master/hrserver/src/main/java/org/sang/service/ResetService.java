package org.sang.service;

import org.sang.mapper.ResetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetService {
    @Autowired
    ResetMapper resetMapper;

    public int resetAppraise(){
        return resetMapper.resetAppraise();
    }

    public int resetEmpolyee(){
        return resetMapper.resetEmpolyee();
    }

    public int resetEmployeeec(){
        return resetMapper.resetEmployeeec();
    }

    public int resetEmployeeremove(){
        return resetMapper.resetEmployeeremove();
    }

    public int resetEmployeeTrain(){
        return resetMapper.resetEmployeeTrain();
    }

    public int resetEmpSalary(){
        return resetMapper.resetEmpSalary();
    }

    public int resetPoint(){
        return resetMapper.resetPoint();
    }

    public int resetAdjustSalary(){
        return resetMapper.resetAdjustSalary();
    }

    public int resetDanger(){
        return resetMapper.resetDanger();
    }

}
