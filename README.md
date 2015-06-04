tsx项目（t2t-spark-x）
简介：待定
项目采用maven管理

1. 2015-06-04(周四)，构建tsx-parent工程.

set http_proxy=http://192.168.72.144:3128

其他说明：
Eclipse:
mvn eclipse:clean eclipse:eclipse -DdownloadSources 
MyEclipse:
mvn eclipse:myeclipse-clean eclipse:myeclipse -DdownloadSources
编译打包：
mvn clean package -DskipTests

打包时，加入如下配置即可解决配置文件未部署过去的问题
<resources>
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/*.*</include>
        </includes>
        <filtering>false</filtering>
    </resource>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.*</include>
        </includes>
        <filtering>false</filtering>
    </resource>
</resources>