package com.zk.tools.service.impl;

import com.zk.tools.entity.SaveInfoEntity;
import com.zk.tools.service.SaveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.tools.common.utils.PageUtils;
import com.zk.tools.common.utils.Query;

import com.zk.tools.dao.SaveInfoDao;

import javax.annotation.Resource;


@Service("saveInfoService")
public class SaveInfoServiceImpl extends ServiceImpl<SaveInfoDao, SaveInfoEntity> implements SaveInfoService {
    @Resource
    private SaveInfoDao mapper;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SaveInfoEntity> page = this.page(
                new Query<SaveInfoEntity>().getPage(params),
                new QueryWrapper<SaveInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public boolean addInfo(Map params) {
        Integer i =mapper.addInfo(params);
        if(i>0){
            return true;
        } else {
            return false;
        }
//        return false;
    }

}