/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.controller;

import com.fitt.sixawn.dto.ResultDTO;
import com.fitt.sixawn.service.PreviewService;
import com.fitt.sixawn.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * <p>@description 文件服务 API </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-10-13
 */
@Slf4j
@RestController
@RequestMapping("/files/")
public class FileController extends BaseController {
    @Resource
    private PreviewService previewService;

    @PostMapping("convert")
    public String convert(@RequestParam("file") MultipartFile file,
                          @RequestParam(value = "fileExt", required = false) String fileExt) {
        if (file.isEmpty()) {
            log.warn("file is empty");
            return ResultUtils.fail();
        }

        String fileName = file.getOriginalFilename();
        try {

            ResultDTO resultDTO = previewService.convertPDF(file.getInputStream(), fileName, fileExt);
            return ResultUtils.success(resultDTO);
        } catch (IOException e) {
            log.error("convertFile error:{}", e.getMessage(), e);
        }

        return ResultUtils.fail(HttpStatus.EXPECTATION_FAILED);
    }
}
