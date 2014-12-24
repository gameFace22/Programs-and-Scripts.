
import socket 


server = "irc.freenode.net" 
channel = "#hackademic-dev" 
botnick =  "hackademic-bot" 


def ping(): 
  ircsock.send("PONG :pingis\n")  

def sendmsg(chan , msg): 
  ircsock.send("PRIVMSG "+ chan +" :"+ msg +"\n") 

def joinchan(chan): 
  ircsock.send("JOIN "+ chan +"\n")

def hello(): 
  ircsock.send("PRIVMSG "+ channel + "Hello" + "\n")

def whois(): 
  ircsock.send("PRIVMSG "+ channel +" Hackademic Bot :P\n")


ircsock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
ircsock.connect((server, 6667))
ircsock.send("USER "+ botnick +" "+ botnick +" "+ botnick +" :This is hackbot.\n") 
ircsock.send("NICK "+ botnick +"\n") 
ircsock.send("PRIVMSG" + "Nickserv" + "identify" + "botprogram" + "\n" );
joinchan(channel) 

while 1: 
  ircmsg = ircsock.recv(2048) 
  ircmsg = ircmsg.strip('\n\r') 
  print(ircmsg) 

  if ircmsg.find("Hello" + botnick) != -1: 
    hello()

  if ircmsg.find("PING :") != -1: 
    ping()
  
  if ircmsg.find("Who is "+ botnick) != -1: 
    whois()
