package pl.coderslab.StepByStepApp.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.StepByStepApp.entity.Activity;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.repository.ActivityRepository;
import pl.coderslab.StepByStepApp.repository.UserRepository;
import pl.coderslab.StepByStepApp.web.CreateActivityController;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public List<Activity> findAllActivitiesForUser(Long userId) {
        return activityRepository.findActivitiesByUserId(userId);
    }

    public Activity findActivityById(Long activityId) {
        Optional<Activity> activityOptional = activityRepository.findById(activityId);
        if (activityOptional.isEmpty()) {
            throw new IllegalStateException("Taka aktywność nie istnieje");
        }
        return activityOptional.get();
    }

    public void updateActivity(Activity activityToUpdate) {
        Activity activity = activityRepository.findById(activityToUpdate.getId()).orElseThrow(() -> new IllegalStateException("Taka aktywność nie istnieje"));
        activity.setName(activityToUpdate.getName());
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId) {
        boolean exists = activityRepository.existsById(activityId);
        if (!exists) {
            throw new IllegalStateException("Taka aktywność nie istnieje");
        }
        activityRepository.deleteById(activityId);
    }

    public List<Activity> findTop5Activities() {
        return activityRepository.findTop5Activities();
    }

    public Activity createActivity(CreateActivityController.CreateActivityRequest request) {
        Activity activity = new Activity();
        activity.setUser(request.getUser());
        activity.setNumberOfSteps(request.getNumberOfSteps());
        activity.setName("Nowa aktywność " + LocalDateTime.now());
        return activityRepository.save(activity);

    }

    public Integer getTotalNumberOfSteps(Long userId) {
        return activityRepository.getTotalNumberOfSteps(userId);
    }

    public void removeActivitiesOfUser(User user) {
        List<Activity> activityList = findAllActivitiesForUser(user.getId());
        activityList.forEach(activity -> activityRepository.deleteById(activity.getId()));
    }
}
