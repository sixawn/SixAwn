## SixAwn Project
> Spring Boot Maven Multipart Module
> SpringBoot+MybatisPlus+JSP

### 用户表创建 SQL
```sql
# SQL Server
CREATE TABLE [dbo].[user] (
                                [id] int  NOT NULL IDENTITY(1,1),
                                [name] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
                                [code] varchar(16) COLLATE Chinese_PRC_CI_AS  NULL,
                                [phone] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
                                [dept_code] varchar(256) COLLATE Chinese_PRC_CI_AS  NULL,
                                [dept_name] text COLLATE Chinese_PRC_CI_AS  NULL,
                                [title] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
                                [permission] varchar(10) COLLATE Chinese_PRC_CI_AS  NULL,
                                CONSTRAINT [PK__user__3213E83F98978727] PRIMARY KEY CLUSTERED ([id])
                                  WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
                                  ON [PRIMARY],
                                CONSTRAINT [uk_id] UNIQUE NONCLUSTERED ([id] ASC)
                                  WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
                                  ON [PRIMARY]
)
  ON [PRIMARY]
GO

ALTER TABLE [dbo].[user] SET (LOCK_ESCALATION = TABLE)
GO

CREATE TABLE [dbo].[dept] (
                                [dept_code] varchar(16) NOT NULL ,
                                [dept_name] varchar(64) COLLATE Chinese_PRC_CI_AS  NULL,
                                [dept_type] varchar(2) COLLATE Chinese_PRC_CI_AS  NULL,
                                [area] varchar(10) COLLATE Chinese_PRC_CI_AS  NULL,
                                CONSTRAINT [PK__user__3213E83F98978747] PRIMARY KEY CLUSTERED ([dept_code])
                                  WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
                                  ON [PRIMARY]
)
  ON [PRIMARY]
GO

ALTER TABLE [dbo].[dept] SET (LOCK_ESCALATION = TABLE)
GO

alter table [dbo].[user] add permission varchar(10) default null;
alter table [dbo].[user] add title varchar(10) default null;

  
```

```sql
# MySQL
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `dept_code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属科室',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属科室',
  `title` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1-主任医师;2-副主任医师;3-主治医师;4-住院医师;5-主任护师;6-副主任护师;7-主管护师;8-护师;9-护士',
  `permission` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开通权限：1-会诊；2-转运',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_code`(`code`) USING BTREE,
  INDEX `idx_name`(`name`) USING BTREE,
  INDEX `idx_phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

alter table user add column permission varchar(2) comment '开通权限：1-会诊；2-转运' after title;


CREATE TABLE `dept`  (
  `dept_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室编码',
  `dept_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名',
  `dept_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室类型：1-门诊；2-住院',
  `area` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院区：1-儿童院区；2-珠江院区；3-妇婴院区；4-增城院区；',
  PRIMARY KEY (`dept_code`) USING BTREE,
  INDEX `idx_dept_code`(`dept_code`) USING BTREE,
  INDEX `idx_dept_name`(`dept_name`) USING BTREE,
  INDEX `idx_dept_type`(`dept_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

```

```sql
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10006', '儿-儿童神内门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('100073', '儿-口腔正畸门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('100074', '儿-口腔内科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10008', '儿-儿童针灸门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10009', '儿-儿童保健门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10011', '儿-普儿门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10013', '儿-皮肤门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('100131', '儿-血管瘤激光门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10014', '儿-马蹄足门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10015', '儿-眼科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10019', '儿-儿童中医门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10021', '儿-新生儿门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10022', '儿-儿童肿瘤门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10023', '儿-心血管门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10024', '儿-儿童外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10025', '儿-儿童肾内门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10026', '儿-儿童血液门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10027', '儿-儿童免疫门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10028', '儿-儿童消化门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10029', '儿-儿童内分泌门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10030', '儿-儿童呼吸门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10031', '儿-儿童心理门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10033', '儿-耳鼻喉门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10034', '儿-介入门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10035', '儿-儿童营养门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10047', '儿-儿童感染门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10050', '儿-儿童特需门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10057', '儿-早产儿和高危儿保健门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10061', '儿-儿童听力门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10069', '儿-平价门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10070', '儿-伤口造口护理门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10071', '儿-肠道外科护理门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10072', '儿-放射门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10081', '儿-儿童肝病门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1104', '儿-骨科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11045', '儿-神经外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1105', '儿-泌尿外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11050', '儿-难治性癫痫门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1106', '儿-胸外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1107', '儿-普外/胃肠外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1108', '儿-普外/肿瘤外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1109', '儿-普外/新生儿外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1110', '儿-颅脑外科门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('12004', '儿-睡眠中心', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('16002', '儿-职工门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('1706', '儿-多学科会诊门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('18008', '儿-新生儿护理门诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10005', '儿-儿科急诊', '1', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('100052', '儿-急诊外科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('100053', '儿-儿科急诊观察室', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('100054', '儿-儿童急诊观察室-短暂处置区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11001', '儿-PICU', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11002', '儿-NICU', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11005', '儿-儿童感染病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11006', '儿-儿童消化病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11007', '儿-儿童呼吸病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11008', '儿-儿童肾内病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11010', '儿-儿童风湿与免疫病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11012', '儿-儿童神经内科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11013', '儿-心脏内科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11017', '儿-耳鼻喉科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('110222', '儿-骨科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('110223', '儿-泌尿外科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('110233', '儿-日间手术病房', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('110242', '儿-颅脑外科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('110243', '儿-胸外科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11031', '儿-儿童危重综合病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11033', '儿-口腔外科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11034', '儿-眼科病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11041', '儿-NICU日间病房', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11042', '儿-儿童急诊综合病区', '2', '1');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('10082', '珠-儿童肝病门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20006', '儿-儿童神内门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200071', '珠-口腔外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200072', '珠-放射门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200073', '珠-口腔正畸门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200074', '珠-口腔内科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20008', '珠-新生儿护理门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200091', '珠-儿童保健门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('2001', '儿-小儿疝气门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20010', '珠-儿童糖尿病护理咨询门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20011', '珠-普儿科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20013', '珠-皮肤门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200131', '珠-血管瘤激光门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20014', '珠-马蹄足门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20015', '珠-眼科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20016', '珠-儿外科急诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20019', '珠-儿童中医门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200191', '珠-成人中医门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200192', '珠-成人内科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200193', '珠-职工门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20021', '珠-新生儿门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20022', '珠-先天性心脏病门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20023', '珠-心血管门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20024', '珠-外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200241', '珠-乳腺外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200244', '珠-泌尿外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200245', '珠-胸外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200246', '珠-普外/胃肠外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200248', '珠-普外/肿瘤外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200249', '珠-普外/新生儿外科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20025', '珠-儿童肾内门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20026', '儿-儿童血液门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20027', '珠-儿童免疫门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20028', '珠-儿童消化门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20029', '珠-儿童内分泌门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20030', '珠-儿童呼吸门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20031', '珠-儿童心理门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20033', '珠-耳鼻喉门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20034', '珠-产科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200341', '珠-产后42天门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('2003420', '珠-营养门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200343', '珠-助产士门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20035', '珠-妇科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('200355', '珠-计划生育门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20036', '珠-妇产科急诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20037', '珠-优生优育门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20038', '珠-儿科急诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20040', '珠-成人注射抽血室', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20041', '珠-PICU门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20046', '珠-儿童营养门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20047', '珠-儿童感染门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20051', '珠-儿童早期发展门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20052', '珠-产前诊断门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20053', '珠-围产营养门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20057', '珠-高危新生儿随访门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20058', '珠-女性心理健康门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20060', '珠-婚前孕前保健中心', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20061', '珠-儿童听力门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20063', '珠-特诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20065', '珠-儿童输液室', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20067', '珠-计划生育门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20068', '珠-发热门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20069', '珠-平价门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20070', '珠-盆底康复中心', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20071', '珠-儿童血液肿瘤日间病房', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20072', '珠-妇科咨询门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20073', '珠-男科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20075', '珠-高龄孕前(再)生育评估门诊(女科)', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20076', '珠-高龄孕前(再)生育评估门诊(男科)', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20077', '珠-伤口造口护理门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('2010', '珠-妇科内分泌门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20344', '珠-产内科门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20777', '珠-儿童神经发育保健门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21048', '珠-母乳喂养咨询门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21070', '珠-神经外科/脑积水门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21080', '珠-难治性癫痫门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('220058', '珠-儿童血友病门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('220059', '珠-视网膜母细胞瘤门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('22013', '珠-麻醉科手术室-麻醉与疼痛门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('24007', '珠-客服中心', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('24009', '珠-门诊复苏室', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('27008', '珠-中医针推门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('2705', '珠-遗传咨询门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('2706', '珠-多学科会诊门诊', '1', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30002', '妇-产科门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('300021', '妇-产后42天门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30004', '妇-成人中医门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30005', '妇-成人内科门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30006', '妇-乳腺外科门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('300074', '妇-口腔内科门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30008', '妇-耳鼻喉门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30009', '妇-眼科门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30010', '妇-生殖医学中心', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30011', '妇-男科门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30012', '妇-优生优育门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30013', '妇-营养门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30014', '妇-皮肤门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30015', '妇-儿童保健门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30016', '妇-盆底康复中心', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30017', '妇-针灸门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30018', '妇-筛查中心门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30019', '妇-新生儿门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30020', '妇-客服中心', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30024', '妇-妇产科急诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30025', '妇-妇科特需门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30026', '妇-产科特需门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30027', '妇-高危新生儿随访门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30028', '妇-婚检门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30029', '妇-新生儿护理门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30030', '妇-门诊注射室', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30031', '妇-婚前孕前保健中心', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30032', '妇-产科特诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30034', '妇-助产士门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30035', '妇-妇科咨询门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30051', '妇-儿童早期发展门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30058', '妇-女性心理健康门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30069', '妇-平价门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30099', '妇-宫腔镜诊治中心', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31049', '妇-母乳喂养咨询门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31050', '妇-乳腺护理门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('32013', '妇-麻醉与疼痛门诊', '1', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('11011', '珠-儿童血液肿瘤病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20001', '珠-NICU日间病房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20002', '珠-胃肠外科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('2003', '珠-产控中心', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20032', '珠-高危产科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20045', '珠-儿科急诊观察室', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('20056', '珠-妇产科急诊留观病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21001', '珠-儿童呼吸病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('210011', '珠-儿童呼吸日间病房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21002', '珠-儿童消化病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21003', '珠-儿童遗传与内分泌病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21006', '珠-产房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21007', '珠-生殖免疫妇科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21008', '珠-NICU', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('210081', '珠-SNICU', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21011', '珠-儿童神经内科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21012', '珠-泌尿外科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21013', '珠-PICU', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21016', '珠-CICU', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21017', '珠-心血管病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21019', '珠-产二病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21020', '珠-普通与泌尿妇科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21023', '珠-儿童遗传与内分泌日间病房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21024', '珠-产三病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21025', '珠-产六病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21026', '珠-骨科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21028', '珠-肿瘤妇科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21029', '珠-妇产科ICU', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21030', '珠-肝胆外科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21031', '珠-肿瘤外科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21032', '珠-新生儿外科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21035', '珠-眼科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21036', '珠-耳鼻喉科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21037', '珠-口腔外科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21045', '珠-日间手术病房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21046', '珠-儿童消化日间病房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21047', '珠-儿童免疫日间病房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21050', '珠-产八病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21051', '珠-儿科急诊观察室-短暂处置区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21058', '珠-微创妇科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('211255', '珠-乳腺外科日间病房', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('21128', '珠-乳腺外科病区', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('28011', '珠-高危产科ICU', '2', '2');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('30003', '妇-产控中心', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31001', '妇-NICU病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31003', '妇-产二病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31004', '妇-产三病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31006', '妇-产房', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31007', '妇-肿瘤妇科病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31008', '妇-生殖内分泌妇科病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31015', '妇-怡康园病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31016', '妇-产一病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31017', '妇-产前区病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31019', '妇-乳腺外科病区', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('310245', '妇-日间手术病房', '2', '3');
INSERT INTO dept(dept_code, dept_name, dept_type, area) VALUES ('31041', '妇-NICU日间病房', '2', '3');

```

```sql mysql

```

### 数据库连接配置
```text
driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
url: jdbc:sqlserver://192.168.50.40:1433;DatabaseName=dbname
username: sa
password: sa
```