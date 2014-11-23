#!/bin/bash

a=1
while [ $a -ne 256 ]
 do
 ping -c 1 172.17.171.$a > /dev/null
 if [ $? -eq 0 ]
 then
   echo 172.17.171.$a IS UP >> ip_range_UP.txt
   ((a++))
 else
   echo 172.17.171.$a IS DOWN 
   ((a++))
 fi 
 done
