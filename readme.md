# SixAwn Project
> Spring Boot Maven Multipart Module
> SpringBoot+MybatisPlus+JSP

```sql
CREATE TABLE [dbo].[user] (
                                [id] int  NOT NULL IDENTITY(1,1),
                                [name] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
                                [code] varchar(16) COLLATE Chinese_PRC_CI_AS  NULL,
                                [phone] varchar(16) COLLATE Chinese_PRC_CI_AS  NULL,
                                [title] varchar(4) COLLATE Chinese_PRC_CI_AS  NULL,
                                [dept_code] varchar(16) COLLATE Chinese_PRC_CI_AS  NULL,
                                [dept_name] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
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
```

```sql
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '谢琳', '13975881272', '沙田乡政府', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '李光明', '13874865475', '玉潭街道', '-1', '420569129@qq.com', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '陈伟华', '15116187208', '菁华铺乡', '防控办公室工作人员', '906646681@qq.com', '0731-87850020','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '吕长生', '15874262911', '菁华铺乡', '防控办公室工作人员', '3619243@qq.com', '0731-87850020','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '王治引', '13974961693', '巷子口镇社会事务办', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '许新宁', '15273155133', '大屯营', '传染病专干', '1185442831@qq.com', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '崔银华', '18390960001', '花明楼', '主任', '399264641@qq.com', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '宋滔', '18674865866', '喻家坳', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '陈赛帅', '13574100101', '坝塘', '党政综合办 主任', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '卢红飞', '13723870928', '沩山', '妇联主席', '498858747@qq.com', '0731-87350021','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '刘华', '18774841358', '资福', '主任', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '杨新元', '15873172917', '灰汤镇人民政府', '-1', '67537122@qq.com', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '李勃', '15111444077', '宁乡市黄材镇人民政府-党政办', '主任', '616876158@qq.com', '87575130','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '那丹', '15111424488', '双江口镇人民政府-社会事务办', '职工', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '邹智勇', '13507441227', '金洲镇', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '邓海良', '15274908588', '夏铎铺镇社会事务办', '副主任', '337953211@qq.com', '87951853','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '刘洪姣', '13574155248', '回龙铺', '副主任', '294230808qq.com', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '周上人', '17700797894', '横市镇 ', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '袁志国', '13787100316', '老粮仓', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '陈友良', '13787033047', '青山桥镇', '主任', '872578467@qq.com', '87412345','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '谢娟', '18890395008', '流沙河', '卫健中心主任', '517681368@qq.com', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '韩湘', '15074981068', '东湖塘', '办公室主任', '402728806@qq.com', '87053002','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '周爱玲', '18207413458', '双凫铺', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '张丰宜', '15200852951', '煤炭坝镇社会事务办', '办公室副主任', 'zhangfengyi2951@dingtalk.com', '0731-87902088','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '龙友良', '15700785482', '龙田', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '李时钟', '15274855456', '白马桥', '主任', '25569365', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '陈国徽', '15874912870', '历经铺街道办事处', '社会综合服务中心副主任', '577185534@QQ.com', '0731-87790071','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '谢丽莎', '18874058448', '高新区', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '唐晓华', '13874871388', '大成桥', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '谢喜阳', '13875875518', '经开区', '-1', '-1', '-1','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '王卫红', '13874943492', '城郊街道办事处', '社会事务办主任', '495640774@qq.com', '0731-87218005','1', '1', '-1', now());
INSERT INTO 2019ncov_data_user(id, name, phone, dept, title, email, mobile, first_login, status, creator, created) values(left(md5(uuid()),24), '胡超群', '18711105600', '道林', '-1', '-1', '-1','1', '1', '-1', now());

update 2019ncov_data_user set PASSWORD = RIGHT(phone, 6);

select * from  2019ncov_data_user;


```