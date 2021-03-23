package main;

import observer.notification.Email;
import observer.notification.MobileApp;
import observer.notification.TextMessage;
import observer.order.Order;
import observer.order.OrderStatus;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.launchObserver();
    }

    public void launchObserver() {
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
}
