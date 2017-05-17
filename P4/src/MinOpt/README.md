# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes MinOpt*
/usr/java/jdk1.7.0_51/bin/jar -cvf MinOpt.jar -C java_classes / .
hadoop jar MinOpt.jar oldapi.MinOpt /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./MinOpt/output/
hdfs dfs -cat MinOpt/output/*
```

# Resultado

```
Min -11.0
```
