/*******************************************************************************
 *                                                                             *
 * Copyright © 2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 ******************************************************************************/
package com.fitt.sixawn.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fitt.sixawn.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>@description 基础控制器 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version 1.0.0
 * @since 2020-08-17
 */
public class BaseController<Service extends IService<T>, T> {

    @Autowired
    protected Service service;

    /**
     * 新增保存数据
     *
     * @param entity 对象参数
     * @return 操作结果
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(T entity) {
        return ResultUtils.success(service.save(entity));
    }

    /**
     * 删除数据
     *
     * @param id 主键参数
     * @return 操作结果
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ResponseBody
    public Object remove(String id) {
        return ResultUtils.success(service.removeById(id));
    }

    /**
     * 新增保存数据
     *
     * @param entity 对象参数
     * @return 操作结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(T entity) {
        return ResultUtils.success(service.updateById(entity));
    }

    /**
     * 新增保存数据
     *
     * @param id 主键参数
     * @return 操作结果
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Object get(String id) {
        return ResultUtils.success(service.getById(id));
    }
    
}
