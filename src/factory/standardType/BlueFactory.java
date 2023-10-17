package factory.standardType;

import factory.standardType.Rifleman;
import factory.UnitType;

import static factory.UnitType.TANK;

public class BlueFactory extends Factory {
    @Override
    public InfantryUnit createInfantryUnit(UnitType unitType) {
        switch(unitType) {
            case RIFLEMAN:
                return new Rifleman(25, 100, 10);
            default:
                throw new UnsupportedOperationException("Undefined unit type");
        }
    }

    @Override
    public MechanizedUnit createMechanizedUnit(UnitType unitType) {
        switch(unitType) {
            case TANK:
                return new Tank(250, 500, 300);
            default:
                throw new UnsupportedOperationException("Undefined unit type");
        }
    }
}
