import hashlib 
def main():
 md5input=raw_input("Enter a encrypted MD5 hash:")
 dictionaryfile=open('dictionary.txt','r')
 print "[*]MD5 Decrypter running" 
 print "[*]Checking in the  DB"
 for word in dictionaryfile.readlines():
  word=word.strip('\n')
  md5output=hashlib.md5(word).hexdigest()
  if(md5input==md5output):
   print "MD5 REVESE LOOKUP SUCCESSFUL!"
   print "MD5 Reverse:"+word+""
   print "Happy Hacking :D"

if __name__== "__main__":
 main() 
