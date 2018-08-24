package com.ycz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycz.constant.WebConst;
import com.ycz.dao.PlanVoMapper;
import com.ycz.model.Vo.PlanVo;
import com.ycz.service.IPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements IPlanService {

    @Autowired
    private PlanVoMapper planVoDao;

    @Override
    public Integer insert(PlanVo planVo) {
        return planVoDao.insertSelective(planVo);
    }

    @Override
    public Integer update(PlanVo planVo) {
        return planVoDao.updateByPrimaryKeySelective(planVo);
    }

    @Override
    public PlanVo queryById(Integer Id) {
        if(null != Id){
            return planVoDao.selectByPrimaryKey(Id);
        }
        return null;
    }

    @Override
    public Integer delete(Integer Id) {
        if(null != Id){
            return planVoDao.deleteByPrimaryKey(Id);
        }
        return null;
    }

    @Override
    public PageInfo<PlanVo> getPlanWithpage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<PlanVo> planVos = planVoDao.selectWithPage();
        return new PageInfo<>(planVos);
    }

    @Override
    public String saveOrUpdate(PlanVo planVo){
        if(StringUtils.isBlank(planVo.getTitle())){
            return "计划不能为空";
        }
        if(StringUtils.isBlank(planVo.getContent())){
            return "简介不能为空";
        }
        if(null == planVo.getStartTime()){
            return "开始日期不为空";
        }
        if(null == planVo.getEndTime()){
            return "结束日期不能为空";
        }
        if(planVo.getStartTime().getTime() > planVo.getEndTime().getTime()){
            return "开始日期应小于结束日期";
        }
        if(null == planVo.getId()){
            insert(planVo);
        }else{
            update(planVo);
        }
        return WebConst.SUCCESS_RESULT;
    }
}
