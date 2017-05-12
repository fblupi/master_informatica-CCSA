# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes MinPar*
/usr/java/jdk1.7.0_51/bin/jar -cvf MinPar.jar -C java_classes / .
hadoop jar MinPar.jar oldapi.MinPar /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./MinPar/output/ <col>
hdfs dfs -cat MinPar/output/*
```

# Resultado

```
6   -13.0
```
