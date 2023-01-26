package entities;

import entities.nuns.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> orderList = new ArrayList<>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(){}

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public Order(Date moment){
        this.moment = moment;
    }

    public Date getMoment() {
        return moment;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void addItem(OrderItem item){
        this.orderList.add(item);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void removeItem(OrderItem item){
        this.orderList.remove(item);
    }

    public double total(){
        double sum = 0;
        for (OrderItem i: orderList) {
            sum+=i.subTotal();
        }
        return sum;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append(client + "\n");
        sb.append("Order items: " + "\n");
        for (OrderItem p: orderList) {
            sb.append(p + "\n");
        }
        sb.append("Total price: ");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}