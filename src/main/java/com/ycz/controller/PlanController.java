package com.ycz.controller;

import com.github.pagehelper.PageInfo;
import com.ycz.constant.WebConst;
import com.ycz.model.Bo.RestResponseBo;
import com.ycz.model.Vo.PlanVo;
import com.ycz.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
}
