class Solution {
    private final String current = ".";
    private final String backward = "..";
    
    public String simplifyPath(String path) {
       String newPath = path.replace("//","/");
        String[] pathList = newPath.split("/");

        Stack<String> stack = new Stack<>();
        for(String splitPath: pathList){

            if(splitPath.isBlank()){
                continue;
            }
            if(current.equals(splitPath)){
                continue;
            }

            if(backward.equals(splitPath)){
                if(!stack.isEmpty())
                    stack.pop();
                
                continue;
            }

            stack.push(splitPath);
        }
       return makePath(stack); 
    }

    public String makePath(Stack stack){
        String answer = new String();
        while(!stack.isEmpty()){
            answer = stack.pop()+answer;
            answer = "/" +answer;
        }
        if(answer.isBlank())return "/";
        return answer.toString();
    }
}