#!/bin/bash

# This script prints a message about your weight
# if you give it your weight in kilos and hight in centimeters.

# $#代表了命令行的参数数量.
# $0 代表了脚本的名字。
# 命令行参数使用位置参数$1,$2,...,$N来达到此目的.
# 第一个参数代表$1，第二个参数代表$2，以此类推.

if [ ! $# == 2 ]
then
    echo "Usage: $0 weight_in_kilos length_in_centimeters"
    exit
fi

weight="$1"
height="$2"

idealweight=$[$height-110]
echo "Your ideal weight is $idealweight kilos"
echo

bmi=$[100*$weight/$height]
bmi=$[100*$bmi/$height]
echo "Your BMI is $bmi"
echo

if [ $weight -le $idealweight ]
then
    echo "You should eat a bit more fat."
else
    echo "You should eat a bit more fruit."
fi
