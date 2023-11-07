package visitor;

public interface Visitor {
    void visit(Treadmill treadmill);
    void visit(Weights weights);
    void visit(Squash squash);
}
