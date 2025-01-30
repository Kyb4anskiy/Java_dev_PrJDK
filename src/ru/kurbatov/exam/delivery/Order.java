package ru.kurbatov.exam.delivery;

public class Order {

    private String name;
    private OrderStatus status;

    public Order(String name) {
        this.name = name;
        this.status = new OrderPlacedStatus();
    }

    protected void setStatus(OrderStatus status){
        this.status = status;
    }

    public String getStatus(){
        return status.getStatus();
    }

    public void changeStatus(String... location){
        status.changeStatus(this, location);
    }
}
