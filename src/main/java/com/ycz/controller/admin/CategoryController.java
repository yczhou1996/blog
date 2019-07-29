package com.ycz.controller.admin;

import com.ycz.constant.WebConst;
import com.ycz.model.bo.RestResponseBo;
import com.ycz.model.vo.CategoryVo;
import com.ycz.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author admin
 */
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String list(HttpServletRequest request){
        List<CategoryVo> categoryVos = categoryService.selectCategory();
        request.setAttribute("categories", categoryVos);
        return "admin/category";
    }

    @PostMapping("/edit")
    @ResponseBody
    public RestResponseBo editCategory(@RequestParam Integer id, @RequestParam String name){
        CategoryVo categoryVo = new CategoryVo(id, name);
        String result = categoryService.saveOrUpdate(categoryVo);
        if(result != WebConst.SUCCESS_RESULT){
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @PostMapping("/del")
    @ResponseBody
    public RestResponseBo delCategory(@RequestParam Integer id){
        if(null == id){
            return RestResponseBo.fail("删除失败");
        }
        categoryService.delete(id);
        return RestResponseBo.ok();
    }
}
