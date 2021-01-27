package com.zk.tools.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.tools.common.utils.PageUtils;
import com.zk.tools.entity.SaveInfoEntity;

import java.util.Map;

/**
 * 保存信息
 *
 * @author zk
 * @email 645777637@qq.com
 * @date 2021-01-19 11:29:00
 */
public interface SaveInfoService extends IService<SaveInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    public boolean addInfo(Map params);
}

