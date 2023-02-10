package pl.project.trainingrecorder.alghoritms;

import java.time.LocalTime;

public class CaloriesBurned {
    public static long calculateKcal(double avgTemp, LocalTime time, int weight) {
        long kcals;
        if (time.getHour() == 0) {
            kcals = time.getMinute();
        } else {
            kcals = time.getHour() * 60 + time.getMinute();
        }
        if (avgTemp > 10) {
            kcals *= 2;
        }
        if (weight > 80) {
            kcals *= 2;
        }

        return kcals;
    }
}
