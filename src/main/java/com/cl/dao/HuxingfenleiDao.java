package com.cl.dao;

import com.cl.entity.HuxingfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuxingfenleiView;


/**
 * 户型分类
 * 
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
public interface HuxingfenleiDao extends BaseMapper<HuxingfenleiEntity> {
	
	List<HuxingfenleiView> selectListView(@Param("ew") Wrapper<HuxingfenleiEntity> wrapper);

	List<HuxingfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<HuxingfenleiEntity> wrapper);
	
	HuxingfenleiView selectView(@Param("ew") Wrapper<HuxingfenleiEntity> wrapper);
	

}
