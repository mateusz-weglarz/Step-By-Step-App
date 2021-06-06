package pl.coderslab.StepByStepApp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @Length(min = 5, message = "Nazwa grupy musi zawierać przynajmniej 5 znaków")
    @NotBlank
    private String name;
    @Length(min = 10,message = "Opis musi zawierać przynajmniej 10 znaków.")
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Integer goal;
    @ManyToMany(mappedBy = "groupList")
    private List<User> members = new ArrayList<>();
    private Long groupAdminId;


    public Group() {

    }

    public Group(Long id, String name, String description, LocalDateTime created, LocalDateTime updated, int goal, List<User> members, Long groupAdminId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.goal = goal;
        this.members = members;
        this.groupAdminId = groupAdminId;
    }

    public Group(String name, String description, LocalDateTime created, LocalDateTime updated, int goal, List<User> members, Long groupAdminId) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.goal = goal;
        this.members = members;
        this.groupAdminId = groupAdminId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public Long getGroupAdminId() {
        return groupAdminId;
    }

    public void setGroupAdminId(Long groupAdminId) {
        this.groupAdminId = groupAdminId;
    }

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }

}
