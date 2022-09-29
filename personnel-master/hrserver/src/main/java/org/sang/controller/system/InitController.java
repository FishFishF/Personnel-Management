package org.sang.controller.system;

import com.alibaba.excel.EasyExcel;
import org.apache.ibatis.javassist.bytecode.ClassFileWriter;
import org.sang.bean.Employee;
import org.sang.bean.RespBean;
import org.sang.common.poi.PoiUtils;
import org.sang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/system/init")
public class InitController {
    @Autowired
    ResetService resetService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    PositionService positionService;

    @Autowired
    EmpService empService;

    @Autowired
    JobLevelService jobLevelService;

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public RespBean rest() {
       try {
           resetService.resetAppraise();
           resetService.resetEmpSalary();
           resetService.resetEmployeeec();
           resetService.resetPoint();
           resetService.resetEmpolyee();
           resetService.resetEmployeeremove();
           resetService.resetEmployeeTrain();
           resetService.resetAdjustSalary();
       }catch (Exception e){
           return RespBean.error("重置失败");
       }
        return RespBean.ok("重置成功");
    }

    @RequestMapping(value = "/downEmpFile", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downEmpFile(HttpServletResponse response) throws IOException {

//        List<Employee> allEmp = new ArrayList<>();
//        try {
//            // 配置response
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//            response.setCharacterEncoding("utf-8");
//            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//            String fileName = URLEncoder.encode("员工信息库", "UTF-8").replaceAll("\\+", "%20");
//            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//            allEmp = empService.getAllEmp();
//            EasyExcel.write(response.getOutputStream(), Employee.class).sheet("员工信息库").doWrite(allEmp);
//        }catch(Exception e){
//            int i = 0;
//        }
            ResponseEntity<byte[]> responseEntity = PoiUtils.exportEmp2Excel(empService.getAllEmployees());
            return responseEntity;

        }

    @RequestMapping(value = "/importEmp", method = RequestMethod.POST)
    public RespBean importEmp(MultipartFile file) {
        empService.deleteAll();
        List<Employee> emps = PoiUtils.importEmp2List(file,
                empService.getAllNations(), empService.getAllPolitics(),
                departmentService.getAllDeps(), positionService.getAllPos(),
                jobLevelService.getAllJobLevels());
        if (empService.addEmps(emps) == emps.size()) {
            return RespBean.ok("恢复成功!");
        }
        return RespBean.error("恢复失败!");
    }

    @RequestMapping(value = "/resetDanger", method = RequestMethod.GET)
    public RespBean restDanger() {
        try {
            resetService.resetDanger();
        }catch (Exception e){
            return RespBean.error("重置失败");
        }
        return RespBean.ok("重置成功");
    }

}
