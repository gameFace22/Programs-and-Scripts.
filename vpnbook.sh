#! /bin/bash

wget http://www.vpnbook.com/freevpn 
grep -e Password freevpn | cut -d '>' -f3 | cut -d '<' -f1 | uniq > test.txt
cat test.txt
