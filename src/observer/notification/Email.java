package observer.notification;

import observer.order.Order;

public class Email implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("EMAIL. Order number: " + order.getOrderNumber() + " has changed his status to: " + order.getOrderStatus());
    }
}
