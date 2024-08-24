package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuxingfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuxingfenleiView;


/**
 * 户型分类
 *
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
public interface HuxingfenleiService extends IService<HuxingfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuxingfenleiView> selectListView(Wrapper<HuxingfenleiEntity> wrapper);
   	
   	HuxingfenleiView selectView(@Param("ew") Wrapper<HuxingfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuxingfenleiEntity> wrapper);
   	

}

