tsx-import
简介：汇入功能

1. 2015-06-04(周四)，构建tsx-import工程. 主要用于原始数据汇入
2. 2015-06-05(周五)，HiveOnSpark测试通过，此前未通过的原因是，pom中引用了apache-hive的jar，去掉问题则顺利解决。
java.lang.NoSuchMethodError: com.google.common.hash.HashFunction.hashInt(I)Lcom/google/common/hash/HashCode;
解决办法：pom中存在多个guava的引用，删除较低版本即可

