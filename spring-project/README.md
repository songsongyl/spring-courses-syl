# 毕业答辩项目
## 一.构建数据库 
### 1.2024.9.21 经过分析设计利用json cast得出数据表大概框架
### 2.2024.9.21 查看老师代码进行查缺补漏 
## 二.安装虚拟机 用主机13306端口映射虚拟机3306端口，实现隔离
### 2024.9.22安装虚拟机和docker 不断出错纠错 配置网络和端口映射
####  1、下载安装virtual box
CentOS-7-x86_64-DVD-2207-02.iso
https://mirrors.aliyun.com/centos/7.9.2009/isos/x86_64/
#### 2.安装虚拟机
https://blog.csdn.net/qq_43726042/article/details/105913613
#### 3.在linux中安装docker
https://docs.docker.com/engine/install/centos/
#### 4.sudo yum install -y yum-utils 报错问题
https://blog.csdn.net/weixin_43490087/article/details/141924032 4步检查 yum源换成国内镜像源
https://blog.csdn.net/superiony/article/details/140505523 修改仓库
https://blog.csdn.net/jingling555/article/details/140361046?ops_request_misc=%257B%2522request%255Fid%2522%253A%25220D2EEF54-39C8-4EEC-803F-E05008D7C36B%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=0D2EEF54-39C8-4EEC-803F-E05008D7C36B&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-1-140361046-null-null.nonecase&utm_term=docker&spm=1018.2226.3001.4450
#### 5.获取密钥失败问题
重新更换镜像
#### 6、hello world运行失败或超时
配置阿里云镜像加速器失败
https://blog.csdn.net/quanqxj/article/details/79479943/ 添加可用ip(不知道是否有用）
https://www.cnblogs.com/paul-liang/p/18384633 配置加速地址
#### 7. Could not resolve host: github.com解决方法
https://blog.csdn.net/lxcw_sir/article/details/135958573
#### 8. 主机与虚拟机互通 端口映射
https://www.cnblogs.com/albelt/p/17020773.html
#### 9.vbox生成备份
https://www.jianshu.com/p/ba27c0fd2edf
#### 10.2024.9.25实现虚拟机和主机进行互通 利用docker-compose安装mysql，在ideal连接虚拟机数据库等
在mysql目录下创建compose脚本，拉取mysql镜像，cd进入mysql目录，docker exec -it 容器名 bash 进入bash命令行 运行mysql -uroot -p 如何输入密码进入mysql 可以完成在ideal建表在这里查看。
flush privileges;
alter user 'root'@'localhost' identified by '新密码';exit退出
#### 11.2024.9.28 安装tomcat


