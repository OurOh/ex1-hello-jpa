package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team2 {

    @Id @GeneratedValue
    @Column(name = "TEAM_id")
    private Long id;
    private String name;

    //양방향 매핑을 가능하게 해준다.
    @OneToMany(mappedBy = "team")
    private List<Member2> members = new ArrayList<>();


    // 연관관계 메서드 . 어느쪽에서든 한쪽에서만 해야함.
    public void addMember(Member2 member) {
        member.setTeam(this);
        members.add(member);
    }


    public List<Member2> getMembers() {
        return members;
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
    }

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

}
