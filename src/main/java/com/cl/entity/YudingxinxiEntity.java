package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 预定信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-12 08:48:30
 */
@TableName("yudingxinxi")
public class YudingxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YudingxinxiEntity() {
		
	}
	
	public YudingxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 房源名称
	 */
					
	private String fangyuanmingcheng;
	
	/**
	 * 位置
	 */
					
	private String weizhi;
	
	/**
	 * 面积
	 */
					
	private String mianji;
	
	/**
	 * 户型
	 */
					
	private String huxing;
	
	/**
	 * 家具
	 */
					
	private String jiaju;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 预定价格
	 */
					
	private String yudingjiage;
	
	/**
	 * 开始租赁日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date kaishizulinriqi;
	
	/**
	 * 结束租赁日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jieshuzulinriqi;
	
	/**
	 * 评价状态
	 */
					
	private String pingjiazhuangtai;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：房源名称
	 */
	public void setFangyuanmingcheng(String fangyuanmingcheng) {
		this.fangyuanmingcheng = fangyuanmingcheng;
	}
	/**
	 * 获取：房源名称
	 */
	public String getFangyuanmingcheng() {
		return fangyuanmingcheng;
	}
	/**
	 * 设置：位置
	 */
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	/**
	 * 获取：位置
	 */
	public String getWeizhi() {
		return weizhi;
	}
	/**
	 * 设置：面积
	 */
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	/**
	 * 获取：面积
	 */
	public String getMianji() {
		return mianji;
	}
	/**
	 * 设置：户型
	 */
	public void setHuxing(String huxing) {
		this.huxing = huxing;
	}
	/**
	 * 获取：户型
	 */
	public String getHuxing() {
		return huxing;
	}
	/**
	 * 设置：家具
	 */
	public void setJiaju(String jiaju) {
		this.jiaju = jiaju;
	}
	/**
	 * 获取：家具
	 */
	public String getJiaju() {
		return jiaju;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：预定价格
	 */
	public void setYudingjiage(String yudingjiage) {
		this.yudingjiage = yudingjiage;
	}
	/**
	 * 获取：预定价格
	 */
	public String getYudingjiage() {
		return yudingjiage;
	}
	/**
	 * 设置：开始租赁日期
	 */
	public void setKaishizulinriqi(Date kaishizulinriqi) {
		this.kaishizulinriqi = kaishizulinriqi;
	}
	/**
	 * 获取：开始租赁日期
	 */
	public Date getKaishizulinriqi() {
		return kaishizulinriqi;
	}
	/**
	 * 设置：结束租赁日期
	 */
	public void setJieshuzulinriqi(Date jieshuzulinriqi) {
		this.jieshuzulinriqi = jieshuzulinriqi;
	}
	/**
	 * 获取：结束租赁日期
	 */
	public Date getJieshuzulinriqi() {
		return jieshuzulinriqi;
	}
	/**
	 * 设置：评价状态
	 */
	public void setPingjiazhuangtai(String pingjiazhuangtai) {
		this.pingjiazhuangtai = pingjiazhuangtai;
	}
	/**
	 * 获取：评价状态
	 */
	public String getPingjiazhuangtai() {
		return pingjiazhuangtai;
	}

}
