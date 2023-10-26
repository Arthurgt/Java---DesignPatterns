package template;

public abstract class StartCarSequence {
    public final void startTheCar() {
        fastenBelts();
        startEngine();
        setTheGear();
        go();
    }

    private void go() {
        System.out.println("Go!");
    }

    private void startEngine() {
        System.out.println("Start engine!");
    }

    private void fastenBelts() {
        System.out.println("Fasten seat belts!");
    }

    public abstract void setTheGear();
}
