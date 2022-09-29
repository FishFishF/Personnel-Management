package org.sang.controller.emp;


import org.sang.bean.Appraise;
import org.sang.bean.EmpEc;
import org.sang.bean.EmpMove;
import org.sang.bean.EmpTrain;
import org.sang.service.EmpAdvService;
import org.sang.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee/adv")
public class EmpAdvController {
    @Autowired
    EmpAdvService empAdvService;


    @RequestMapping(value = "/listAppraises/{eid}", method = RequestMethod.GET)
    public List<Appraise> getAppraisesByEid(@PathVariable Long eid){
        return empAdvService.findAppraiseByEid(eid);
    }

    @RequestMapping(value = "/listTrain/{eid}", method = RequestMethod.GET)
    public List<EmpTrain> getTrainByEid(@PathVariable Long eid){
        return empAdvService.findTrainByEid(eid);
    }

    @RequestMapping(value = "/listEC/{eid}", method = RequestMethod.GET)
    public List<EmpEc> getEmpECByEid(@PathVariable Long eid){
        return empAdvService.findEmpEcByEid(eid);
    }

    @RequestMapping(value = "/listMove/{eid}", method = RequestMethod.GET)
    public List<EmpMove> getMoveByEid(@PathVariable Long eid){
        return empAdvService.findMoveByEid(eid);
    }

}
