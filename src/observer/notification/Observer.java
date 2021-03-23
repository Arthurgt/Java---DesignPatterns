package observer.notification;

import observer.order.Order;

public interface Observer {
    void update(Order order);
}
