package pl.project.trainingrecorder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.TrainingDetails;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.service.TrainingService;
import pl.project.trainingrecorder.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DashboardController {
    private final UserService userService;
    private final TrainingService trainingService;
    public int trainingIndex;

    public DashboardController(UserService userService, TrainingService trainingService) {
        this.userService = userService;
        this.trainingService = trainingService;
    }

    @GetMapping("/app/dashboard")
    public String showApp(HttpServletResponse response,
                          Model model) {
        User loggedUser = userService.findByLogged();
        Cookie cookieName = new Cookie("cookieName", loggedUser.getUserName());
        response.addCookie(cookieName);

        model.addAttribute("numberOfTrainings", userService.loggedUserTrainingCount());
        model.addAttribute("numberOfBurnedCalories", userService.loggedUserBurnedCalories());

        List<Training> loggedUserTrainings = trainingService.trainingList(loggedUser);
        trainingIndex = loggedUserTrainings.size() - 1;
        Training showingTraining = loggedUserTrainings.get(trainingIndex);
        TrainingDetails showingTrainingDetails = loggedUserTrainings.get(trainingIndex).getTrainingDetails();

        model.addAttribute("nextIndex", trainingIndex += 1);
        model.addAttribute("previousIndex", trainingIndex -= 1);
        model.addAttribute("training", showingTraining);
        model.addAttribute("trainingDetail", showingTrainingDetails);


        return "dashboard";
    }
//    @GetMapping("/app/dashboard/{index}")
//    public String appWithSpecifyIndex(@PathVariable String index){
//
//    }
}
