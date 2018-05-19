# TaxiHepler
打车比价项目（第六届重庆市雏鹰计划项目 ），Android客户端。

## 1.概要

### 1.1 项目介绍

本项目以在线打车网络平台繁多，但价格参差不齐为背景。旨在开发出能够比较各在线平台价格的App，提供更实惠经济的价格给用户。

- 项目背景：在线打车价格不一
- 针对对象：使用在线打车平台的所有用户
- 项目目的：给用户提供更经济实惠的打车方式
- 项目组成：Android客户端
- 职责担任：本项目中担任Android开方成员

### 1.2 客户端功能介绍

1. 登陆注册
2. 实时定位
3. 查询附近车辆信息
4. 选择上下车地点
   1. 拖动地图层界面进行选择
   2. 文字输入方式选择
5. 各平台价格比对
6. 模拟钱包充值
7. 历史订单查看
8. 约车结束评价

## 2. 功能展示

### 登陆

​    <img src="https://github.com/zzbb1199/Medical-aid/blob/master/pic/%E4%B8%BB%E7%95%8C%E9%9D%A2.jpg" title="主界面" width="250px" alt="主界面">  <img src="https://github.com/zzbb1199/Medical-aid/blob/master/pic/%E7%97%85%E4%BA%BA%E9%98%9F%E5%88%97.jpg" title="病人队列"  width="250px" alt="病人队列"><img src="https://github.com/zzbb1199/Medical-aid/blob/master/pic/%E5%BC%80%E8%8D%AF%E4%B8%AD%E5%BF%83.jpg" title="开药中心"  width="250px" alt="开药中心">

### 个人中心&药材百科&药材保质

​    <img src="https://github.com/zzbb1199/Medical-aid/blob/master/pic/%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83.jpg" title="个人中心"  width="250px" alt="个人中心">  <img src="https://github.com/zzbb1199/Medical-aid/blob/master/pic/%E8%8D%AF%E6%9D%90%E7%99%BE%E7%A7%91.jpg" title="药材百科"  width="250px" alt="药材百科">  <img src="https://github.com/zzbb1199/Medical-aid/blob/master/pic/%E8%8D%AF%E6%9D%90%E4%BF%9D%E8%B4%A8%E6%9F%A5%E8%AF%A2.jpg" title="药材保质"  width="250px" alt="药材保质">




## 3 开发环境及技术支持

### 3.1  开发环境及运行平台

#### 3.1.1 开发环境

- Android Studio 2.3.3 
- JDK 1.8,java语言开发

#### 3.1.2 运行环境

- Android平台系列手机
- minSDK>=18

### 3.2 技术支持

1. 界面设计
   - 遵从Google Material Design设计。
2. 网络数据交互
   - OkHttp3：网络请求的优秀开源框架
   - Retrofit2+RxJava：简化网络请求API与主子线程调度
3. 本地数据存储
   - SharedPreference：Android 自带简单本地存储API。
   - GreenDao：轻量高效数据库。
4. 代码解耦
   - MVP设计模式：业务分为3个层次，M-Model，V-View，P-presnter，通过p进行中转达到解耦。
   - Dagger2：依赖注入框架，较少模块之间的依赖，

## 4 最后

**本项目为实验项目，所有功能并未上线，无法做到真正网约车，最终结果仅供参考。**