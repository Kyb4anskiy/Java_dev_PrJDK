package ru.kurbatov.exam.delivery;

public class OrderGettingStatus implements OrderStatus{

    @Override
    public String getStatus() {
        return "Заказ получен";
    }

    @Override
    public void changeStatus(Order order, String... location) {
        System.out.println("Заказ уже был доставлен");
    }
}
