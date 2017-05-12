# Instrucciones

```
mkdir java_classes
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-mapreduce/* -d java_classes AvgAll*
/usr/java/jdk1.7.0_51/bin/jar -cvf AvgAll.jar -C java_classes / .
hadoop jar AvgAll.jar oldapi.AvgAll /tmp/BDCC/datasets/ECBDL14/ECBDL14_10tst.data ./AvgAll/output/
hdfs dfs -cat AvgAll/output/*
```

# Resultado

```
1   0.05212776590940497
2   -2.188240380935686
3   -1.408876789776933
4   -1.7528724942777865
5   -1.282261707288373
6   -2.293434905140485
7   -1.5875789403216172
8   -1.7390052924221087
9   -1.6989002790625127
0   0.25496195991730947
```

