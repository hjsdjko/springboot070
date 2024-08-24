package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.HuxingfenleiDao;
import com.cl.entity.HuxingfenleiEntity;
import com.cl.service.HuxingfenleiService;
import com.cl.entity.view.HuxingfenleiView;

@Service("huxingfenleiService")
public class HuxingfenleiServiceImpl extends ServiceImpl<HuxingfenleiDao, HuxingfenleiEntity> implements HuxingfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuxingfenleiEntity> page = this.selectPage(
                new Query<HuxingfenleiEntity>(params).getPage(),
                new EntityWrapper<HuxingfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuxingfenleiEntity> wrapper) {
		  Page<HuxingfenleiView> page =new Query<HuxingfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuxingfenleiView> selectListView(Wrapper<HuxingfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuxingfenleiView selectView(Wrapper<HuxingfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
