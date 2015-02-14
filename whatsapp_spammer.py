from splinter import Browser
import time
#I used this because my chrome driver was throwing lots of issues.So,I thought switching the user agent would do the trick
fire_br = Browser(user_agent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
fire_br.visit("https://web.whatsapp.com")
#after this you need to scan QR code using your mobile + we tried automating this but the QR code uses some kind of encryption x(
#and choose a group/member whom you want to send the text to!
input_string = 1
#find_by_css method is used to find the text box and send button,because finding it by other methods were too tedious
for input_string in range(1,1000): 
 fire_br.find_by_css("#compose-input > div").fill(input_string)
 fire_br.find_by_css("#main > footer > div > button.icon.btn-icon.icon-send").first.click()
 time.sleep(2)
