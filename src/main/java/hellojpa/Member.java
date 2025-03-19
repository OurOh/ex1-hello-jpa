package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // String 으로 작성해야함.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)   // Temporal 과거버전
    private Date lastModifiedDate;

    private LocalDate testLocalDate;

    @Lob // varchar 넘어서는 큰
    private String description;

    @Transient
    private int temp;


    //Getter, Setter…
}
