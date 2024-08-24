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

import com.cl.entity.YudingxinxiEntity;
import com.cl.entity.view.YudingxinxiView;

import com.cl.service.YudingxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预定信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
@RestController
@RequestMapping("/yudingxinxi")
public class YudingxinxiController {
    @Autowired
    private YudingxinxiService yudingxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YudingxinxiEntity yudingxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yudingxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YudingxinxiEntity> ew = new EntityWrapper<YudingxinxiEntity>();

		PageUtils page = yudingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yudingxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YudingxinxiEntity yudingxinxi, 
		HttpServletRequest request){
        EntityWrapper<YudingxinxiEntity> ew = new EntityWrapper<YudingxinxiEntity>();

		PageUtils page = yudingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yudingxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YudingxinxiEntity yudingxinxi){
       	EntityWrapper<YudingxinxiEntity> ew = new EntityWrapper<YudingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yudingxinxi, "yudingxinxi")); 
        return R.ok().put("data", yudingxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YudingxinxiEntity yudingxinxi){
        EntityWrapper< YudingxinxiEntity> ew = new EntityWrapper< YudingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yudingxinxi, "yudingxinxi")); 
		YudingxinxiView yudingxinxiView =  yudingxinxiService.selectView(ew);
		return R.ok("查询预定信息成功").put("data", yudingxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YudingxinxiEntity yudingxinxi = yudingxinxiService.selectById(id);
		yudingxinxi = yudingxinxiService.selectView(new EntityWrapper<YudingxinxiEntity>().eq("id", id));
        return R.ok().put("data", yudingxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YudingxinxiEntity yudingxinxi = yudingxinxiService.selectById(id);
		yudingxinxi = yudingxinxiService.selectView(new EntityWrapper<YudingxinxiEntity>().eq("id", id));
        return R.ok().put("data", yudingxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YudingxinxiEntity yudingxinxi, HttpServletRequest request){
    	yudingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yudingxinxi);
        yudingxinxiService.insert(yudingxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YudingxinxiEntity yudingxinxi, HttpServletRequest request){
    	yudingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yudingxinxi);
        yudingxinxiService.insert(yudingxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YudingxinxiEntity yudingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yudingxinxi);
        yudingxinxiService.updateById(yudingxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yudingxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
