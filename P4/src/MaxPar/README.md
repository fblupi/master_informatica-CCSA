# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes MaxPar*
/usr/java/jdk1.7.0_51/bin/jar -cvf MaxPar.jar -C java_classes / .
hadoop jar MaxPar.jar oldapi.MaxPar /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./MaxPar/output/ <col>
hdfs dfs -cat MaxPar/output/*
```

# Resultado

```
6   9.0
```
