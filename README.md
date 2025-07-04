# DDD 技术学习教程

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7+-green.svg)](https://spring.io/projects/spring-boot)
[![MyBatis](https://img.shields.io/badge/MyBatis-3.5+-blue.svg)](https://mybatis.org/)
[![Dubbo](https://img.shields.io/badge/Dubbo-3.2+-red.svg)](https://dubbo.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📖 项目简介

这是一个基于 **DDD（领域驱动设计）** 架构的Java技术学习项目，旨在通过实际案例学习和掌握现代Java企业级开发技术栈。项目采用模块化设计，涵盖了MyBatis数据持久化、Dubbo分布式服务、Jenkins自动化部署等核心技术。

**作者**: 仙人球⁶ᴳ | 微信：Cactusesli
**GitHub**: https://github.com/lixuanfengs
**技术博客**: https://cactusli.net

有关学习的教程文档请访问：[DDD 技术体系](https://cactusli.net/tutorial/DDD%20%E6%8A%80%E6%9C%AF%E4%BD%93%E7%B3%BB/DDD%20%E6%8A%80%E6%9C%AF%E4%BD%93%E7%B3%BB%E2%80%94%20%E7%90%86%E8%AE%BA.html)

## 🏗️ 项目架构

```
lxf-dev-tech/
├── lxf-dev-tech-mybatis/          # MyBatis 学习模块
│   ├── lxf-dev-tech-app/          # 应用层
│   ├── lxf-dev-tech-domain/       # 领域层
│   └── lxf-dev-tech-infrastructure/ # 基础设施层
├── lxf-dev-tech-dubbo/            # Dubbo 分布式服务模块
│   ├── lxf-dev-tech-dubbo-api/    # API 接口定义
│   ├── lxf-dev-tech-dubbo-app/    # 服务提供者
│   └── lxf-dev-tech-dubbo-trigger/ # 触发器层
├── lxf-dev-tech-dubbo-test/       # Dubbo 服务消费者测试
├── lxf-dev-tech-jenkins/          # Jenkins 部署测试模块
└── data/                          # 数据文件目录
```

## 🚀 技术栈

### 核心框架
- **Spring Boot 2.7+** - 应用框架
- **Spring Framework** - IoC容器和AOP
- **MyBatis 3.5+** - 数据持久化框架
- **Apache Dubbo 3.2+** - 分布式服务框架

### 数据库
- **MySQL 8.0+** - 关系型数据库
- **HikariCP** - 数据库连接池

### 工具库
- **Lombok** - 简化Java代码
- **FastJSON 2.0** - JSON处理
- **Apache Commons Lang3** - 工具类库

### 开发工具
- **Maven** - 项目构建管理
- **Docker** - 容器化部署
- **Jenkins** - 持续集成/持续部署

## 📋 模块详解

### 1. MyBatis 学习模块 (lxf-dev-tech-mybatis)

基于DDD架构设计的员工管理系统，展示MyBatis在企业级应用中的最佳实践。

**功能特性**：
- 员工信息管理（增删改查）
- 薪资调整流程
- 事务管理
- 多数据源配置

**架构分层**：
- **应用层 (app)**: 启动类和配置
- **领域层 (domain)**: 业务逻辑和领域模型
- **基础设施层 (infrastructure)**: 数据访问和外部服务

**核心类**：
- `EmployeeInfoEntity` - 员工信息实体
- `AdjustSalaryApplyOrderAggregate` - 调薪申请聚合根
- `EmployeeService` - 员工领域服务
- `SalaryAdjustApplyService` - 薪资调整服务

### 2. Dubbo 分布式服务模块 (lxf-dev-tech-dubbo)

演示Dubbo框架的服务提供者和消费者模式，包含自定义RPC实现。

**功能特性**：
- Dubbo服务提供者
- 服务注册与发现（Zookeeper）
- 直连模式和注册中心模式
- 自定义RPC代理实现

**核心接口**：
- `IUserService` - 用户服务接口
- `UserReqDTO/UserResDTO` - 请求响应数据传输对象
- `Response<T>` - 统一响应格式

### 3. Jenkins 部署测试模块 (lxf-dev-tech-jenkins)

简单的Web应用，用于测试Jenkins自动化部署流程。

**功能特性**：
- RESTful API接口
- Server-Sent Events (SSE) 实时推送
- 多环境配置支持

## 🛠️ 环境搭建

### 前置要求
- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Docker & Docker Compose (可选)
- Zookeeper (Dubbo模块需要)

### 1. 克隆项目
```bash
git clone https://github.com/lixuanfengs/lxf-dev-tech.git
cd lxf-dev-tech
```

### 2. 数据库初始化

#### 使用Docker Compose (推荐)
```bash
cd lxf-dev-tech-mybatis/docs/dev-ops
docker-compose up -d
```

#### 手动安装MySQL
1. 创建数据库：`mybatis-sql`
2. 执行SQL脚本：`lxf-dev-tech-mybatis/docs/dev-ops/sql/mybatis-sql.sql`

### 3. 配置文件修改

修改 `lxf-dev-tech-mybatis/lxf-dev-tech-app/src/main/resources/application-dev.yml`：
```yaml
spring:
  datasource:
    username: root
    password: your_password
    url: jdbc:mysql://localhost:3306/mybatis-sql?useUnicode=true&characterEncoding=utf8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useSSL=true
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## 🏃‍♂️ 快速开始

### 运行 MyBatis 模块
```bash
cd lxf-dev-tech-mybatis
mvn clean install
cd lxf-dev-tech-app
mvn spring-boot:run
```
访问：http://localhost:8090

### 运行 Dubbo 服务提供者
```bash
cd lxf-dev-tech-dubbo/lxf-dev-tech-dubbo-app
mvn spring-boot:run
```

### 运行 Dubbo 服务消费者测试
```bash
cd lxf-dev-tech-dubbo-test
mvn test
```

### 运行 Jenkins 测试模块
```bash
cd lxf-dev-tech-jenkins/lxf-dev-tech-jenkins-app
mvn spring-boot:run
```
访问：http://localhost:8091/api/test

## 🧪 测试用例

### MyBatis 模块测试
```bash
cd lxf-dev-tech-mybatis
mvn test
```

主要测试类：
- `IEmployeeServiceTest` - 员工服务测试
- `ISalaryAdjustApplyServiceTest` - 薪资调整测试
- `IEmployeeDAOTest` - 数据访问层测试

### Dubbo 模块测试
```bash
cd lxf-dev-tech-dubbo-test
mvn test
```

测试类：
- `ApiTest` - Dubbo服务调用测试

## 📚 API 文档

### MyBatis 模块 API

#### 员工信息查询
- **接口**: `EmployeeService.queryEmployInfo(String employNumber)`
- **参数**: employNumber - 员工编号
- **返回**: EmployeeInfoEntity - 员工信息实体

#### 薪资调整申请
- **接口**: `SalaryAdjustApplyService.execSalaryAdjust(AdjustSalaryApplyOrderAggregate aggregate)`
- **参数**: aggregate - 调薪申请聚合对象
- **返回**: String - 调薪单号

### Dubbo 模块 API

#### 用户信息查询
- **接口**: `IUserService.queryUserInfo(UserReqDTO reqDTO)`
- **参数**: UserReqDTO - 用户请求对象
- **返回**: Response<UserResDTO> - 统一响应格式

### Jenkins 模块 API

#### 部署测试接口
- **URL**: `GET /api/test`
- **响应**: Server-Sent Events 流式数据
- **Content-Type**: text/event-stream

## 🔧 配置说明

### 数据库配置
支持多环境配置：
- `application-dev.yml` - 开发环境
- `application-test.yml` - 测试环境
- `application-prod.yml` - 生产环境

### Dubbo 配置
- 支持直连模式和注册中心模式
- 默认使用Zookeeper作为注册中心
- 端口配置：20881

### 日志配置
使用Logback作为日志框架，配置文件：`logback-spring.xml`

## 🤝 贡献指南

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 📞 联系方式

- **作者**: 仙人球⁶ᴳ
- **微信**: Cactusesli
- **GitHub**: [@lixuanfengs](https://github.com/lixuanfengs)
- **技术博客**: [https://cactusli.net](https://cactusli.net)

## 🙏 致谢

感谢所有为这个项目做出贡献的开发者们！

---

⭐ 如果这个项目对你有帮助，请给个Star支持一下！