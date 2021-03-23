package observer.notification;

import observer.order.Order;

public class TextMessage implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("SMS. Order number: " + order.getOrderNumber() + " has changed his status to: " + order.getOrderStatus());
    }
}
