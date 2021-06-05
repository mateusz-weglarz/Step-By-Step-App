package pl.coderslab.StepByStepApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.StepByStepApp.entity.Activity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    @Query(value = "SELECT * FROM activities a where user_id=:id ORDER BY a.created DESC", nativeQuery = true)
    List<Activity> findActivitiesByUserId(Long id);


    @Query(value = "SELECT * from activities a LEFT JOIN users u on u.id = a.user_id ORDER BY number_of_steps DESC LIMIT 5",nativeQuery = true)
    List<Activity> findTop5Activities();

    @Query(value = "select sum(a.numberOfSteps) from Activity a where a.user.id=:userId")
    Integer getTotalNumberOfSteps(Long userId);

}
