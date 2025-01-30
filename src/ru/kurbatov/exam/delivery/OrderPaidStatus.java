package ru.kurbatov.exam.delivery;

public class OrderPaidStatus implements OrderStatus{

    @Override
    public String getStatus() {
        return "Заказ оплачен";
    }

    @Override
    public void changeStatus(Order order, String... location) {
        if (location.length == 0)
            throw new IllegalArgumentException("Location is null");
        order.setStatus(new OrderDeliveryStatus(location[0]));
    }
}
