package edu.hillel.lesson5.Competitions;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.round;

public class Main {
    private final static double MIN_RUN_THRESHOLD=3;
    private final static double MAX_RUN_THRESHOLD=7;
    private final static double MIN_RUN_BARRIER_THRESHOLD=2;
    private final static double MAX_RUN_BARRIER_THRESHOLD=6;

    private final static double MIN_JUMP_THRESHOLD=1;
    private final static double MAX_JUMP_THRESHOLD=2.2;
    private final static double MIN_JUMP_BARRIER_THRESHOLD=1;
    private final static double MAX_JUMP_BARRIER_THRESHOLD=2.1;

    private static double getRandomRunThreshold(){
        Random r = new Random();
        return Math.round(100*(MIN_RUN_THRESHOLD + (MAX_RUN_THRESHOLD - MIN_RUN_THRESHOLD) * r.nextDouble()))/100.00;
    }
    private static double getRandomRunBarrierThreshold(){
        Random r = new Random();
        return Math.round(100*(MIN_RUN_BARRIER_THRESHOLD + (MAX_RUN_BARRIER_THRESHOLD - MIN_RUN_BARRIER_THRESHOLD) * r.nextDouble()))/100.00;
    }
    private static double getRandomJumpThreshold(){
        Random r = new Random();
        return Math.round(100*(MIN_JUMP_THRESHOLD + (MAX_JUMP_THRESHOLD - MIN_JUMP_THRESHOLD) * r.nextDouble()))/100.00;
    }
    private static double getRandomJumpBarrierThreshold(){
        Random r = new Random();
        return Math.round(100*(MIN_JUMP_BARRIER_THRESHOLD + (MAX_JUMP_BARRIER_THRESHOLD - MIN_JUMP_BARRIER_THRESHOLD) * r.nextDouble()))/100.00;
    }

    public static void main(String[] args) {
        ArrayList<Participant> participants=new ArrayList<Participant>();
        Man man1=new Man(getRandomRunThreshold(),getRandomJumpThreshold());
        participants.add(man1);
        Man man2=new Man(getRandomRunThreshold(),getRandomJumpThreshold());
        participants.add(man2);

        Cat cat1=new Cat(getRandomRunThreshold(),getRandomJumpThreshold());
        participants.add(cat1);
        Cat cat2=new Cat(getRandomRunThreshold(),getRandomJumpThreshold());
        participants.add(cat2);

        Robot robot1=new Robot(getRandomRunThreshold(),getRandomJumpThreshold());
        participants.add(robot1);
        Robot robot2=new Robot(getRandomRunThreshold(),getRandomJumpThreshold());
        participants.add(robot2);


        ArrayList<Barrier> barriers=new ArrayList<Barrier>();
        RunningTrack runningTrack1=new RunningTrack(getRandomRunBarrierThreshold());
        barriers.add(runningTrack1);
        RunningTrack runningTrack2=new RunningTrack(getRandomRunBarrierThreshold());
        barriers.add(runningTrack2);

        Wall wall1=new Wall(getRandomJumpBarrierThreshold());
        barriers.add(wall1);
        Wall wall2=new Wall(getRandomJumpBarrierThreshold());
        barriers.add(wall2);

        int doneBarriers;
        for(Participant participant:participants){
            doneBarriers=0;
            for(Barrier barrier:barriers){
                if (barrier instanceof RunningTrack){
                    participant.run();
                    if (barrier.overcome(participant.getRunBarrierThreshold())){
                        ++doneBarriers;
                        System.out.println("Учасник "+participant+" пройшов перешкоду "+barrier+" довжиною "+((RunningTrack) barrier).getLength());
                    }
                    else{
                        System.out.println("Учасник "+participant+" не пройшов перешкоду "+barrier+" довжиною "+((RunningTrack) barrier).getLength()
                            +". Пройдено "+doneBarriers+" перешкод");
                        break;
                    }
                } else if (barrier instanceof Wall) {
                    participant.jump();
                    if (barrier.overcome(participant.getJumpBarrierThreshold())){
                        ++doneBarriers;
                        System.out.println("Учасник "+participant+" пройшов перешкоду "+barrier+" висотою "+((Wall) barrier).getHeight());
                    }
                    else{
                        System.out.println("Учасник "+participant+" не пройшов перешкоду "+barrier+" висотою "+((Wall) barrier).getHeight()
                                +". Пройдено "+doneBarriers+" перешкод");
                        break;
                    }

                }
            }
        }

    }
}
