# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes MaxMin*
/usr/java/jdk1.7.0_51/bin/jar -cvf MaxMin.jar -C java_classes / .
hadoop jar MaxMin.jar oldapi.MaxMin /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./MaxMin/output/
hdfs dfs -cat MaxMin/output/*
```

# Resultado

```
Max 9.0
Min -11.0
```

