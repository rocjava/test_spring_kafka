安装JAVA JDK
安装ZooKeeper
http://zookeeper.apache.org/releases.html#download
将conf/zoo_sample.cfg重命名为zoo.cfg
打开zoo.cfg找到并编辑dataDir=D:\penn\dev\zk_data
添加系统变量：ZOOKEEPER_HOME=D:\penn\dev\zookeeper-3.4.12
编辑path系统变量，添加路径：%ZOOKEEPER_HOME%\bin
在zoo.cfg文件中修改默认的Zookeeper端口（默认端口2181）
打开新的cmd，输入zkServer，运行Zookeeper


安装kafka
http://kafka.apache.org/downloads
注意要下载二进制版本
进入config目录找到文件server.properties并打开
找到并编辑log.dirs=D:\penn\dev\kafka_log
找到并编辑zookeeper.connect=localhost:2181
Kafka会按照默认，在9092端口上运行，并连接zookeeper的默认端口：2181
进入Kafka安装目录D:\penn\dev\kafka_2.12-2.1.0
打开cmd，输入下面命令，启动kafka服务
.\bin\windows\kafka-server-start.bat .\config\server.properties

如果提示找不到java
编辑kafka_2.12-1.0.0\bin\windows\kafka-run-class.bat
将
set COMMAND=%JAVA% %KAFKA_HEAP_OPTS% %KAFKA_JVM_PERFORMANCE_OPTS% %KAFKA_JMX_OPTS% %KAFKA_LOG4J_OPTS% -cp %CLASSPATH% %KAFKA_OPTS% %
改为：
set COMMAND=%JAVA% %KAFKA_HEAP_OPTS% %KAFKA_JVM_PERFORMANCE_OPTS% %KAFKA_JMX_OPTS% %KAFKA_LOG4J_OPTS% -cp "%CLASSPATH%" %KAFKA_OPTS% %
%CLASSPATH%外围包一层双引号
