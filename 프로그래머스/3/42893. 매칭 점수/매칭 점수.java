import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;
       
        
        HashMap<String,Page> pageMap = new HashMap<>();
        ArrayList<String> realPages = new ArrayList<>();
        for(int idx =0 ;idx< pages.length; idx++){
            String page = pages[idx];
            //현재 페이지 url 정보
            String url = findNowPage(page);
        //각 페이지 기본점수 계산하기
            Double point = calcNormalScore(page,word);
        //각 페이지 href 태그 갯수 계산하기
            List<String> hrefs = findHref(page);
            
            int linkCount = hrefs.size();
            System.out.println(linkCount);
            realPages.add(url);
            Page nowPage = new Page(url,point,linkCount);
            pageMap.put(url,nowPage);
        }
        
        for(int idx = 0; idx<pages.length; idx++){
            //href 페이지 url로 링크점수 가져오기
            List<String> hrefs = findHref(pages[idx]);
            
            Page page =  pageMap.get(realPages.get(idx));
            System.out.println("now "+page.url);
            
            if(hrefs.size()==0)continue;
            Double linkScore = (Double)page.score/page.link;
            for(String href : hrefs){
                
                if(!pageMap.containsKey(href))continue;
                System.out.println("href "+href);
                pageMap.get(href).pluslinkScore(linkScore);
            }
            
           
        }
        Double max = -1.0;
         int maxIdx = -1;
        for(int idx =0 ;idx<pages.length;idx++){
            String url = realPages.get(idx);
            System.out.println(pageMap.get(url).score+pageMap.get(url).linkScore);
            if(pageMap.get(url).score+pageMap.get(url).linkScore>max){
                max = pageMap.get(url).score+pageMap.get(url).linkScore;
                maxIdx = idx;
            }
        }
        
        return maxIdx;
    }
    
    public List<String> findHref(String page){
         String regex = "<a href=\"(?<link>[^\"]*)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(page);
        
        List<String> answer = new ArrayList<>();
        while(matcher.find()){
           answer.add(matcher.group(1));
        }
       return answer;
    }
    
    public Double calcNormalScore(String page,String find){

        page = page.toLowerCase();
        find = find.toLowerCase();

        
        String[] words = page.split("[^a-z]+");
         int answer = 0;
        for(String word: words){
            if(word.equals(find))answer++;
        }

        return (double)answer ;
    }
    public String findNowPage(String page){
        String regex = "<head>[\\s\\S]*<meta[^>]*content=\"(?<url>[^\"]*)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(page);
        if(matcher.find()){
            return matcher.group(1);
        }
        return "";
    }
    
    static class Page{
        String url;
        Double score;
        int link;
        Double linkScore;
        
        
        public Page(String url, Double score, int link){
            this.url = url;
            this.score =score;
            this.link = link;
            this.linkScore=0.0;
        }
        
        public void pluslinkScore(Double links){
            this.linkScore += links;
        }
    }
}