package org.sang.controller.personnel;

import org.sang.bean.*;
import org.sang.service.AppraiseService;
import org.sang.service.DangerService;
import org.sang.service.EmpService;
import org.sang.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personnel/appraise")
public class AppraiseController {
    @Autowired
    AppraiseService appraiseService;

    @Autowired
    EmpService empService;

    @Autowired
    PointService pointService;

    @Autowired
    DangerService dangerService;

    @RequestMapping(value = "/addappraise", method = RequestMethod.POST)
    public RespBean addAppraise(Appraise appraise){
        if(empService.getEmpById(appraise.getEid())==null){
            return RespBean.error("员工号不存在");
        }
        if(appraiseService.addAppraise(appraise)==1){
            Long eid=appraise.getEid();
            System.out.println(eid);
            int addpoint=appraise.getAppResult();
            System.out.println(addpoint);
            int nowpoint=pointService.findPointsByEid(appraise.getEid());
            pointService.updatePoint(eid,addpoint+nowpoint);
            System.out.println(nowpoint);
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败");
    }

    @RequestMapping(value = "/listAppraises", method = RequestMethod.GET)
    public List<Appraise> getAllAppraises(){
        return appraiseService.getAllApprise();
    }


    @RequestMapping(value = "/deleteAppraise/{id}", method = RequestMethod.DELETE)
    public RespBean deleteAppraise(@PathVariable Long id){
        Appraise appraise=appraiseService.findAppraiseByid(id);
        Long eid=appraise.getEid();
        int nowpoint=pointService.findPointsByEid(eid);
        int point=appraise.getAppResult();
        if(appraiseService.deleteAppraise(id)==1){
            if(point>=0){
                pointService.updatePoint(eid,nowpoint-point);
                return RespBean.ok("删除成功");
            }else {
                pointService.updatePoint(eid,nowpoint+Math.abs(point));
                return RespBean.ok("删除成功");
            }
        }
        return RespBean.error("删除失败");
    }


    //全查积分的接口
    @RequestMapping(value = "/listPoint", method = RequestMethod.GET)
    public List<Point> getAllPoint(){
        return pointService.getAllPoint();
    }

    @RequestMapping(value = "/EmpPoint/{eid}" ,method = RequestMethod.GET)
    public int getEmpPoint(@PathVariable Long eid){
        return pointService.findPointsByEid(eid);
    }



    //查积分小于10的
    @RequestMapping(value = "/listPointDanger", method = RequestMethod.GET)
    public List<Point>getPointDanger(){
        return pointService.getPointDanger();
    }

    //减少薪资
    @RequestMapping(value = "/addDanger/{eid}", method = RequestMethod.POST)
    public RespBean addDanger(@PathVariable Long eid){
        if(dangerService.insertDanger(eid)==1){
            return RespBean.ok("完成减薪");
        }else {
            return RespBean.error("已经减薪或失败");
        }
    }
}
