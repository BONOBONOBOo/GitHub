from flask import Flask,render_template,request
import requests
from decouple import config
from pprint import pprint
import random


app = Flask(__name__)

token = config("TOKEN")
base_url=f"https://api.telegram.org/bot{token}"

@app.route("/telegram")
def telegram():
    res = requests.get(f"{base_url}/getUpdates").json()
    id = res["result"][0]["message"]["chat"]["id"]

    number = range(1,45)
    lotto = random.sample(number,6)

    requests.get(f"{base_url}/sendMessage?chat_id={id}&text={lotto}")

    return ""

@app.route("/chat")
def chat():
    return render_template("chat.html")

@app.route("/send_msg")
def send_message():
    req = request.args.get("chat")

    res = requests.get(f"{base_url}/getUpdates").json()
    id = res["result"][0]["message"]["chat"]["id"]

    requests.get(f"{base_url}/sendMessage?chat_id={id}&text={req}")

    return "성공"

@app.route("/",methods=["POST"])
def tel_web():
    # request 는 요청을 하고 받을때사용 
    req = request.get_json().get("message")

    number = range(1,45)
    lotto = random.sample(number,6)

    if req is not None:
        id = req.get("chat").get("id")
        text = req.get("text")
    
        idx = text.find("lotto")
        idx2 = text.find("indian")
        idx3 = text.find("trans")

        year_match = ["말 많은", "푸른", "어두운", "조용한", "웅크린", "백색", "지혜로운", "용감함", "날카로운", "욕심많은"]
        month_match = ["늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말","돼지","하늘","바람"]
        day_match =["와 함께 춤을","의 기상","의 그림자 속에","","","","의 환생","의 죽음","의 아래에서","을 보라","가 노래하다","의 그림자"] #12개

        r1= random.choice(year_match)
        r2= random.choice(month_match)
        r3= random.choice(day_match)

        name = r1+r2+r3

        if idx != -1:
            requests.get(f"{base_url}/sendMessage?chat_id={id}&text={lotto}")
        elif idx2 != -1:
            requests.get(f"{base_url}/sendMessage?chat_id={id}&text={name}")
        elif idx3 != -1:
            split_text = text.split(' ',maxsplit=1)
            trans_text = papago(split_text[1])
            requests.get(f"{base_url}/sendMessage?chat_id={id}&text={trans_text}")
        elif text == "?":
            requests.get(f"{base_url}/sendMessage?chat_id={id}&text=lotto : 로또번호 \n, indian : 인디언이름 , trans : 번역")
        else :
            requests.get(f"{base_url}/sendMessage?chat_id={id}&text={text}")

    return "",200

@app.route("/papago")
def papago(text):
    C_ID = config("C_ID")
    C_SC = config("C_SC")

    url = "https://openapi.naver.com/v1/papago/n2mt"

    headers={
        "Content-Type":"application/x-www-form-urlencoded; charset=UTF-8",
        "X-Naver-Client-Id":C_ID,
        "X-Naver-Client-Secret":C_SC
    }
    data={
        "source":"ko",
        "target":"en",
        "text":text
    }

    req = requests.post(url,headers=headers,data=data).json()

    context = req["message"]["result"]["translatedText"]

    
    return context



if __name__=="__main__":
    app.run(debug=True)