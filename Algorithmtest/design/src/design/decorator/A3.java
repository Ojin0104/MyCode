package design.decorator;

public class A3 extends AudiDecorator{

    public A3(Audi audi, String modelName, int modelPrice) {
        super(audi, modelName, 1000);
    }
}
