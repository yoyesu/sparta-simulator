package com.sparta.booleans.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.model.trainingCentre.TrainingCentre;

public class DTOGenerator {

    public static MappedDTO generateDTO(int month, ArrayList<Trainee> waitingList, ArrayList<TrainingCentre> trainingCentres) {

        HashMap<CourseType, Integer> traineesWaiting = getTraineeCountByCourse(waitingList);
        HashMap<CourseType, Integer> traineesTraining = getTraineesTraining(trainingCentres);

        HashMap<TrainingCentreType, Integer> openCentres = new HashMap<>();
        HashMap<TrainingCentreType, Integer> closedCentres = new HashMap<>();
        HashMap<TrainingCentreType, Integer> fullCentres = new HashMap<>();

        for (TrainingCentre centre: trainingCentres) {
            TrainingCentreType type;
            if (centre instanceof TechCentre) {
                type = TrainingCentreType.TECH_CENTRE;
            } else if (centre instanceof Bootcamp) {
                type = TrainingCentreType.BOOTCAMP;
            } else if (centre instanceof Hub) {
                type = TrainingCentreType.TRAINING_HUB;
            } else {
                type = TrainingCentreType.TRAINING_CENTRE;
            }

            incrementHashMap(openCentres, type);
            if (centre.isFull()) {
                incrementHashMap(fullCentres, type);
            }
            if (centre.isClosed()) {
                incrementHashMap(closedCentres, type);
            }
        }

        return new MappedDTO(month, traineesWaiting, traineesTraining, openCentres, closedCentres, fullCentres);
    }

    private static HashMap<CourseType, Integer> getTraineeCountByCourse(ArrayList<Trainee> trainees) {
        HashMap<CourseType, Integer> traineeMap = new HashMap<>();

        for (CourseType course: CourseType.values()) {
            long traineeCount = Stream.of(trainees)
                    .filter(e -> e.getCourseType() == course)
                    .count();
            traineeMap.put(course, (int) traineeCount);
        }

        return traineeMap;
    }

    private static HashMap<CourseType, Integer> getTraineesTraining(ArrayList<TrainingCentre> trainingCentres) {
        ArrayList<Trainee> trainees = new ArrayList<>();

        for (TrainingCentre centre: trainingCentres) {
            trainees.addAll(centre.getCurrentTrainees());
        }

        return getTraineeCountByCourse(trainees);
    }

    private static void incrementHashMap(HashMap<TrainingCentreType, Integer> hasMap, TrainingCentreType type) {
        Integer amount = hasMap.get(type);
        if (amount == null) {
            hasMap.put(type, 1);
        } else {
            hasMap.put(type, ++amount);
        }
    }
}
