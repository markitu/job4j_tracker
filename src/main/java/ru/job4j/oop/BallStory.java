package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        System.out.println("Повстречал колобок зайца и ...");
        hare.tryEat(ball);
        System.out.println("Повстречал колобок волка и ...");
        wolf.tryEat(ball);
        System.out.println("Повстречал колобок лиу и ...");
        fox.tryEat(ball);
    }
}