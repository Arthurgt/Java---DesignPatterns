package strategy;

public class SoftBoiledEggCooker implements EggCooker {
    @Override
    public void cookEgg() {
        System.out.println("Cooking soft boiled egg!");
    }
}
