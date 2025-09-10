# YOYO商城 - 后台管理系统

[![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=openjdk)](https://www.java.com/)
[![SpringBoot](https://img.shields.io/badge/Spring%20Boot-2.7.18-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Vue](https://img.shields.io/badge/Vue-3.3.4-%234FC08D?logo=vue.js)](https://vuejs.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql)](https://www.mysql.com/)
[![Redis](https://img.shields.io/badge/Redis-6.0-%23DC382D?logo=redis)](https://redis.io/)

**YOYO商城**是一个基于前后端分离架构开发的B2C电商平台实战项目。项目后端采用SpringBoot构建RESTful API，前端使用Vue3+Element-Plus构建用户界面，实现了完整的电商业务流程，包括商品管理、用户认证、购物车、订单流程及支付模拟等核心功能。

## ✨ 功能特性

- **🛒 核心电商功能**: 商品浏览与搜索、购物车管理、订单生成与状态流转、模拟支付。
- **🔐 安全认证**: 基于JWT的无状态用户认证与授权，保障接口安全。
- **⚡ 性能优化**: 集成Redis实现多级缓存（商品缓存、会话缓存），显著提升系统响应速度与并发能力。
- **🛡️ 高并发处理**: 采用Redisson分布式锁解决高并发场景下的库存超卖问题。
- **🐳 容器化部署**: 项目全程使用Docker容器化环境，并通过Docker Compose一键编排部署，简化运维。

## 🛠 技术栈

### 后端
- **核心框架**: Java 17 + Spring Boot 2.7.18
- **数据持久层**: MyBatis-Plus 3.5.5
- **数据库**: MySQL 8.0
- **缓存与分布式锁**: Redis 6.0 + Redisson 3.21.0
- **安全认证**: JWT (Java JWT)
- **API文档**: Knife4j (Swagger增强)
- **项目构建**: Maven 3.8+
- **容器化**: Docker, Docker Compose

### 前端
- **框架**: Vue 3.3.4 + Composition API
- **UI组件库**: Element-Plus 2.3.14
- **路由**: Vue Router 4.2.5
- **状态管理**: Pinia 2.1.7
- **HTTP客户端**: Axios 1.5.1
- **构建工具**: Vite 4.4.11

## 🗂 项目结构

```
yoyo-shop/
├── yoyo-backend/                 # SpringBoot后端项目
│   ├── src/main/java/com/yoyo/
│   │   ├── common/               # 通用模块（工具类、常量、异常处理）
│   │   ├── config/               # 配置类（Redis、MyBatis-Plus、Swagger等）
│   │   ├── controller/           # 控制层（API接口）
│   │   ├── entity/               # 实体类（与数据库表映射）
│   │   ├── mapper/               # 数据访问层（MyBatis Mapper接口）
│   │   ├── service/              # 服务层（业务逻辑接口与实现）
│   │   └── YoyoApplication.java  # 项目启动类
│   ├── src/main/resources/
│   │   ├── application.yml       # 主配置文件
│   │   └── mapper/               # MyBatis XML映射文件
│   └── pom.xml                   # Maven依赖配置
│
├── yoyo-frontend/                # Vue3前端项目
│   ├── public/
│   ├── src/
│   │   ├── api/                  # 前端API请求封装（Axios）
│   │   ├── components/           # 可复用Vue组件
│   │   ├── router/               # 路由配置
│   │   ├── stores/               # Pinia状态管理
│   │   ├── views/                # 页面组件
│   │   └── main.js               # 项目入口
│   ├── index.html
│   ├── package.json
│   └── vite.config.js
│
├── docker-compose.yml            # Docker Compose编排文件
├── sql/                          # 数据库初始化脚本
└── README.md
```

## 🚀 快速开始

###  prerequisites

- JDK 17+
- Maven 3.8+
- Node.js 16+ & npm
- Docker 20.10+ & Docker Compose 2.0+

### 1. 克隆项目

```bash
git clone https://github.com/12yhy3/Yoyo-shop
```

### 2. 后端服务启动

**方式一: 使用Docker Compose（推荐）**
此方式会自动启动后端服务、MySQL和Redis。

```bash
# 进入项目根目录
docker-compose up -d
```
后端API服务将在 `http://localhost:8080` 启动。
API文档（Knife4j）: `http://localhost:8080/doc.html`

**方式二: 本地开发运行**
```bash
# 导入位于 `sql/` 目录下的SQL文件至您的MySQL数据库
# 修改 `yoyo-backend/src/main/resources/application.yml` 中的数据库和Redis连接配置

cd yoyo-backend
mvn clean install
mvn spring-boot:run
```

### 3. 前端服务启动

```bash
cd yoyo-frontend
npm install         # 安装依赖
npm run dev         # 启动开发服务器
```
前端应用将在 `http://localhost:5173` 启动。

### 4. 访问系统

- **前台页面**: http://localhost:5173
- **后台管理**: http://localhost:5173/admin (根据您的实现而定)
- **后端API文档**: http://localhost:8080/doc.html

**默认测试账户**:
- 用户名: `admin`
- 密码: `123456` (或您自定义的密码)

## 📝 核心模块设计亮点

### 1. 缓存设计
- **商品详情缓存**: 使用Redis String结构缓存`product:{id}`，有效降低数据库压力。
- **购物车缓存**: 使用Redis Hash结构存储`cart:{userId}`，支持高效的增删改查。

### 2. 防超卖方案
下单扣减库存时，使用Redisson分布式锁（`RLock`）保证库存校验和扣减的原子性，有效应对秒杀等高并发场景。

### 3. 无状态登录
基于JWT生成Token，客户端每次请求携带，服务端无需存储Session，易于水平扩展。

## 🧪 测试

- **后端单元测试**: 在`yoyo-backend`目录下运行 `mvn test`
- **压力测试**: 使用JMeter等工具对`/api/order/create`接口进行高并发测试，验证分布式锁有效性。

## 📈 部署

生产环境部署建议：
1. 使用 `mvn package -DskipTests` 打包后端Jar文件。
2. 使用 `npm run build` 构建前端静态资源。
3. 通过修改`docker-compose.prod.yml`（需自行创建）编排Nginx、后端服务、MySQL和Redis，进行一体化部署。

## 🤝 贡献

欢迎提交 Issue 和 Pull Request来改善这个项目。

## 📄 许可证

该项目基于 MIT 许可证开源。详见 [LICENSE](LICENSE) 文件。

---

**如果这个项目对您有帮助，请给它一个⭐️Star！**
