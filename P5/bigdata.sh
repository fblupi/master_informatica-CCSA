#!/bin/bash

DATAPATH="/user/mcc75926571/datasets"
DATASET="BNG_heart"

FILE_SIZE=(`hadoop fs -ls $DATAPATH/$DATASET/$DATASET-5-1tra.dat | awk '{print $5}'`)
MAPS=64
TREES=100
BYTES_BY_PARTITION=$(($FILE_SIZE/$MAPS))
MAX_BYTES_BY_PARTITION=$((BYTES_BY_PARTITION+1))

hadoop jar /tmp/mahout-distribution-sige.jar \
	org.apache.mahout.classifier.df.tools.Describe \
	-p $DATAPATH/$DATASET/$DATASET-5-1tra.dat \
	-f $DATASET.info -d N C 3 N 2 C N C N 3 C L;

hadoop jar /tmp/mahout-distribution-sige.jar \
	org.apache.mahout.classifier.df.mapreduce.BuildForest \
	-Dmapreduce.input.fileinputformat.split.minsize=$BYTES_BY_PARTITION \
	-Dmapreduce.input.fileinputformat.split.maxsize=$MAX_BYTES_BY_PARTITION \
	-o output_RF_${TREES}_${MAP} \
	-d $DATAPATH/$DATASET/$DATASET-5-1tra.dat \
	-ds $DATASET.info \
	-sl 13 -p -t $TREES;

hadoop jar /tmp/mahout-distribution-sige.jar \
	org.apache.mahout.classifier.df.mapreduce.TestForest \
	-i $DATAPATH/$DATASET/$DATASET-5-1tst.dat \
	-ds $DATASET.info \
	-m output_RF_${TREES}_${MAP} \
	-a -mr -o output_RF_predict_out_${TREES}_${MAP};
