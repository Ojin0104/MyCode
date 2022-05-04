from django.shortcuts import render,get_object_or_404
from .models import Blog

def home(request):
    blogs=Blog.objects#객체담아주기 쿼리셋 모든 객체 보여주므로
    return render(request,'home.html',{'blogs':blogs})

def hello(request):
    blogs=Blog.objects#객체담아주기 쿼리셋
    return render(request,'hello.html')

def detail(request,blog_id):
    blog_detail=get_object_or_404(Blog,pk=blog_id)#pk는 기본키 모든객체가아닌 특정하나의 객체 담아야함
    return render(request,'detail.html',{'blog':blog_detail})
# Create your views here.
