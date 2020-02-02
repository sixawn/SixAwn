package com.fitt.sixawn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fitt.sixawn.entity.HealthRecord;
import com.fitt.sixawn.mapper.HealthRecordMapper;
import com.fitt.sixawn.service.HealthRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>@description : description  </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2020-02-01 21:11 </p>
 * <p>@version : 1.0.0 </p>
 */
@Service
public class HealthRecordServiceImpl extends ServiceImpl<HealthRecordMapper, HealthRecord> implements HealthRecordService {
}
