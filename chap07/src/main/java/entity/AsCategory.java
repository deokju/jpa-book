package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_AS_CATEGORY")
public class AsCategory {

    @Id @GeneratedValue
    private long categoryId;
    private String categoryName;

    @OneToMany(mappedBy = "asCategory")
    private List<AsBoard> asBoards = new ArrayList<>();

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
