#!/bin/bash

echo "[*]Connecting to Cricinfo RSS Feeds"
sleep 1
echo "[*]Searching updates about India's score"
echo "[*]Connected :D"
curl -silent -output score_data.xml http://static.cricinfo.com/rss/livescores.xml > score_data.xml 
cat score_data.xml | grep India |  grep title | cut -d ">" -f2 | cut -d "<" -f1

