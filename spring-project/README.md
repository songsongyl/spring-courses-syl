# 毕业答辩项目
## Outline ：学生上传毕设相关文件 由导师进行评分

### **<font color="#FF8C00">Process</font>**
## 一.构建数据库
<font color="#E9967A">Update  : 2024.9.21 </font>

1. 利用反范式 非关系型 经过分析设计利用json cast等技术 大大减少了表的数量 提升效率 得出数据表大概框架  

<font color="#E9967A">Update  : 2024.9.22 </font>  

2. 仔细复查进行查缺补漏  建立索引
## 二.安装虚拟机 用主机端口映射虚拟机端口 实现隔离
<font color="#E9967A">Update  : 2024.9.22 </font>  

1. 安装centos和vbox 在虚拟机安装docker 学习docker基本命令和linus命令  

<font color="#E9967A">Update  : 2024.9.24 </font>
2. 安装ssh实现虚拟机和主机进行互通 利用docker-compose安装mysql，在ideal连接虚拟机数据库  
在mysql目录下创建compose脚本，拉取mysql镜像，cd进入mysql目录，docker exec -it 容器名 bash 进入bash命令行 运行mysql -uroot -p 

<font color="#E9967A">Update  : 2024.9.28 </font>  

3. 安装tomcat 在ideal新建web项目 测试

<font color="#E9967A">Update  : 2024.10.5 </font>
4. 集成tomcat和mysql和nginx


