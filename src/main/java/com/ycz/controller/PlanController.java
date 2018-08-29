package com.ycz.controller;

import com.github.pagehelper.PageInfo;
import com.ycz.constant.WebConst;
import com.ycz.exception.TipException;
import com.ycz.model.Bo.RestResponseBo;
import com.ycz.model.Vo.PlanVo;
import com.ycz.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("admin/plan")
public class PlanController {

    @Autowired
    private IPlanService planService;

    @GetMapping(value = "/list")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "10") int limit,
                        HttpServletRequest request){
        PageInfo<PlanVo> planVoPageInfo = planService.getPlanWithpage(page, limit);
        request.setAttribute("plans", planVoPageInfo);
        return "admin/plan_list";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public RestResponseBo editPlan(PlanVo planVo){
        String result = planService.saveOrUpdate(planVo);
        if(WebConst.SUCCESS_RESULT != result){
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "/findById")
    @ResponseBody
    public RestResponseBo findById(Integer id){
        PlanVo planVo = planService.queryById(id);
        if(null != planVo){
            return RestResponseBo.ok(planVo);
        }
        return RestResponseBo.fail();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public RestResponseBo delPlan(Integer id){
        try{
            planService.delete(id);
        }catch (Exception e){
            String msg = "删除失败";
            if(e instanceof TipException){
                msg = e.getMessage();
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
