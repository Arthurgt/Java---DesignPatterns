package factory.standardType;

import factory.UnitType;

public class RedFactory extends Factory {
    @Override
    public InfantryUnit createInfantryUnit(UnitType unitType) {
        switch(unitType) {
            case RIFLEMAN:
                return new Rifleman(55, 100, 100);
            default:
                throw new UnsupportedOperationException("Undefined unit type");
        }
    }

    @Override
    public MechanizedUnit createMechanizedUnit(UnitType unitType) {
        switch(unitType) {
            case TANK:
                return new Tank(150, 500, 100);
            default:
                throw new UnsupportedOperationException("Undefined unit type");
        }
    }
}
