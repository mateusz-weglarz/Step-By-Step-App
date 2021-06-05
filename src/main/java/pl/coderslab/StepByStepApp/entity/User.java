package pl.coderslab.StepByStepApp.entity;

import org.hibernate.validator.constraints.Length;
import pl.coderslab.StepByStepApp.validators.ValidationPassword;
import pl.coderslab.StepByStepApp.validators.ValidationUserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 3, message = "Imię musi składać się przynajmniej z 3 liter", groups = ValidationUserDetails.class)
    @NotBlank(message = "Podaj imię", groups = ValidationUserDetails.class)
    private String firstName;
    @Length(min = 3, message = "Nazwisko musi składać się przynajmniej z 3 liter", groups = ValidationUserDetails.class)
    @NotBlank(message = "Podaj nazwisko", groups = ValidationUserDetails.class)
    private String lastName;
    @Column(nullable = false, unique = true, length = 60)
    @Length(min = 5, message = "Nazwa użytkownika musi składać się przynajmniej z 5 znaków", groups = ValidationUserDetails.class)
    @NotBlank(message = "Podaj nazwę użytkownika", groups = ValidationUserDetails.class)
    private String userName;
    @Column(nullable = false, unique = true, length = 60)
    @Email(message = "Podaj poprawny adres Email", groups = ValidationUserDetails.class)
    @NotBlank(message = "Podaj adres email", groups = ValidationUserDetails.class)
    private String email;
    @Length(min = 8, message = "Twoje hasło musi zawierać przynajmniej 8 znaków", groups = ValidationPassword.class)
    @NotBlank(message = "Podaj hasło", groups = ValidationPassword.class)
    private String password;
    private int globalNumberOfSteps;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean enabled;
    ;
    @OneToMany(mappedBy = "user")
    private List<Activity> activitiesList = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_groups")
    private List<Group> groupList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User() {
    }

    public User(Long id, String firstName, String lastName, String userName, String email, String password, int globalNumberOfSteps, LocalDateTime created, LocalDateTime updated, Boolean enabled, List<Activity> activitiesList, List<Group> groupList, Set<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.globalNumberOfSteps = globalNumberOfSteps;
        this.created = created;
        this.updated = updated;
        this.enabled = enabled;
        this.activitiesList = activitiesList;
        this.groupList = groupList;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGlobalNumberOfSteps() {
        return globalNumberOfSteps;
    }

    public void setGlobalNumberOfSteps(int globalNumberOfSteps) {
        this.globalNumberOfSteps = globalNumberOfSteps;
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

    public List<Activity> getActivitiesList() {
        return activitiesList;
    }

    public void setActivitiesList(List<Activity> activitiesList) {
        this.activitiesList = activitiesList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", globalNumberOfSteps=" + globalNumberOfSteps +
                ", created=" + created +
                ", updated=" + updated +
                ", enabled=" + enabled +
                ", activitiesList=" + activitiesList +
                ", groupList=" + groupList +
                ", roles=" + roles +
                '}';
    }
}
