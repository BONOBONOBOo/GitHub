from flask import Flask,render_template,request
import requests
from decouple import config
from pprint import pprint


token = config("TOKEN")
base_url=f"https://api.telegram.org/bot{token}"

#url="89e79a45.ngrok.io"
url="bonobono.pythonanywhere.com"
setweb_url = f"/setWebhook?url={url}"

 


req = requests.get(base_url+setweb_url).json()
pprint(req)