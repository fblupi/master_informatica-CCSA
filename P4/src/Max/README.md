# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes Max*
/usr/java/jdk1.7.0_51/bin/jar -cvf Max.jar -C java_classes / .
hadoop jar Max.jar oldapi.Max /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./Max/output/
hdfs dfs -cat Max/output/*
```

# Resultado

```
Max 9.0
```

