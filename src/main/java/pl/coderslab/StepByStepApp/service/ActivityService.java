package pl.coderslab.StepByStepApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.StepByStepApp.entity.Activity;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.repository.ActivityRepository;
import pl.coderslab.StepByStepApp.repository.UserRepository;

import javax.transaction.Transactional;
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

    public List<Activity> findAllActivitiesForUser(Long userId){
        return activityRepository.findActivitiesByUserId(userId);
    }

    public Activity findActivityById(Long activityId){
        Optional<Activity> activityOptional = activityRepository.findById(activityId);
        if(activityOptional.isEmpty()){
            throw new IllegalStateException("Taka aktywność nie istnieje");
        }
        return activityOptional.get();
    }

    public void updateActivity(Activity activityToUpdate){
        activityRepository.save(activityToUpdate);
    }

    public void deleteActivity(Long activityId){
        boolean exists = activityRepository.existsById(activityId);
        if(!exists){
            throw new IllegalStateException("Taka aktywność nie istnieje");
        }
        activityRepository.deleteById(activityId);
    }

    public List<Activity> findTop5Activities(){
        return  activityRepository.findTop5Activities();
    }
}
