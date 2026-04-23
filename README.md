# cloud-demo 微服务学习项目

## 项目简介
这是一个用于学习 Spring Cloud 和 Spring Cloud Alibaba 的微服务示例项目。项目采用 Maven 多模块结构，包含基础数据模型模块和两个示例服务：`service-product` 与 `service-order`。

## 目录结构
- `cloud-demo/pom.xml`：父工程 POM，管理 Spring Boot、Spring Cloud、Spring Cloud Alibaba 版本及公共配置。
- `cloud-demo/model`：公共模型模块，定义共享数据结构和实体类。
- `cloud-demo/services`：服务聚合模块，统一声明子服务依赖。
  - `service-product`：商品服务示例模块。
  - `service-order`：订单服务示例模块。

## 学习进度
- [x] 理解 Spring Boot 父工程与多模块 Maven 项目结构
- [x] 熟悉 `pom.xml` 中 `dependencyManagement`、`pluginManagement` 的作用
- [x] 学会使用 Spring Cloud Alibaba 的 Nacos Config、OpenFeign、Sentinel 依赖
- [x] 掌握模块间依赖（`services` 模块依赖 `model` 模块）的配置方式
- [ ] 深入理解服务间调用与负载均衡策略
- [ ] 学习 Nacos 配置中心与注册发现的实际使用
- [ ] 完善微服务异常处理、容错和熔断机制
- [ ] 添加更多服务模块，练习微服务拆分与通信

## 当前项目重点
- JDK 17 开发环境
- Spring Boot 3.3.4 + Spring Cloud 2023.0.3
- Spring Cloud Alibaba 2023.0.3.2
- `services` 聚合模块统一管理公共依赖和编译配置
- 子模块中复用 `model` 模块提供共享实体类

## 运行与构建
1. 进入项目根目录 `cloud-demo`。
2. 使用 Maven 构建：
   ```bash
   mvn clean install
   ```
3. 启动子模块服务：
   - `service-product`
   - `service-order`

## 个人学习总结
这个 demo 帮助我理解了微服务项目的基本组织方式，特别是多模块 Maven 架构和 Spring Cloud Alibaba 中的核心依赖管理。下一步计划是结合 Nacos 服务发现、配置中心、以及 Feign 调用链路来搭建更完整的微服务实战场景。
