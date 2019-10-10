package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TB_ORDER")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    long id;

    @Column(name="MEMBER_ID")
    private long memberId;

    @Temporal(TemporalType.TIMESTAMP)
    Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
