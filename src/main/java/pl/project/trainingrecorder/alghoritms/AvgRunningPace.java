package pl.project.trainingrecorder.alghoritms;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class AvgRunningPace {
    public double avgTemp(LocalTime time, int km) {
        DecimalFormat df = new DecimalFormat("##.##");
        if (time.getHour() == 0) {
            double timeOfRun = ((time.getSecond() + (time.getMinute() * 60))); //in seconds
            int meters = km * 1000;
            double avgSpeed = meters / timeOfRun;           //m/s

            return convert2kmh(avgSpeed);
        } else {
            double timeOfRun = (time.getHour() * 3600) + ((time.getSecond() + (time.getMinute() * 60))); //in seconds
            int meters = km * 1000;
            double avgSpeed = meters / timeOfRun;            //m/s


            return convert2kmh(avgSpeed);
        }
    }

    public double convert2kmh(double MonS) {
        DecimalFormat df = new DecimalFormat("##.##");
        double kmh = MonS * 3.6;

        return Double.parseDouble(df.format(kmh));
    }
}
