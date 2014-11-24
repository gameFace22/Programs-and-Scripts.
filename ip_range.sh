#!/bin/bash

a=1
while [ $a -ne 256 ]
 do
 ping -c 1 x.x.x.$a > /dev/null                        #/dev/null is a device file which discards all the data written to it.
 if [ $? -eq 0 ]                                              
 then
   echo x.x.x.$a IS UP >> ip_range_UP.txt
   ((a++))
 else
   echo x.x.x.$a IS DOWN 
   ((a++))
 fi 
 done
