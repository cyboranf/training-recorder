package pl.project.trainingrecorder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.project.trainingrecorder.alghoritms.AvgRunningPace;
import pl.project.trainingrecorder.alghoritms.CaloriesBurned;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.TrainingDetails;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.service.TrainingDetailsService;
import pl.project.trainingrecorder.service.TrainingService;
import pl.project.trainingrecorder.service.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class TrainingController {
    private final UserService userService;
    private final TrainingService trainingService;

    private final TrainingDetailsService trainingDetailsService;

    public TrainingController(UserService userService, TrainingService trainingService, TrainingDetailsService trainingDetailsService) {
        this.userService = userService;
        this.trainingService = trainingService;
        this.trainingDetailsService = trainingDetailsService;
    }

    @GetMapping("/app/training/add")
    public String showAddTrainingJSP() {
        return "appTrainingAdd";
    }


    @PostMapping("/app/trainings/add")
    public String addTraining(@RequestParam(name = "date") String date,
                              @RequestParam(name = "description") String description,
                              @RequestParam(name = "kilometers") String kilometers,
                              @RequestParam(name = "weight") String weight,
                              @RequestParam(name = "height") String height,
                              @RequestParam(name = "hours") String hours,
                              @RequestParam(name = "minutes") String minutes,
                              @RequestParam(name = "seconds") String seconds) {
        User loggedUser = userService.findByLogged();
        Training training = new Training();
        TrainingDetails trainingDetails = new TrainingDetails();

        LocalTime time = LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds));
        LocalDate rightDate = LocalDate.parse(date);

        training.setTrainingDay(rightDate);
        training.setDescription(description);
        training.setTrainingTime(time);

        trainingDetails.setHeight(Integer.parseInt(height));
        trainingDetails.setWeight(Integer.parseInt(weight));
        trainingDetails.setTemp(AvgRunningPace.avgTemp(time, Integer.parseInt(kilometers)));
        trainingDetails.setKcal(CaloriesBurned.calculateKcal(trainingDetails.getTemp(), time, Integer.parseInt(weight)));
        trainingDetails.setKilometers(Integer.parseInt(kilometers));


        training.setTrainingDetails(trainingDetails);

        trainingDetailsService.save(trainingDetails);
        trainingService.save(training);
        List<Training> trainingList = loggedUser.getTrainingList();
        trainingList.add(training);
        loggedUser.setTrainingList(trainingList);
        userService.save(loggedUser);
        return "redirect:/app/dashboard";
    }
}
