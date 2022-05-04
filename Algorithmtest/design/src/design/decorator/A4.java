package design.decorator;

public class A4 extends AudiDecorator{

    public A4(Audi audi, String modelName, int modelPrice) {
        super(audi, modelName, 2000);
    }
}
