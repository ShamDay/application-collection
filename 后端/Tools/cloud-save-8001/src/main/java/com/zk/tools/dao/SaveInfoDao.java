package com.zk.tools.dao;

import com.zk.tools.entity.SaveInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 保存信息
 * 
 * @author zk
 * @email 645777637@qq.com
 * @date 2021-01-19 11:29:00
 */
@Mapper
public interface SaveInfoDao extends BaseMapper<SaveInfoEntity> {

    Integer addInfo(Map params);
}
