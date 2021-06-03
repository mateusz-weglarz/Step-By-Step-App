package pl.coderslab.StepByStepApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.StepByStepApp.entity.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    Optional<Group> findGroupByName(String name);

    @Query(value = "SELECT * FROM activity_groups INNER JOIN users u where u.id=:id ORDER BY created DESC", nativeQuery = true)
    List<Group> findGroupsByUserId(Long id);
}
