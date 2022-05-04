from django.shortcuts import render

# Create your views here.
def home(request):
	return render(request,'home.html')

def about(request):
    return render(request,'about.html')

def result(request):
    text=request.GET['fulltext']
    words=text.split()
    dicc=dict()
    for a in words:
        if a in dicc:
            dicc[a]+=1
        else:
            dicc[a]=1
    return render(request,'result.html',{'full':text,'total':len(words),'dictionary':dicc.items()})