package factory.standardType;

public abstract class MechanizedUnit {
    private int hp;
    private int exp;
    private int dmg;

    public MechanizedUnit(int hp, int exp, int dmg) {
        this.hp = hp;
        this.exp = exp;
        this.dmg = dmg;
    }

    public int getHp() {
        return hp;
    }

    public int getExp() {
        return exp;
    }

    public int getDmg() {
        return dmg;
    }

    @Override
    public String toString() {
        return "MechanizedUnit{" +
                "hp=" + hp +
                ", exp=" + exp +
                ", dmg=" + dmg +
                '}';
    }
}
