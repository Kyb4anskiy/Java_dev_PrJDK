package ru.kurbatov.exam.delivery;

public class OrderPlacedStatus implements OrderStatus{

    @Override
    public String getStatus() {
        return "Заказ оформлен";
    }

    @Override
    public void changeStatus(Order order, String... location) {
        order.setStatus(new OrderPaidStatus());
    }
}
