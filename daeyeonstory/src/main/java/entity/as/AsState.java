package entity.as;

import javax.persistence.*;

@Entity
@Table(name = "TB_AS_STATE")
public class AsState {

    @Id @GeneratedValue
    @Column(name = "STATE_ID")
    private int stateId;
    private String name;


    public AsState(){
        super();
    }

    public AsState(String stateName) {
        this.name = stateName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AsState{" +
                "stateId=" + stateId +
                ", name='" + name + '\'' +
                '}';
    }
}
