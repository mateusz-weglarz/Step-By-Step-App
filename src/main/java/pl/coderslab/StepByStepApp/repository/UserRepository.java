package pl.coderslab.StepByStepApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.StepByStepApp.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=:email")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userName=:userName")
    Optional<User> findUserByUserName(String userName);

    @Query(value = "SELECT * FROM users ORDER BY created DESC limit 5", nativeQuery = true)
    List<User> findLastFiveNewUsers();

    @Query(value = "SELECT * FROM users ORDER BY global_number_of_steps DESC limit 5", nativeQuery = true)
    List<User> findTopFiveUsers();

    @Query("SELECT u FROM User u INNER JOIN u.groupList g where g.id=:id")
    List<User> findUsersByGroupId(@Param("id") long id);

}
