package flyweight;

public class DestroyerUnit {
    private int x;
    private int y;
    private int hpLeft;
    private UnitStats stats;
    public DestroyerUnit() {}

    public DestroyerUnit(int x, int y) {
        stats = UnitStatsRepository.getDestroyerUnitStats();
        this.x = x;
        this.y = y;
        this.hpLeft = stats.getHp();
    }
}
