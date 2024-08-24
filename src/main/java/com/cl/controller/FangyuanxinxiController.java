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

import com.cl.entity.FangyuanxinxiEntity;
import com.cl.entity.view.FangyuanxinxiView;

import com.cl.service.FangyuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 房源信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
@RestController
@RequestMapping("/fangyuanxinxi")
public class FangyuanxinxiController {
    @Autowired
    private FangyuanxinxiService fangyuanxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangyuanxinxiEntity fangyuanxinxi,
		HttpServletRequest request){
        EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();

		PageUtils page = fangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangyuanxinxiEntity fangyuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();

		PageUtils page = fangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangyuanxinxiEntity fangyuanxinxi){
       	EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangyuanxinxi, "fangyuanxinxi")); 
        return R.ok().put("data", fangyuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangyuanxinxiEntity fangyuanxinxi){
        EntityWrapper< FangyuanxinxiEntity> ew = new EntityWrapper< FangyuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangyuanxinxi, "fangyuanxinxi")); 
		FangyuanxinxiView fangyuanxinxiView =  fangyuanxinxiService.selectView(ew);
		return R.ok("查询房源信息成功").put("data", fangyuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangyuanxinxiEntity fangyuanxinxi = fangyuanxinxiService.selectById(id);
		fangyuanxinxi.setClicktime(new Date());
		fangyuanxinxiService.updateById(fangyuanxinxi);
		fangyuanxinxi = fangyuanxinxiService.selectView(new EntityWrapper<FangyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangyuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangyuanxinxiEntity fangyuanxinxi = fangyuanxinxiService.selectById(id);
		fangyuanxinxi.setClicktime(new Date());
		fangyuanxinxiService.updateById(fangyuanxinxi);
		fangyuanxinxi = fangyuanxinxiService.selectView(new EntityWrapper<FangyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangyuanxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        FangyuanxinxiEntity fangyuanxinxi = fangyuanxinxiService.selectById(id);
        if(type.equals("1")) {
        	fangyuanxinxi.setThumbsupnum(fangyuanxinxi.getThumbsupnum()+1);
        } else {
        	fangyuanxinxi.setCrazilynum(fangyuanxinxi.getCrazilynum()+1);
        }
        fangyuanxinxiService.updateById(fangyuanxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request){
    	fangyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanxinxi);
        fangyuanxinxiService.insert(fangyuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request){
    	fangyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanxinxi);
        fangyuanxinxiService.insert(fangyuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangyuanxinxi);
        fangyuanxinxiService.updateById(fangyuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangyuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request,String pre){
        EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = fangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanxinxi), params), params));
        return R.ok().put("data", page);
    }








}
