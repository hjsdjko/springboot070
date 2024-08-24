package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.HuxingfenleiEntity;
import com.cl.entity.view.HuxingfenleiView;

import com.cl.service.HuxingfenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 户型分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
@RestController
@RequestMapping("/huxingfenlei")
public class HuxingfenleiController {
    @Autowired
    private HuxingfenleiService huxingfenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuxingfenleiEntity huxingfenlei,
		HttpServletRequest request){
        EntityWrapper<HuxingfenleiEntity> ew = new EntityWrapper<HuxingfenleiEntity>();

		PageUtils page = huxingfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huxingfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuxingfenleiEntity huxingfenlei, 
		HttpServletRequest request){
        EntityWrapper<HuxingfenleiEntity> ew = new EntityWrapper<HuxingfenleiEntity>();

		PageUtils page = huxingfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huxingfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuxingfenleiEntity huxingfenlei){
       	EntityWrapper<HuxingfenleiEntity> ew = new EntityWrapper<HuxingfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huxingfenlei, "huxingfenlei")); 
        return R.ok().put("data", huxingfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuxingfenleiEntity huxingfenlei){
        EntityWrapper< HuxingfenleiEntity> ew = new EntityWrapper< HuxingfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huxingfenlei, "huxingfenlei")); 
		HuxingfenleiView huxingfenleiView =  huxingfenleiService.selectView(ew);
		return R.ok("查询户型分类成功").put("data", huxingfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuxingfenleiEntity huxingfenlei = huxingfenleiService.selectById(id);
		huxingfenlei = huxingfenleiService.selectView(new EntityWrapper<HuxingfenleiEntity>().eq("id", id));
        return R.ok().put("data", huxingfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuxingfenleiEntity huxingfenlei = huxingfenleiService.selectById(id);
		huxingfenlei = huxingfenleiService.selectView(new EntityWrapper<HuxingfenleiEntity>().eq("id", id));
        return R.ok().put("data", huxingfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuxingfenleiEntity huxingfenlei, HttpServletRequest request){
    	huxingfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huxingfenlei);
        huxingfenleiService.insert(huxingfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuxingfenleiEntity huxingfenlei, HttpServletRequest request){
    	huxingfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huxingfenlei);
        huxingfenleiService.insert(huxingfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuxingfenleiEntity huxingfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huxingfenlei);
        huxingfenleiService.updateById(huxingfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huxingfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
