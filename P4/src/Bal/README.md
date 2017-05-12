# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes Bal*
/usr/java/jdk1.7.0_51/bin/jar -cvf Bal.jar -C java_classes / .
hadoop jar Bal.jar oldapi.Bal /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./Bal/output/
hdfs dfs -cat Bal/output/*
```

# Resultado

```
Bal 58.582560602010815
```
