package flyweight;

public class UnitStatsRepository {
    private static UnitStats destroyerUnitStats = new UnitStats("Destroyer", 1000, 500, 200, 50, 100);
    private static UnitStats rifleUnitStats = new UnitStats("RifleUnit", 100, 100, 50, 35, 50);
    private static UnitStats knifeUnitStats = new UnitStats("KnifeUnit", 100, 100, 50, 10, 20);
    private UnitStatsRepository(){}
    public static UnitStats getDestroyerUnitStats() {
        return destroyerUnitStats;
    }

    public static UnitStats getRifleUnitStats() {
        return rifleUnitStats;
    }

    public static UnitStats getKnifeUnitStats() {
        return knifeUnitStats;
    }
}
