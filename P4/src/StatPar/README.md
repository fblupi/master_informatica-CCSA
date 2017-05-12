# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes StatPar*
/usr/java/jdk1.7.0_51/bin/jar -cvf StatPar.jar -C java_classes / .
hadoop jar StatPar.jar oldapi.StatPar /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./StatPar/output/ <col>
hdfs dfs -cat StatPar/output/*
```

# Resultado

```
Max (6) 9.0
Min (6) -13.0
Avg (6) -2.293434905140485
```
