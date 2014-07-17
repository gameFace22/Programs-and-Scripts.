Shell-Scripts
=============

Shell scripts are meant to reduce your work load and do everything in the terminal(geeky stuff xP). I thought of adding all the scripts which I write on my *own*,so that I don't lose it any cost. *Precious* they are.


1.Getting OpenVPN password from VPNBook:

For all the VPNBook users,it is really a pain to go the VPNBook site and check for the new password which they update once in a while.
So,I wrote this very simple script to get the password using curl and print it by spraying some *cut* *uniq* *grep* in the script.

Just download the script and make it executable.

chmod +x 777 vpnbook.sh

Run it by using,
./vpnbook.sh

That simple :) 


2.Python Script to crack a MD5:

This script uses a normal dictionary file to reverse the original MD5 and print it.
If you want to go for a bigger dictionary file,you can have a look at,
http://dazzlepod.com/site_media/txt/passwords.txt.
Save the dictionary file as dictionary.txt and run the program :D

python filename.py
