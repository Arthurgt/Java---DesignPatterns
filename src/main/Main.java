package main;

import adapter.*;
import builder.innerClassBuilder.House1;
import builder.interfaceBuilder.BigHouseBuilder;
import builder.interfaceBuilder.House2;
import builder.interfaceBuilder.HouseDirector;
import builder.interfaceBuilder.SmallHouseBuilder;
import chainOfResponsibility.*;
import command.*;
import decorator.*;
import factory.Unit;
import factory.methodType.Factory;
import factory.methodType.UnitFactory;
import factory.UnitType;
import flyweight.DestroyerUnit;
import flyweight.KnifeUnit;
import flyweight.RifleUnit;
import memento.SmartApp;
import memento.SmartAppCareTaker;
import observer.notification.Email;
import observer.notification.MobileApp;
import observer.notification.TextMessage;
import observer.order.Order;
import observer.order.OrderStatus;
import singleton.GameEngine;
import singleton.GameEngineEnum;
import strategy.Chef;
import strategy.EggCooker;
import strategy.HardBoiledEggCooker;
import strategy.SoftBoiledEggCooker;
import template.StartAutomaticCarSequence;
import template.StartCarSequence;
import template.StartClassicCarSequence;
import visitor.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.launchObserver();
        main.launchSingleton();
        main.launchBuilder();
        main.launchFactory();
        main.launchFlyweight();
        main.launchAdapter();
        main.launchDecorator();
        main.launchChainOfResponsibility();
        main.launchTemplate();
        main.launchCommand();
        main.launchMemento();
        main.launchStrategy();
        main.launchVisitor();
        System.out.println();
    }

    public void launchObserver() {
        System.out.println();
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
        System.out.println();
        System.out.println("****SINGLETON****");

        GameEngine engine = GameEngine.getInstance();
        GameEngine engine2 = GameEngine.getInstance();
        GameEngineEnum engine3 = GameEngineEnum.INSTANCE; // game engine as enum

        System.out.println(engine == engine2);
    }

    public void launchBuilder() {
        System.out.println();
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
        System.out.println();
        System.out.println("****FACTORY****");
        System.out.println("****METHOD TYPE FACTORY****");

        Factory factory = new UnitFactory();
        Unit tank = factory.createUnit(UnitType.TANK);
        Unit rifleman = factory.createUnit(UnitType.RIFLEMAN);

        System.out.println(tank.toString());
        System.out.println(rifleman.toString());
    }

    public void launchFlyweight() {
        System.out.println();
        System.out.println("****FLYWEIGHT****");

        List<Object> activeUnits = new ArrayList<>();
        for(int i=0; i<1000; i++){
            activeUnits.add(new DestroyerUnit(0, 0));
            activeUnits.add(new RifleUnit(10, 0));
            activeUnits.add(new KnifeUnit(30, 0));
        }
    }

    public void launchAdapter() {
        System.out.println();
        System.out.println("****ADAPTER****");

        ContinentalDevice radio = new ContinentalDevice() {
            @Override
            public void powerOn() {
                System.out.println("Music plays");
            }
        };
        ContinentalSocket continentalSocket = new ContinentalSocket();
        continentalSocket.plugIn(radio);

        UKDevice englishRadio = new UKDevice() {
            @Override
            public void play() {
                System.out.println("Music from english radio plays");
            }
        };
        System.out.println("-ONE WAY ADAPTER-");
        UKToContinentalAdapter adapter = new UKToContinentalAdapter(englishRadio);
        continentalSocket.plugIn(adapter);

        System.out.println("-TWO WAY ADAPTER-");
        UKSocket ukSocket = new UKSocket();
        TwoWayUKContinentalAdapter twoWayAdapter = new TwoWayUKContinentalAdapter(englishRadio,radio);
        ukSocket.plugIn(twoWayAdapter);
        continentalSocket.plugIn(twoWayAdapter);
    }

    public void launchDecorator() {
        System.out.println();
        System.out.println("****Decorator****");
        Terrain plain = new Plain();
        Terrain hill = new Hill();
        Terrain swampHill = new SwampDecorator(new Hill());
        Terrain forestPlain = new ForestDecorator(new Plain());
        Terrain swampPlain = new SwampDecorator(new Plain());
        Terrain forestHill = new ForestDecorator(new Hill());
        System.out.println("Normal plain fuel cost: " + plain.getFuelCost());
        System.out.println("Normal hill fuel cost: " + hill.getFuelCost());
        System.out.println("Swamp hill fuel cost: " + swampHill.getFuelCost());
        System.out.println("Forest plain fuel cost: " + forestPlain.getFuelCost());
        System.out.println("Forest hill fuel cost: " + forestHill.getFuelCost());
        System.out.println("Swamp plain fuel cost: " + swampPlain.getFuelCost());
    }

    public void launchChainOfResponsibility() {
        System.out.println();
        System.out.println("****CHAIN OF RESPONSIBILITY****");
        Message message = new Message("Attack!", 20, OfficerRank.CAPTAIN);
        Officer sergeant = new Sergeant();
        Officer captain = new Captain();
        Officer general = new General();
        sergeant.setSuperiorOfficer(captain);
        captain.setSuperiorOfficer(general);
        sergeant.processMessage(message);
    }

    public void launchTemplate() {
        System.out.println();
        System.out.println("****TEMPLATE****");
        StartCarSequence classicSequence = new StartClassicCarSequence();
        StartCarSequence automaticSequence = new StartAutomaticCarSequence();
        classicSequence.startTheCar();
        automaticSequence.startTheCar();
    }

    public void launchCommand() {
        System.out.println();
        System.out.println("****LAUNCH****");
        Robot robot = new Robot();
        Workshop workshop = new Workshop();
        workshop.addCommandToQueue(new RobotTurnOnCommand(robot));
        workshop.addCommandToQueue(new RobotCutCommand(robot));
        workshop.addCommandToQueue(new RobotDrillCommand(robot));
        workshop.addCommandToQueue(new RobotTurnOffCommand(robot));
        workshop.run();
    }

    public void launchMemento() {
        System.out.println();
        System.out.println("****MEMENTO****");
        SmartAppCareTaker smartAppCareTaker = new SmartAppCareTaker();
        SmartApp smartApp = new SmartApp();
        smartApp.changeVersion(1.0);
        smartAppCareTaker.addMemento(smartApp.save());
        smartApp.changeVersion(2.0);
        smartAppCareTaker.addMemento(smartApp.save());
        smartApp.load(smartAppCareTaker.getMemento(0));
    }

    public void launchStrategy() {
        System.out.println();
        System.out.println("****STRATEGY****");
        Chef chef = new Chef("Gordon");
        EggCooker strategy = new HardBoiledEggCooker();
        chef.setEggCooker(strategy);
        chef.cook();
        strategy = new SoftBoiledEggCooker();
        chef.setEggCooker(strategy);
        chef.cook();
    }

    public void launchVisitor() {
        System.out.println();
        System.out.println("****VISITOR****");
        Treadmill treadmill = new Treadmill(200);
        Squash squash = new Squash(35);
        Weights weights = new Weights(50, 10);
        VisitorImpl visitor = new VisitorImpl();
        treadmill.accept(visitor);
        squash.accept(visitor);
        weights.accept(visitor);
        List<Activity> activities = Arrays.asList(treadmill, squash, weights);
        activities.forEach(activity -> activity.accept(visitor));
    }
}
