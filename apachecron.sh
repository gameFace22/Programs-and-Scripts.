#!/bin/bash

service apache2 status >> statuslog
if grep -q NOT statuslog
then 
 echo "[+]Preparing to start"
 service apache2 start 
else
 echo "[+]Server already running"
fi
> statuslog
