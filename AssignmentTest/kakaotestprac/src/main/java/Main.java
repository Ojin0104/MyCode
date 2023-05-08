import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static final String NO_MOVE="0";
    static final String UP="1";
    static final String RIGHT="2";
    static final String DOWN="3";
    static final String LEFT="4";
    static final String LOAD="5";
    static final String SAVE="6";

    static int centerR=2;
    static int centerC=2;

    static class Pair{
        int r,c;

        Pair(int a, int b){
            r=a;
            c=b;
        }
    }

    public static HashMap<Integer,Pair> hashMap=new HashMap<>();

    private static JSONParser jsonParser = new JSONParser();

    public static void main(String [] args){
        int problemId=1;

        String response=start(problemId);

        if(response.equals("200")){
            makeMap(5,5);
            int time=0;
            while(time<720){
                time++;

                ArrayList<Location> locations=locations();
                ArrayList<Truck> trucks=trucks();
                ArrayList<Command> commands=new ArrayList<>();
                ArrayList<Integer> order;
                ArrayList<Integer> order2;

                if(time %50==1){
                    commands.add(new Command(0,getRoute(4,0,hashMap.get(18).r,hashMap.get(18).c)));
                    commands.add(new Command(1,getRoute(4,0,hashMap.get(16).r,hashMap.get(16).c)));
                    commands.add(new Command(2,getRoute(4,0,hashMap.get(6).r,hashMap.get(16).c)));
                    commands.add(new Command(3,getRoute(4,0,hashMap.get(8).r,hashMap.get(8).c)));
                    commands.add(new Command(4,getRoute(4,0,hashMap.get(12).r,hashMap.get(12).c)));
                    System.out.println(simulate(commands));
                    continue;
                }
                int max=4, maxIndex=0,min=4,minIndex=0;
                int rest=locations.get(12).located_bikes_count;

                for(Location l: locations) {
                    int r = hashMap.get(l.id).r;
                    int c = hashMap.get(l.id).c;
                    int locationId = 0;

                    if (l.located_bikes_count < 4) {
                        if (r <= 2 && c <= 2) {
                            locationId = trucks.get(3).getLocation_id();
                        }

                        if (r >= 2 && c <= 2) {
                            locationId = trucks.get(2).getLocation_id();
                        }

                        if (r <= 2 && c > 2) {
                            locationId = trucks.get(0).getLocation_id();
                        }

                        if (r > 2 && c > 2) {
                            locationId = trucks.get(1).getLocation_id();
                        }

                        order = getRoute(hashMap.get(locationId).r, hashMap.get(locationId).c, centerR, centerC);

                        int cnt = 4 - l.located_bikes_count;
                        int cur = l.located_bikes_count;

                        while (rest > 0 && order.size() < 10 && cnt != 0) {
                            cnt--;
                            rest--;
                            order.add(5);
                        }
                        order.addAll(getRoute(centerR, centerC, hashMap.get(l.id).r, hashMap.get(l.id).c));
                        while (order.size() < 10 && cur < 4) {
                            cur++;
                            order.add(6);
                        }
                    } else if (l.located_bikes_count > 4) {
                        if (r <= 2 && c <= 2) {
                            locationId = trucks.get(3).getLocation_id();
                        }

                        if (r >= 2 && c <= 2) {
                            locationId = trucks.get(2).getLocation_id();
                        }

                        if (r <= 2 && c > 2) {
                            locationId = trucks.get(0).getLocation_id();
                        }

                        if (r > 2 && c > 2) {
                            locationId = trucks.get(1).getLocation_id();
                        }

                        order = getRoute(hashMap.get(locationId).r, hashMap.get(locationId).c, centerR, centerC);

                        int cnt = 4 - l.located_bikes_count;
                        int cur = l.located_bikes_count;

                        while (rest > 0 && order.size() < 10 && cnt != 0) {
                            cnt--;
                            rest--;
                            order.add(5);
                        }
                        order.addAll(getRoute(centerR, centerC, hashMap.get(l.id).r, hashMap.get(l.id).c));

                        while (order.size() < 10 && cur < 4) {
                            cur++;
                            order.add(6);
                        }
                    }

                    if (max < l.getLocated_bikes_count()) {
                        max = l.getLocated_bikes_count();
                        maxIndex = l.id;
                    }
                    if (min > l.getLocated_bikes_count()) {
                        min = l.getLocated_bikes_count();
                        minIndex = l.id;
                    }
                }

                    int truckId=10000,truckLocationId=0, truckDistance=10000;
                    int truckgetLoadedBike=-1;

                    boolean[] trucksBoolean =new boolean[5];

                    for(Truck t:trucks){
                        Pair p=hashMap.get(t.getLocation_id());
                        Pair many=hashMap.get(maxIndex);

                        int dist=getDistance(p.r,p.c,many.r,many.c);
                        if(dist<truckDistance){
                            truckDistance=dist;
                            truckId=t.getId();
                            truckLocationId=t.getLocation_id();
                            truckgetLoadedBike=t.getLoaded_bikes_id();
                        }
                        else if(dist==truckDistance){
                            if(truckgetLoadedBike>t.getLoaded_bikes_id()){
                                truckId=t.getId();
                                truckLocationId=t.getLocation_id();
                                truckgetLoadedBike=t.getLoaded_bikes_id();
                            }
                        }
                    }

                    trucksBoolean[truckId]=true;
                    Pair p=hashMap.get(truckLocationId);
                    Pair many=hashMap.get(maxIndex);
                    order = getRoute(p.r,p.c,many.r,many.c);

                    while(order.size()<10 && truckgetLoadedBike<20 && max>4){
                        truckgetLoadedBike++;
                        max--;
                        order.add(5);
                    }
                    commands.add(new Command(truckId,order));

                    truckDistance =100000;
                    truckId=-1;

                    for( Truck t: trucks){
                        p=hashMap.get(t.getLocation_id());
                        Pair few=hashMap.get(minIndex);

                        int dist= getDistance(p.r,p.c,few.r,few.c);
                        if(t.getLoaded_bikes_id()==0||trucksBoolean[t.getId()]) continue;
                        if(dist<truckDistance){
                            truckDistance = dist;
                            truckId= t.getId();
                            truckLocationId=t.getLocation_id();
                            truckgetLoadedBike = t.getLoaded_bikes_id();

                        }else if(dist==truckDistance){
                            if(truckgetLoadedBike<t.getLoaded_bikes_id()){
                                truckId=t.getId();
                                truckLocationId=t.getLocation_id();
                                truckgetLoadedBike=t.getLoaded_bikes_id();
                            }

                        }
                    }
                    if(truckId!=-1){
                        p=hashMap.get(truckLocationId);
                        Pair few = hashMap.get(minIndex);
                        order2=getRoute(p.r,p.c,few.r,few.c);
                        while(order2.size()<10 && truckgetLoadedBike>0 && min<4){
                            truckgetLoadedBike--;
                            min++;
                            order2.add(6);
                        }
                        commands.add(new Command(truckId,order2));
                    }

                    System.out.println(simulate(commands));
                }
                System.out.println(score());

        }
    }
    private static int getDistance(int r, int c, int tr, int tc){return Math.abs(tr-r)+Math.abs(tc-c);}

    private static ArrayList<Integer> getRoute(int r, int c, int tr, int tc){
        ArrayList<Integer> orders=new ArrayList<>();
        if(r<tr){
            for(int i=0;i<tr-r;i++){
                if(orders.size()<10)
                    orders.add(3);
            }
        }else{
            for(int i=0;i<r-tr;i++){
                if(orders.size()<10)
                    orders.add(1);
            }
        }
       if(c<tc){
           for(int i=0;i<tc-c;i++){
               if(orders.size()<10)
                   orders.add(2);
           }
       }else{
           for(int i=0;i<c-tc;i++){
               if(orders.size() <10)
                   orders.add(4);
           }
       }
       return orders;
    }

    public static void makeMap(int R,int C){
        int index=0;
        for(int i=0;i<C;i++){
            for(int j=R-1;j>=0;j--){
                hashMap.put(index++,new Pair(j,i));
            }
        }
    }

    private static ArrayList<Truck>trucks(){
        JSONObject jsonObject = Connection.getInstance().trucks();
        return jsonParser.getTruck(jsonObject);

    }

    private static ArrayList<Location>locations(){
        JSONObject jsonObject= Connection.getInstance().locations();
        return jsonParser.getLocations(jsonObject);
    }

    private static int score(){
        System.out.println("### API SCORE ###");
        JSONObject jsonObject = Connection.getInstance().score();

        return jsonParser.getScore(jsonObject);
    }

    private static String simulate(ArrayList<Command>commands){
        JSONObject jsonObject=Connection.getInstance().simulate(jsonParser.getCommandsJSONArray(commands));

        Simulate simulate=jsonParser.putSimulation(jsonObject);
        return simulate.toString();
    }

    private static String start(int problemId){
        System.out.println("########### API START ###############");
        String response= TokenManager.getInstance().createToken(problemId);
        System.out.println("Token : " + TokenManager.getInstance().getToken());
        return response;
    }
}
