package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>@description : description  </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2020-02-01 18:14 </p>
 * <p>@version : 1.0.0 </p>
 */
@Data
@TableName("2019ncov_health_record")
public class HealthRecord implements Serializable {

    @ApiModelProperty(" 唯一标识 ")
    private String id ;

    @ApiModelProperty(" 省份 ")
    private String province ;

    @ApiModelProperty(" 市县 ")
    private String city ;

    @ApiModelProperty(" 乡镇 ")
    private String area ;

    @ApiModelProperty(" 行政村 ")
    private String county ;

    @ApiModelProperty(" 姓名 ")
    private String name ;

    @ApiModelProperty(" 手机号码 ")
    private String telephone ;

    @ApiModelProperty(" 身份证号码 ")
    private String idcard ;

    @ApiModelProperty(" 目前湖南居住地 ")
    private String hunan_curr_address ;

    @ApiModelProperty(" 体温 ")
    private Double temp ;

    @ApiModelProperty(" 有无不适;有无咳嗽、胸闷等不适症状 ")
    private String discomfort ;

    @ApiModelProperty(" 湖北居住地 ")
    private String hubei_old_address ;

    @ApiModelProperty(" 离开湖北所在地级市 ")
    private String hubei_leave_city ;

    @ApiModelProperty(" 离开湖北日期 ")
    private Long hubei_leave_date ;

    @ApiModelProperty(" 车次-航班-汽车-自驾 ")
    private String transport ;

    @ApiModelProperty(" 沿途是否停留？;沿途是否停留？如是，停留地点 ")
    private String halfway_stop ;

    @ApiModelProperty(" 同行人员姓名 ")
    private String together ;

    @ApiModelProperty(" 状态;0-无效，1-有效 ")
    private Integer status ;

    @ApiModelProperty(" 创建人;填报人 ")
    private String creator ;

    @ApiModelProperty(" 创建时间;格式:时间戳 ")
    private Long created ;

    @ApiModelProperty(" 修改人;修改人 ")
    private String modifier ;

    @ApiModelProperty(" 修改时间;格式:时间戳 ")
    private Long modified ;

}
