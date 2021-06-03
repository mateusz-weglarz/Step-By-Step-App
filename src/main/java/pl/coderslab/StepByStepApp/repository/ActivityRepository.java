package pl.coderslab.StepByStepApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.StepByStepApp.entity.Activity;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    @Query(value = "SELECT * FROM activities a INNER JOIN users u where u.id=:id ORDER BY created DESC", nativeQuery = true)
    List<Activity> findActivitiesByUserId(Long id);

    @Query(value = "SELECT * FROM activities a INNER JOIN users u where u.id=:id ORDER BY created DESC limit 1", nativeQuery = true)
    Activity findLastActivityOfUserByUserId(Long id);

    @Query(value = "SELECT * from activities a ORDER BY numberOfSteps DESC LIMIT 5",nativeQuery = true)
    List<Activity> findTop5Activities();

}
