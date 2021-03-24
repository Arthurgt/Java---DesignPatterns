package main;

import observer.notification.Email;
import observer.notification.MobileApp;
import observer.notification.TextMessage;
import observer.order.Order;
import observer.order.OrderStatus;
import singleton.GameEngine;
import singleton.GameEngineEnum;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.launchObserver();
        main.launchSingleton();
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

//      GameEngineEnum engine3 = GameEngineEnum.INSTANCE; // game engine as enum

        System.out.println(engine == engine2);
    }
}
