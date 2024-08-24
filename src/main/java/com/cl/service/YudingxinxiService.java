package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YudingxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YudingxinxiView;


/**
 * 预定信息
 *
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
public interface YudingxinxiService extends IService<YudingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YudingxinxiView> selectListView(Wrapper<YudingxinxiEntity> wrapper);
   	
   	YudingxinxiView selectView(@Param("ew") Wrapper<YudingxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YudingxinxiEntity> wrapper);
   	

}

