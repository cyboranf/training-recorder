package pl.project.trainingrecorder.alghoritms;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class AvgRunningPace {
    public double avgTemp(LocalTime time, int km) {
        DecimalFormat df = new DecimalFormat("##.##");
        if (time.getHour() == 0) {
            double timeOfRun = (((double) time.getSecond() + ((double) time.getMinute() * 60.0))); //in seconds
            double meters = km * 1000;
            double avgSpeed = meters / timeOfRun;           //m/s

            return convert2kmh(avgSpeed);
        } else {
            double timeOfRun = ((double) time.getHour() * 3600.0) + (((double) time.getSecond() + ((double) time.getMinute() * 60.0))); //in seconds
            double meters = km * 1000.0;
            double avgSpeed = meters / timeOfRun;            //m/s


            return convert2kmh(avgSpeed);
        }
    }

    public double convert2kmh(double MonS) {
        DecimalFormat df = new DecimalFormat("##.##");
        double kmh = MonS * 3.6;
        double returnedKmh = Double.parseDouble(df.format((long) kmh));
        return returnedKmh;
    }
}
