from splinter import Browser
browser = Browser()
browser.visit('https://facebook.com')
browser.fill('email','nishaanthguna@gmail.com')
browser.fill('pass','googleiswaiting')
browser.find_by_id('u_0_n').click()
