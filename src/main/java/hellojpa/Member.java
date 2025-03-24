package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    //@Column(name = "TEAM_ID")
    //private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY) // 다 대 일
    @JoinColumn(name = "TEAM_ID") // 외래키가 있는 연관관계 주인
    private Team team; // 요거와 mappedBy


    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }


    public void setTeam(Team team) {
        this.team = team;
    }

}
