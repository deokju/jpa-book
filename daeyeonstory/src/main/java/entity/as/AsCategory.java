package entity.as;


import javax.persistence.*;

@Entity
@Table(name = "TB_AS_CATEGORY")
public class AsCategory {

    public AsCategory(){
        super();
    }


    public AsCategory(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "AS_CATEGORY_ID")
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AsCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
