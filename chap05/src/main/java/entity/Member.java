package entity;

import javax.persistence.*;

@Entity
@Table(name = "C05_MEMBER")
public class Member {

    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String username;

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Member() {
        super();
    }

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
