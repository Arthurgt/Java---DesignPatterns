package factory.methodType;

import factory.Rifleman;
import factory.Tank;
import factory.Unit;

public class UnitFactory extends Factory {
    @Override
    public Unit createUnit(UnitType unitType) {
        switch(unitType) {
            case TANK:
                return new Tank(200, 200, 300);
            case RIFLEMAN:
                return new Rifleman(50, 50, 30);
            default:
                throw new UnsupportedOperationException("Undefined unit type");
        }
    }
}
