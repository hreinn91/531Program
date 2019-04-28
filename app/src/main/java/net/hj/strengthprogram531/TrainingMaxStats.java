package net.hj.strengthprogram531;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class TrainingMaxStats {

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private class Stats{
        private double squat;
        private double benchPress;
        private double deadlift;
        private double overheadPress;
    }

    Stats maxStats;
    Stats trainingMaxStats;

    public TrainingMaxStats(double maxSquat, double maxBench, double maxDeadlift, double maxOverheadLift){
        this.maxStats = new Stats(maxSquat, maxBench, maxDeadlift, maxOverheadLift);
        this.trainingMaxStats = trainingMaxConvert(this.maxStats);
    }

    Stats trainingMaxConvert(Stats maxStats){
        return new Stats(maxStats.getSquat() * 0.9, maxStats.getBenchPress() * 0.9,
                maxStats.getDeadlift() * 0.9, maxStats.getOverheadPress());
    }

    public void increasetWeightsAfterCompletedCycle(){
        increaseWeightsAfterCompletedCycleUpperBody();
        this.trainingMaxStats.setDeadlift(this.trainingMaxStats.getDeadlift()+5);
        this.trainingMaxStats.setOverheadPress(this.trainingMaxStats.getOverheadPress()+5);
    }

    public void increaseWeightsAfterCompletedCycleUpperBody(){
        this.trainingMaxStats.setSquat(this.trainingMaxStats.getSquat()+2.5);
        this.trainingMaxStats.setBenchPress(this.trainingMaxStats.getBenchPress()+2.5);
    }



    public static void main(String[] args){
        double maxSquat = 110;
        double maxBench = 120;
        double maxDeadlift = 180;
        double maxOH = 60;
        TrainingMaxStats maxStats = new TrainingMaxStats(maxSquat, maxBench, maxDeadlift, maxOH);

        maxStats.increaseWeightsAfterCompletedCycleUpperBody();
        System.out.println(maxStats.toString());
    }
}
