package design;

import design.Adapter.*;
import design.Aop.AopBrowser;
import design.decorator.Audi;
import design.decorator.ICar;
import design.proxy.Browser;
import design.proxy.BrowserProxy;
import design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
	// write your code here
//       HairDryer hairDryer=new HairDryer();
//       connect(hairDryer);
//       Cleaner cleaner=new Cleaner();
//       Electronic110V adapter=new SocketAdapter(cleaner);
//       connect(adapter);
//        AirConditioner airConditioner=new AirConditioner();
//        Electronic110V airAdapter= new SocketAdapter(airConditioner);
//        connect(airAdapter);
ICar audi=new Audi(1000);
audi.showPrice();
//a3

        //a4

        //a5
    }
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
