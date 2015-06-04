wmvn archetype:create -DgroupId=com.dmis.top -DartifactId=top-scala
mvn clean install
mvn eclipse:myeclipse-clean eclipse:myeclipse -DdownloadSources=true -DdownloadJavadocs=true

mvn clean idea:idea

<!-- scala -->
<dependency>
	<groupId>org.scala-lang</groupId>
	<artifactId>scala-library</artifactId>
	<version>2.11.2</version>
</dependency>
<dependency>
	<groupId>org.scala-lang</groupId>
	<artifactId>scala-actors</artifactId>
	<version>2.11.2</version>
</dependency>
<dependency>
	<groupId>org.scala-lang</groupId>
	<artifactId>scala-reflect</artifactId>
	<version>2.11.2</version>
</dependency>
<!-- scala # -->

java -jar ./top-spark-1.0.0-SNAPSHOT.jar ./top-spark-1.0.0-SNAPSHOT.jar hdfs://192.168.72.21:9000/spark/input/mytimes.txt hdfs://192.168.72.21:9000/spark/result/1

val textFile = sc.textFile("hdfs://192.168.72.21:9000/spark/input/mytimes.txt")
textFile.count()
val linesWithSpark = textFile.filter(line => line.contains("244"))
linesWithSpark.collect()
linesWithSpark.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)
val v = linesWithSpark.flatMap(_.split(' ')).map((_,1)).reduceByKey(_+_).map(x => (x._2,x._1)).sortByKey(false).map(x => (x._2,x._1))
v.saveAsTextFile("/root/dir2")


java -cp ./top-spark-1.0.0-SNAPSHOT.jar com.topsec.tss.spark.HelloScala
java -cp ./top-spark-1.0.0-SNAPSHOT.jar com.topsec.tss.spark.TextFileTest

java -cp ./top-spark-1.0.0-SNAPSHOT.jar com.topsec.tss.sql.LoggerAgTextFileTestentServer 10110 3000
java -cp ./top-spark-1.0.0-SNAPSHOT.jar com.topsec.tss.sql.NetworkWordCount spark://n21.com:7077 n21.com 10110 10
java -cp ./top-spark-1.0.0-SNAPSHOT.jar com.topsec.tss.sql.HdfsWordCount spark://n21.com:7077 hdfs://n21.com:9000/spark/input/A 10110 10

bin/spark-shell --master spark://n21.com:7077 --executor-memory 2m
v.saveAsTextFile("hdfs://192.168.72.21:9000/spark/input/2")

Eclipse:
mvn eclipse:clean eclipse:eclipse -DdownloadSources
MyEclipse:
mvn eclipse:myeclipse-clean eclipse:myeclipse -DdownloadSources
idea:
mvn idea:idea

java -cp ./top-spark-1.0.0-SNAPSHOT.jar com.topsec.tss.dataguru.sql.SQLOnSpark
spark-submit --master spark://n21:7077 --executor-memory 1g --class com.topsec.tss.dataguru.sql.SQLOnSpark top-spark-1.0.0-SNAPSHOT.jar
spark-submit --master spark://n21:7077 --executor-memory 1g --class com.topsec.tss.dataguru.sql.SQLOnSparkEvent top-spark-1.0.0-SNAPSHOT.jar

2015.03.12(周四) 示例(HBaseDataExportSimple.scala)，将Hbase上的数据通过Spark保存到HDFS的PATH上.
2015.03.12(周四) 示例(SqlDomain.scala)，将HDFS上的文件以表的形式注册到spark内存中，然后把查询结果保存到HDFS的PATH上.

spark-submit --master spark://master.node:7077 --executor-memory 10g --class com.topsec.tss.libs.HBaseSimple top-spark-1.0.0-SNAPSHOT.jar
