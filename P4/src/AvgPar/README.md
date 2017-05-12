# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes AvgPar*
/usr/java/jdk1.7.0_51/bin/jar -cvf AvgPar.jar -C java_classes / .
hadoop jar AvgPar.jar oldapi.AvgPar /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./AvgPar/output/ <col>
hdfs dfs -cat AvgPar/output/*
```

# Resultado

```
6   -2.293434905140485
```
