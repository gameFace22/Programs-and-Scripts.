#!/bin/bash

a=1
while [ $a -ne 256 ]
 do
 ping -c 1 172.17.171.$a > /dev/null                        #/dev/null is a device file which discards all the data written to it.
 if [ $? -eq 0 ]                                              
 then
   echo 172.17.171.$a IS UP >> ip_range_UP.txt
   ((a++))
 else
   echo 172.17.171.$a IS DOWN 
   ((a++))
 fi 
 done
