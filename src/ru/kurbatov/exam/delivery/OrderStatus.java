package ru.kurbatov.exam.delivery;

public interface OrderStatus {

    String getStatus();
    void changeStatus(Order order, String... location);

}
