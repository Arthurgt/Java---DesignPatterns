package observer.notification;

import observer.order.Order;

public class MobileApp implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("MOBILE-APP. Order number: " + order.getOrderNumber() + " has changed his status to: " + order.getOrderStatus());
    }
}
