# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes Min*
/usr/java/jdk1.7.0_51/bin/jar -cvf Min.jar -C java_classes / .
hadoop jar Min.jar oldapi.Min /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./Min/output/
hdfs dfs -cat Min/output/*
```

# Resultado

```
Min -11.0
```
