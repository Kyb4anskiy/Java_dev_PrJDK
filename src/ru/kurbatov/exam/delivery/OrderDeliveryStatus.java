package ru.kurbatov.exam.delivery;

public class OrderDeliveryStatus implements OrderStatus{

    private String location;

    protected OrderDeliveryStatus(String location) {
        this.location = location;
    }

    @Override
    public String getStatus() {
        return "Заказ в доставке в " + location;
    }

    @Override
    public void changeStatus(Order order, String... location) {
        if (location.length == 0)
            order.setStatus(new OrderGettingStatus());
        else
            order.setStatus(new OrderDeliveryStatus(location[0]));
    }
}
