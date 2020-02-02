/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fitt.sixawn.entity.HealthRecord;
import com.fitt.sixawn.service.HealthRecordService;
import com.fitt.sixawn.utils.ExcelUtils;
import com.fitt.sixawn.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>@description : UserController </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Controller
@RequestMapping("health")
public class HealthRecordController {

    private static Logger logger = LoggerFactory.getLogger(HealthRecordController.class);

    @Resource
    private HealthRecordService healthRecordService;

    //------------------------Restful Api--------------------------------//

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return ResultUtils.success(healthRecordService.list(null));
    }

    //------------------------MVC--------------------------------//

    /**
     * 跳转新增提交页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "请提交您信息");
        return "health/index";
    }

    /**
     * 跳转编辑提交页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, String id) {
        model.addAttribute("message", "请提交您信息");
        model.addAttribute("entity", healthRecordService.getById(id));
        return "health/edit";
    }

    /**
     * 删除提交页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model, String id, String key) {
        healthRecordService.removeById(Integer.valueOf(id));
        return list(model, key);
    }

    /**
     * 跳转列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, String id) {
        List<HealthRecord> list = healthRecordService.list(null);

        model.addAttribute("list", list);
        return "health/list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(Model model, HealthRecord healthRecord) {
        String message = "保存成功";
        try {
            // 查询工号是否已提交
            QueryWrapper<HealthRecord> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("idcard", healthRecord.getIdcard());
            HealthRecord entity = healthRecordService.getOne(queryWrapper);
            if (ObjectUtils.isEmpty(entity)) {
                healthRecordService.save(healthRecord);
            } else {
                message = "您已提交过信息";
                healthRecord = entity;
            }
        } catch (Exception ex) {
            message = "保存失败";
            logger.error("保存用户失败: {}", ex.getMessage(), ex);
        }

        model.addAttribute("message", message);
        model.addAttribute("entity", healthRecord);

        return "health/result";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, HealthRecord healthRecord) {
        boolean result = healthRecordService.updateById(healthRecord);

        model.addAttribute("message", result ? "更新成功" : "更新失败");
        model.addAttribute("entity", healthRecord);

        return "health/result";
    }

    @RequestMapping(value = "/export")
    public void exportExcel(HttpServletResponse response, String recordDate) throws IOException {
        List<List<String>> excelData = new ArrayList<>();

        List<String> head = new ArrayList<>();
        head.add("第一列");
        head.add("第二列");
        head.add("第三列");

        List<String> data1 = new ArrayList<>();
        data1.add("123");
        data1.add("234");
        data1.add("345");

        List<String> data2 = new ArrayList<>();
        data2.add("abc");
        data2.add("bcd");
        data2.add("cde");

        excelData.add(head);
        excelData.add(data1);
        excelData.add(data2);

        String sheetName = "测试";
        String fileName = "ExcelTest.xls";

        ExcelUtils.exportExcel(response, excelData, sheetName, fileName, 15);
    }
}
