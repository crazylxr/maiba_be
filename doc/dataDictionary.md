建表规则采取 阿里巴巴 mysql 数据库设计规范
- 必备：id、create_time、modify_time
- 主键索引名为pk_字段名
- 表达是与否概念的字段，必须使用is_xxx的方式命名
- 表名、字段名必须使用小写字母或数字，禁止出现数字开头，禁止两个下划线中间只出现数字

## 商品微服务
### 用户（goods_user）

字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | long |  | not | 
username | varchar | | not |
password | varchar | |not |
nickname | varchar | | |昵称
name | varchar | | | 真实姓名
birthday | date ||| 生日
gender | tinyint || |性别
tel | char(11) ||| 手机号码
user_type | tinyint ||| 用户类型：1：一般用户 0 管理员
state | tinyint | 0 |  | 状态：1：启用 0：禁用
default_delivery_id | char ||| 默认收货 id
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 收货地址（goods_address）

字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char |  | not | 
user_id | char || | 用户 id
tel | char ||  | 电话号码
address | char ||  |  收货地址
name | char ||| 收货人名字
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 资源（goods_resourece）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
path | varchar || not | 存储路径
name | varchar |||文件名
type | varchar ||| 文件类型
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 分类（goods_classification）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not |
name | varchar || | 分类名称
parent_id | cahr ||| 父级分类 id，null 为顶级
leavel | int  ||| 级数
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间


### 商品（goods_goods）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
goods_id | char || not | 商品 id，特殊规则
classification_id | char | | | 分类 id
name | varchar ||| 商品名称
description | varchar ||| 简介
inventory | int ||| 库存
price | decimal ||| 原价
discount_price | decimal ||| 折后价
discount | decimal | 10 | | 折扣
volume | int ||| 成交量
is_shelf | tinyint ||| 是否上架 1：上架 0：没上架
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 商品图片表（goods_goodsImage）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
goods_id | char ||| 商品 id
resources_id | char ||| 资源 id
type | tinyint ||| 主图还是局部图 1: 主图 0：局部图
order | int ||| 图的顺序号
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 评价（goods_comment）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
user_id | char ||| 用户id
content | char ||| 文字内容
star | int || | 星级
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 评价图片表（goods_commentImage）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
comment_id | char ||| 评价 id
resources_id | char ||| 资源 id
order | int ||| 图的顺序号
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

## 订单服务
### 订单表（order_order）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
order_id | char ||| 订单 id，特殊规则
user_id | char ||| 用户 id
tatal_price | decimal || |订单总价
address_id | char ||| 收货 id
remark | varchar ||| 备注
state | int || |订单状态：0. 待付款 1.已付款 2.已发货 3.已收货 4.取消订单
delivery_start_time | datetime ||| 发货时间
payment_time | datetime | || 付款时间
delivery_end_time | datetime | | |收货时间
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 订单详情（order_orderItem）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
order_id | char ||| 订单 id
goods_id | char ||| 商品 id
price | double ||| 商品单价
number | int ||| 购买数量
total_price | decimal ||| 该种商品总价
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 购物车（order_shoppingCart）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
user_id | char ||| 用户 id
goods_id | char || | 商品id
number | int ||| 数量
is_pay | tinyint ||| 是否付款 1：付款 0：未付款
total_price | decimal || | 该商品总价
is_delete | tinyint ||| 是否删除
delete_time | datetime | || 删除时间
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

## 推荐微服务
### 商品打点（recommend_goodsClick）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
user_id | char ||| 用户 id
goods_id | char ||| 商品 id
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 分类打点（recommend_classificationClick）
字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
user_id | char ||| 用户 id
goods_id | char ||| 分类 id
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 购买分类商品（recommend_buyClassificationGoods）--考虑是否直接放到 分类表
解释：改表用来统计没个分类所有用户买的商品个数，然后可以在用户首次进来的时候推荐买的种类较多的商品

字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
goods_id | char ||| 分类 id
number | int ||| 该分类购买数量。
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间

### 用户可能喜欢的类型（recommend_userLikeClassfication）
解释：存储给每个用户推荐哪种类型的商品分别多少件。

字段名 | 数据类型 | 默认值 | 运行非空 | 备注
---|---|---|---|---
pk_id | char || not | 
user_id | char ||| 用户 id
goods_id | char ||| 分类 id
name | varchar ||| 分类名
num | int ||| 推荐的数量
create_time | datetime  | || 创建此条数据的时间
modify_time | datetime ||| 修改此条数据的时间
