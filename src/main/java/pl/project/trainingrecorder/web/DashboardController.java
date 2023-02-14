package pl.project.trainingrecorder.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.project.trainingrecorder.alghoritms.IndexChanger;
import pl.project.trainingrecorder.domain.LoggedUser;
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
        if (loggedUserTrainings.size() != 0) {
            trainingIndex = loggedUserTrainings.size() - 1;
            Training showingTraining = loggedUserTrainings.get(trainingIndex);
            TrainingDetails showingTrainingDetails = loggedUserTrainings.get(trainingIndex).getTrainingDetails();

            model.addAttribute("nextIndex", trainingIndex + 1);
            model.addAttribute("previousIndex", trainingIndex - 1);
            model.addAttribute("training", showingTraining);
            model.addAttribute("trainingDetail", showingTrainingDetails);
        }


        return "dashboard";
    }

    @GetMapping("/app/dashboard/{previousIndex}")
    public String appWithSpecifyIndex(@PathVariable String previousIndex,
                                      HttpServletResponse response,
                                      Model model) {

        User loggedUser = userService.findByLogged();

        Cookie cookieName = new Cookie("cookieName", loggedUser.getUserName());
        response.addCookie(cookieName);

        model.addAttribute("numberOfTrainings", userService.loggedUserTrainingCount());
        model.addAttribute("numberOfBurnedCalories", userService.loggedUserBurnedCalories());

        List<Training> loggedUserTrainings = trainingService.trainingList(loggedUser);
        trainingIndex = Integer.parseInt(previousIndex);
        Training showingTraining = loggedUserTrainings.get(trainingIndex);
        TrainingDetails showingTrainingDetails = loggedUserTrainings.get(trainingIndex).getTrainingDetails();

        IndexChanger indexChanger = new IndexChanger();

        model.addAttribute("nextIndex", indexChanger.addToIndex(trainingIndex, loggedUserTrainings.size() - 1));
        model.addAttribute("previousIndex", indexChanger.minusFromIndex(trainingIndex));
        model.addAttribute("training", showingTraining);
        model.addAttribute("trainingDetail", showingTrainingDetails);


        return "dashboard2";

    }
}
