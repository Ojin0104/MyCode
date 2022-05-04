from django.db import models

class Blog(models.Model):
    title=models.CharField(max_length=200) #짧은 문자열
    pub_date=models.DateTimeField('date published')
    body=models.TextField() #긴문자열

    def __str__(self):
        return self.title
    
    def summary(self):
        return self.body[:100]
    def bodylen(self):
        return len(self.body)