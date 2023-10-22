package main;

import builder.innerClassBuilder.House1;
import builder.interfaceBuilder.BigHouseBuilder;
import builder.interfaceBuilder.House2;
import builder.interfaceBuilder.HouseDirector;
import builder.interfaceBuilder.SmallHouseBuilder;
import factory.Unit;
import factory.methodType.Factory;
import factory.methodType.UnitFactory;
import factory.UnitType;
import flyweight.DestroyerUnit;
import flyweight.KnifeUnit;
import flyweight.RifleUnit;
import observer.notification.Email;
import observer.notification.MobileApp;
import observer.notification.TextMessage;
import observer.order.Order;
import observer.order.OrderStatus;
import singleton.GameEngine;
import singleton.GameEngineEnum;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.launchObserver();
        main.launchSingleton();
        main.launchBuilder();
        main.launchFactory();
        main.launchFlyweight();
    }

    public void launchObserver() {
        System.out.println("****OBSERVER****");

        Order order = new Order(110L, OrderStatus.REGISTERED);

        TextMessage textMessage = new TextMessage();
        MobileApp mobileAppNotification = new MobileApp();
        Email email = new Email();

        order.registerObserver(textMessage);
        order.registerObserver(mobileAppNotification);
        order.registerObserver(email);

        order.notifyObservers();
        order.changeOrderStatus(OrderStatus.RECEIVED);
    }

    public void launchSingleton() {
        System.out.println("****SINGLETON****");

        GameEngine engine = GameEngine.getInstance();
        GameEngine engine2 = GameEngine.getInstance();
        GameEngineEnum engine3 = GameEngineEnum.INSTANCE; // game engine as enum

        System.out.println(engine == engine2);
    }

    public void launchBuilder() {
        System.out.println("****BUILDER****");
        System.out.println("****INNER CLASS BUILDER****");

        House1 house1 = new House1.HouseBuilder()
                .buildDoors("4 doors")
                .buildFloors("5 floors")
                .buildWindows("5 windows")
                .build();

        System.out.println(house1);

        System.out.println("****INTERFACE CLASS BUILDER****");

        SmallHouseBuilder smallHouseBuilder = new SmallHouseBuilder();
        BigHouseBuilder bigHouseBuilder = new BigHouseBuilder();

        HouseDirector smallHouseDirector = new HouseDirector(smallHouseBuilder);
        smallHouseDirector.buildHouse();
        HouseDirector bigHouseDirector = new HouseDirector(bigHouseBuilder);
        bigHouseDirector.buildHouse();

        House2 smallHouse = smallHouseDirector.getHouse();
        House2 bigHouse = bigHouseDirector.getHouse();

        System.out.println(smallHouse.toString());
        System.out.println(bigHouse.toString());
    }

    public void launchFactory() {
        System.out.println("****FACTORY****");
        System.out.println("****METHOD TYPE FACTORY****");

        Factory factory = new UnitFactory();
        Unit tank = factory.createUnit(UnitType.TANK);
        Unit rifleman = factory.createUnit(UnitType.RIFLEMAN);

        System.out.println(tank.toString());
        System.out.println(rifleman.toString());
    }

    public void launchFlyweight() {
        System.out.println("****FLYWEIGHT****");

        List<Object> activeUnits = new ArrayList<>();
        for(int i=0; i<1000; i++){
            activeUnits.add(new DestroyerUnit(0, 0));
            activeUnits.add(new RifleUnit(10, 0));
            activeUnits.add(new KnifeUnit(30, 0));
        }
    }
}