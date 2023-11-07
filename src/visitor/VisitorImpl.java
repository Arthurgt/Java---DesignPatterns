package visitor;

public class VisitorImpl implements Visitor {
    @Override
    public void visit(Treadmill treadmill) {
        System.out.println("Calories burned running on treadmill " + treadmill.getDistance()*10);

    }

    @Override
    public void visit(Weights weights) {
        System.out.println("Calories burned lifting weights " + weights.getWeight()*weights.getReps()*2);
    }

    @Override
    public void visit(Squash squash) {
            System.out.println("Calories burned playing squash " + squash.getMinutesPlayed()*20);
    }
}
