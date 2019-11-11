from django.shortcuts import render
from faker import Faker
from datetime import datetime
import random



def job(request,name):
    fake = Faker("ko_kr")
    job = fake.job()

    context = {
        "name":name,
        "job":job
    }
    
    return render(request,"job.html",context)

def image(request):
    num = random.choice(range(1,100))
    url=f"https://picsum.photos/id/{num}/200/300"

    context={
        "url":url
    }
    return render(request,"image.html",context)

def dtl(request):
    foods=["짜장면","탕수육","짱뽕","볶음밥","군만두","깐풍기","고주잡채"]

    my_sentence="Life is short"

    messages = ["apple","banana"]

    datetimenow = datetime.now()

    empty_list = []
    context={
        "foods":foods,
        "my_sentence":my_sentence,
        "message":messages,
        "datetime":datetimenow,
        "empty":empty_list
    }

    return render(request,"dtl.html",context)

