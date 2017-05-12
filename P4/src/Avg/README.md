# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes Avg*
/usr/java/jdk1.7.0_51/bin/jar -cvf Avg.jar -C java_classes / .
hadoop jar Avg.jar oldapi.Avg /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./Avg/output/
hdfs dfs -cat Avg/output/*
```

# Resultado

```
Avg -1.282261707288373
```

