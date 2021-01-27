package com.zk.tools.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 保存信息
 * 
 * @author zk
 * @email 645777637@qq.com
 * @date 2021-01-19 11:29:00
 */
@Data
@TableName("save_info")
public class SaveInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer sId;
	/**
	 * 信息名称
	 */
	private String sName;
	/**
	 * 信息类型
	 */
	private String sType;
	/**
	 * 状态 0生效 1失效
	 */
	private String state;
	/**
	 * 创建时间
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 信息内容
	 */
	private String text;

}
