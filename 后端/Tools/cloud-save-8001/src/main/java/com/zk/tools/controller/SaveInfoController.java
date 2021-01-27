package com.zk.tools.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zk.tools.entity.SaveInfoEntity;
import com.zk.tools.service.SaveInfoService;
import com.zk.tools.common.utils.PageUtils;
import com.zk.tools.common.utils.R;



/**
 * 保存信息
 *
 * @author zk
 * @email 645777637@qq.com
 * @date 2021-01-19 11:29:00
 */
@RestController
@RequestMapping("/saveinfo")
public class SaveInfoController {
    @Autowired
    private SaveInfoService saveInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = saveInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sId}")
    public R info(@PathVariable("sId") Integer sId){
		SaveInfoEntity saveInfo = saveInfoService.getById(sId);

        return R.ok().put("saveInfo", saveInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Map param){
        saveInfoService.addInfo(param);
//		saveInfoService.save(saveInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SaveInfoEntity saveInfo){
		saveInfoService.updateById(saveInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] sIds){
		saveInfoService.removeByIds(Arrays.asList(sIds));

        return R.ok();
    }

}
