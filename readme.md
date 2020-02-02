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



```