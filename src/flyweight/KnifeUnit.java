package flyweight;

public class KnifeUnit {
    private int x;
    private int y;
    private int hpLeft;
    private UnitStats stats;
    public KnifeUnit() {}

    public KnifeUnit(int x, int y) {
        stats = UnitStatsRepository.getKnifeUnitStats();
        this.x = x;
        this.y = y;
        this.hpLeft = stats.getHp();
    }
}
