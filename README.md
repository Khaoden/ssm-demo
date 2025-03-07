## CRUD练习项目

### TODO

1、技术栈:SpringBoot + Spring + SpringMVc + MyBatis

2、要求:

1. 员工表 CRUD
2. 基本CRUD +分页查询sxxxxx
3. RESTfUL风格
4. 数据校验
5. 全局统一异常处理(业务异常、校验异常)
6. 引入vo分层模型
7. 引入swagger文档
8. 解诀跨越
9. 写完以后在接口文档中测试





### 思路

1. 设计bean和vo字段
  - 留意：不同方法必填字段不一样
2. 设计数据库以及mapper的编写
3. 测试mapper
4. 编写service
5. 注意写业务状态码，以及日志
6. 写全局异常处理器
7. 测试service
8. 加上controller
9. 加上字段校验以及异常处理器
10. 加上swagger