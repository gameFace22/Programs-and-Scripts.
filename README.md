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
I chose a small file because my system started to hang :(
If you want to go for a bigger dictionary file,you can have a look at,
http://dazzlepod.com/site_media/txt/passwords.txt.
Save the dictionary file as dictionary.txt and run the program :D

python filename.py


3.Shell script to get the score and print in the terminal

chmod 777 score.sh
./score.sh

Works *exactly* like vpnbook.sh.

4.FCFS:

g++ FCFS.cpp

This program implements the standard First Come First Serve algorithm.
This was completely coded by me from the beginning. 

5.IP_RANGE:

chmod 777 ip_range.sh
./ip_range.sh

This is a simple code which uses a for loop to get all the possible IP's from 172.17.xx.xx range(in which several are my college security cameras :P )
I wrote this to get more IP's of the cameras which are all over my college :P
Susshhh *secret*

6.Extended Eucledian Algorithm:

I had to solve some problems given by my Cryptography sir which included finding GCD of two numbers using EEA. I was so lazy to table it out and find every value. :P

7.Apachecron

This script checks if a apache2 server is running and if not,it starts the server.
(Thanks to Niranjan for asking me to do this ;) )

8.Whatsapp Spammer

Splinter is a python module which is so easy to use and also the documentation is so neat and well explained! I was trying to automate certain things and ended up creating a whatsapp spammer.You can even add your own functionalities + modules which you would like the program to send ;) 
@niranjan94 +1 

