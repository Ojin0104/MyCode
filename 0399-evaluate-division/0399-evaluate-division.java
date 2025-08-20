class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Point>> map = new HashMap<>();
        for(int idx = 0 ;idx < equations.size(); idx++){
            List<String> equation = equations.get(idx);

            String a = equation.get(0);
            String b = equation.get(1);

            double point = values[idx];

            map.computeIfAbsent(a, k-> new ArrayList<Point>()).add(new Point(point,b));
            map.computeIfAbsent(b, k-> new ArrayList<Point>()).add(new Point(1.0/point,a));

        }


        double[] answer = new double[queries.size()];

        for(int idx = 0;idx<queries.size(); idx++){
            List<String> query = queries.get(idx);

            String a = query.get(0);
            String b = query.get(1);

            answer[idx] = dfs(a,b,map,new HashSet<>());
        }
        return answer;
    }

    public double dfs(String a, String b , Map<String,List<Point>> map, HashSet<String> visited){
        if(!map.containsKey(a) || !map.containsKey(b)) return -1.0;

        if(a.equals(b))return 1.0;

        visited.add(a);

        for(Point nextPoint : map.get(a)){
            if(visited.contains(nextPoint.str))continue;

            double answer = dfs(nextPoint.str,b,map,visited);

            if(answer != -1.0){
                return nextPoint.number * answer;
            }
        }

        return -1.0;
    }

    public class Point{
        double number;
        String str;

        public Point(double number, String str){
            this.number = number;
            this.str = str;
        }
    }
}