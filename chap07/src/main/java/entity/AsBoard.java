package entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_AS_BOARD")
public class AsBoard extends Board{

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private AsCategory asCategory;

    public AsCategory getAsCategory() {
        return asCategory;
    }

    public void setAsCategory(AsCategory asCategory) {
        this.asCategory = asCategory;
    }
}
