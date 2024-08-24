package com.cl.entity.view;

import com.cl.entity.HuxingfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 户型分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
@TableName("huxingfenlei")
public class HuxingfenleiView  extends HuxingfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuxingfenleiView(){
	}
 
 	public HuxingfenleiView(HuxingfenleiEntity huxingfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, huxingfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
