package flyweight;

public class RifleUnit {
    private int x;
    private int y;
    private int hpLeft;
    private UnitStats stats;
    public RifleUnit() {}

    public RifleUnit(int x, int y) {
        stats = UnitStatsRepository.getRifleUnitStats();
        this.x = x;
        this.y = y;
        this.hpLeft = stats.getHp();
    }
}
