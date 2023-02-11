package pl.project.trainingrecorder.alghoritms;

import java.time.LocalTime;

public class CaloriesBurned {
    public long calculateKcal(double avgTemp, LocalTime time, int weight) {
        long kcals;
        if ((long)time.getHour() == 0) {
            kcals =(long)time.getMinute();
        } else {
            kcals = (long)time.getHour() * 60 + (long)time.getMinute();
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
