package com.cl.dao;

import com.cl.entity.YudingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YudingxinxiView;


/**
 * 预定信息
 * 
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
public interface YudingxinxiDao extends BaseMapper<YudingxinxiEntity> {
	
	List<YudingxinxiView> selectListView(@Param("ew") Wrapper<YudingxinxiEntity> wrapper);

	List<YudingxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YudingxinxiEntity> wrapper);
	
	YudingxinxiView selectView(@Param("ew") Wrapper<YudingxinxiEntity> wrapper);
	

}
