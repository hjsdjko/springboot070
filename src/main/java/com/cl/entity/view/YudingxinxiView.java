package com.cl.entity.view;

import com.cl.entity.YudingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 预定信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
@TableName("yudingxinxi")
public class YudingxinxiView  extends YudingxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YudingxinxiView(){
	}
 
 	public YudingxinxiView(YudingxinxiEntity yudingxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yudingxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
