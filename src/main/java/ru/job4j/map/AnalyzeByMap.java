package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0.0;
        double score = 0.0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
        }
        result += score / count;
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> avgScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            String name = pupil.name();
            double score = 0.0;
            int subjectCount = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjectCount++;
            }
            double finalScore = score / subjectCount;
            avgScore.add(new Label(name, finalScore));
        }
        return avgScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldVal, newVal) -> oldVal + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = entry.getValue() / pupils.size();
            labels.add(new Label(entry.getKey(), score));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            String name = pupil.name();
            double score = 0.0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            labels.add(new Label(name, score));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldVal, newVal) -> oldVal + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = entry.getValue();
            labels.add(new Label(entry.getKey(), score));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}