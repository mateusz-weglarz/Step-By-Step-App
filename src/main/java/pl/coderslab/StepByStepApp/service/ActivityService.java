package pl.coderslab.StepByStepApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.StepByStepApp.entity.Activity;
import pl.coderslab.StepByStepApp.repository.ActivityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
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
        Activity activity = activityRepository.findById(activityToUpdate.getId()).orElseThrow(()->new IllegalStateException("Taka aktywność nie istnieje"));
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId){
        boolean exists = activityRepository.existsById(activityId);
        if(!exists){
            throw new IllegalStateException("Taka aktywność nie istnieje");
        }
        activityRepository.deleteById(activityId);
    }
}
