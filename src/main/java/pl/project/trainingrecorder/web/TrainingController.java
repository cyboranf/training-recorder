package pl.project.trainingrecorder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/app/training/list")
    public String showTrainingListJSP(Model model) {
        User loggedUser = userService.findByLogged();
        List<Training> trainingList = trainingService.trainingList(loggedUser);

        model.addAttribute("trainingList", trainingList);

        return "appTrainingList";
    }

    @GetMapping("/app/training/add")
    public String showAddTrainingJSP() {
        return "appRunningAdd";
    }

    @GetMapping("/app/trainings/add")
    public String saveTraining(@RequestParam String date,
                               @RequestParam String description,
                               @RequestParam String kilometers,
                               @RequestParam String hours,
                               @RequestParam String minutes,
                               @RequestParam String seconds,
                               @RequestParam String height,
                               @RequestParam String weight) {
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

        //Calculate Section
        CaloriesBurned caloriesBurned = new CaloriesBurned();
        AvgRunningPace avgRunningPace = new AvgRunningPace();

        int userWeight = Integer.parseInt(weight);
        int km = Integer.parseInt(kilometers);

        double temp = avgRunningPace.avgTemp(time, km);
        long calories = caloriesBurned.calculateKcal(temp, time, userWeight);
        //Calculate Section
        trainingDetails.setTemp(temp);
        trainingDetails.setKcal(calories);
        trainingDetails.setKilometers(km);

        training.setTrainingDetails(trainingDetails);
        training.setUser(loggedUser);

        trainingDetailsService.save(trainingDetails);
        trainingService.save(training);
        List<Training> trainingList = loggedUser.getTrainingList();
        trainingList.add(training);
        loggedUser.setTrainingList(trainingList);

        userService.save(loggedUser);
        return "redirect:/app/dashboard";
    }


    @GetMapping("/app/training/details")
    public String showTrainingDetails(@RequestParam(name = "id") String id,
                                      Model model) {
        int trainingId = Integer.parseInt(id);
        User loggedUser = userService.findByLogged();
        List<Training> trainingList = trainingService.trainingList(loggedUser);
        TrainingDetails trainingDetails = trainingService.findById(trainingId).getTrainingDetails();

        model.addAttribute("trainingDetail", trainingDetails);

        return "appTrainingDetails";
    }

    @GetMapping("/app/training/listD")
    public String showTrainingsToSeeDetails(Model model) {
        User loggedUser = userService.findByLogged();
        List<Training> trainingList = trainingService.trainingList(loggedUser);

        model.addAttribute("trainingList", trainingList);

        return "appTrainingListD";
    }

    @GetMapping("/app/training/detailsD")
    public String showAnotherViewOfDetails(@RequestParam(name = "id") String id,
                                           Model model) {
        int runningId = Integer.parseInt(id);
        User loggedUser = userService.findByLogged();
        List<Training> trainingList = trainingService.trainingList(loggedUser);
        TrainingDetails trainingDetails = trainingService.findById(runningId).getTrainingDetails();


        model.addAttribute("trainingDetail", trainingDetails);

        return "appTrainingDetailsD";
    }

    @GetMapping("/app/training/listE")
    public String showTrainingsToEdit(Model model) {
        User loggedUser = userService.findByLogged();
        List<Training> trainingList = trainingService.trainingList(loggedUser);

        model.addAttribute("trainingList", trainingList);

        return "appTrainingListE";
    }

    @GetMapping("/app/training/edit")
    public String showEditJSP(@RequestParam(name = "id") String id,
                              Model model) {
        identity = Long.parseLong(id);
        int runningId = Integer.parseInt(id);
        User loggedUser = userService.findByLogged();
        List<Training> trainingList = trainingService.trainingList(loggedUser);

        TrainingDetails trainingDetails = trainingService.findById(identity).getTrainingDetails();
        Training training = trainingService.findById(identity);

        model.addAttribute("training", training);
        model.addAttribute("trainingDetail", trainingDetails);

        LocalTime time = training.getTrainingTime();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int seconds = time.getSecond();

        model.addAttribute("hours", hours);
        model.addAttribute("minutes", minutes);
        model.addAttribute("seconds", seconds);
        model.addAttribute("from", training.getTrainingDay());

        return "appTrainingEdit";
    }

    public long identity;

    @GetMapping("/app/trainings/edit")
    public String editTraining(@RequestParam String date,
                               @RequestParam String description,
                               @RequestParam String kilometers,
                               @RequestParam String hours,
                               @RequestParam String minutes,
                               @RequestParam String seconds,
                               @RequestParam String height,
                               @RequestParam String weight) {
        User loggedUser = userService.findByLogged();
        Training training = trainingService.findById(identity);
        TrainingDetails trainingDetails = trainingDetailsService.findById(identity);

        LocalTime time = LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds));
        LocalDate rightDate = LocalDate.parse(date);

        training.setTrainingDay(rightDate);
        training.setDescription(description);
        training.setTrainingTime(time);

        trainingDetails.setHeight(Integer.parseInt(height));
        trainingDetails.setWeight(Integer.parseInt(weight));

        //Calculate Section
        CaloriesBurned caloriesBurned = new CaloriesBurned();
        AvgRunningPace avgRunningPace = new AvgRunningPace();

        int userWeight = Integer.parseInt(weight);
        int km = Integer.parseInt(kilometers);

        double temp = avgRunningPace.avgTemp(time, km);
        long calories = caloriesBurned.calculateKcal(temp, time, userWeight);
        //Calculate Section
        trainingDetails.setTemp(temp);
        trainingDetails.setKcal(calories);
        trainingDetails.setKilometers(km);

        training.setTrainingDetails(trainingDetails);

        trainingDetailsService.save(trainingDetails);
        trainingService.save(training);

        return "redirect:/app/training/list";
    }

    @GetMapping("/app/training/editE")
    public String showEditEJSP(@RequestParam(name = "id") String id,
                               Model model) {
        identity = Long.parseLong(id);
        int runningId = Integer.parseInt(id);
        User loggedUser = userService.findByLogged();
        List<Training> trainingList = trainingService.trainingList(loggedUser);

        TrainingDetails trainingDetails = trainingService.findById(identity).getTrainingDetails();
        Training training = trainingService.findById(identity);

        model.addAttribute("training", training);
        model.addAttribute("trainingDetail", trainingDetails);

        LocalTime time = training.getTrainingTime();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int seconds = time.getSecond();

        model.addAttribute("hours", hours);
        model.addAttribute("minutes", minutes);
        model.addAttribute("seconds", seconds);
        model.addAttribute("from", training.getTrainingDay());

        return "appTrainingEditE";
    }

    @GetMapping("/app/trainings/editE")
    public String editTrainingE(@RequestParam String date,
                                @RequestParam String description,
                                @RequestParam String kilometers,
                                @RequestParam String hours,
                                @RequestParam String minutes,
                                @RequestParam String seconds,
                                @RequestParam String height,
                                @RequestParam String weight) {
        User loggedUser = userService.findByLogged();
        Training training = trainingService.findById(identity);
        TrainingDetails trainingDetails = trainingDetailsService.findById(identity);

        LocalTime time = LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds));
        LocalDate rightDate = LocalDate.parse(date);

        training.setTrainingDay(rightDate);
        training.setDescription(description);
        training.setTrainingTime(time);

        trainingDetails.setHeight(Integer.parseInt(height));
        trainingDetails.setWeight(Integer.parseInt(weight));

        //Calculate Section
        CaloriesBurned caloriesBurned = new CaloriesBurned();
        AvgRunningPace avgRunningPace = new AvgRunningPace();

        int userWeight = Integer.parseInt(weight);
        int km = Integer.parseInt(kilometers);

        double temp = avgRunningPace.avgTemp(time, km);
        long calories = caloriesBurned.calculateKcal(temp, time, userWeight);
        //Calculate Section
        trainingDetails.setTemp(temp);
        trainingDetails.setKcal(calories);
        trainingDetails.setKilometers(km);

        training.setTrainingDetails(trainingDetails);

        trainingDetailsService.save(trainingDetails);
        trainingService.save(training);

        return "redirect:/app/training/listE";
    }

    @GetMapping("/app/training/delete")
    public String deleteTraining(@RequestParam(name = "id") String id) {
        long ID = Long.parseLong(id);
        User loggedUser = userService.findByLogged();
        Training training = trainingService.findById(ID);
        TrainingDetails trainingDetails = trainingDetailsService.findById(ID);

        List<Training> trainingList = loggedUser.getTrainingList();
        trainingList.remove(ID - 1);
        training.setTrainingDetails(null);
        trainingDetails.setTraining(null);
        training.setUser(null);

        trainingDetailsService.delete(trainingDetails);
        trainingService.delete(training);


        return "redirect:/app/training/list";
    }
}
