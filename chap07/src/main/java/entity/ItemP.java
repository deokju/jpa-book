package entity;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_P")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ItemP {

    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name; // 이름
    private int price;   // 가격

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemP{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
