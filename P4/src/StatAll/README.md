# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes StatAll*
/usr/java/jdk1.7.0_51/bin/jar -cvf StatAll.jar -C java_classes / .
hadoop jar StatAll.jar oldapi.StatAll /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./StatAll/output/
hdfs dfs -cat StatAll/output/*
```

# Resultado

```
Max (1) 0.154
Min (1) 0.0
Avg (1) 0.05212776590930481
Max (2) 10.0
Min (2) -12.0
Avg (2) -2.188240380935686
Max (3) 8.0
Min (3) -11.0
Avg (3) -1.408876789776933
Max (4) 9.0
Min (4) -12.0
Avg (4) -1.7528724942777865
Max (5) 9.0
Min (5) -11.0
Avg (5) -1.282261707288373
Max (6) 9.0
Min (6) -13.0
Avg (6) -2.293434905140485
Max (7) 9.0
Min (7) -12.0
Avg (7) -1.5875789403216172
Max (8) 7.0
Min (8) -12.0
Avg (8) -1.7390052924221087
Max (9) 10.0
Min (9) -13.0
Avg (9) -1.6989002790625127
Max (0) 0.768
Min (0) 0.094
Avg (0) 0.2549619599173307
```
