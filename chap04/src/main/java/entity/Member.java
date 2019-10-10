package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MEMBER")
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    Long id;
    String name;
    String street;
    String zipcode;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
