# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes MaxMinAll*
/usr/java/jdk1.7.0_51/bin/jar -cvf MaxMinAll.jar -C java_classes / .
hadoop jar MaxMinAll.jar oldapi.MaxMinAll /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./MaxMinAll/output/
hdfs dfs -cat MaxMinAll/output/*
```

# Resultado

```
Max (1) 0.154
Min (1) 0.0
Max (2) 10.0
Min (2) -12.0
Max (3) 8.0
Min (3) -11.0
Max (4) 9.0
Min (4) -12.0
Max (5) 9.0
Min (5) -11.0
Max (6) 9.0
Min (6) -13.0
Max (7) 9.0
Min (7) -12.0
Max (8) 7.0
Min (8) -12.0
Max (9) 10.0
Min (9) -13.0
Max (0) 0.768
Min (0) 0.094
```
