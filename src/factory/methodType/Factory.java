package factory.methodType;

import factory.Unit;
import factory.UnitType;

public abstract class Factory {
     public abstract Unit createUnit(UnitType unitType);
}
