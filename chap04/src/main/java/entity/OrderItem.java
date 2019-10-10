package entity;

import javax.persistence.*;

@Entity
@Table( name="ORDER_ITEM")
public class OrderItem {

    @Id @GeneratedValue
    @Column( name="ORDER_ITEM_ID")
    private long id;

    @Column(name="ITEM_ID")
    private Long itemId;
    @Column(name="ORDER_ID")
    private Long orderId;

    private int orderPrice; // 주문 가격
    private int count;      // 주문 수량

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
