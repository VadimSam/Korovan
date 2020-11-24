package me.vadimsam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Situation {
    String description;
    Integer deltaHP, deltaHunger, deltaMoney, deltaEHP;
    ArrayList<String> ways;
}

class Player {
    static String Name;
    static Integer HP = ThreadLocalRandom.current().nextInt(1, 100),
            Hunger = ThreadLocalRandom.current().nextInt(1, 100),
            Money = ThreadLocalRandom.current().nextInt(1, 100),
            EHP = ThreadLocalRandom.current().nextInt(1, 100);

    static void deltaStats(Situation currentSituation) {
        HP += currentSituation.deltaHP;
        Hunger += currentSituation.deltaHunger;
        Money += currentSituation.deltaMoney;
        EHP += currentSituation.deltaEHP;
    }

    static void printStats(Situation currentSituation) {
        System.out.println(Player.Name + "'s HP: " + Player.HP
                + "\nEvil's HP: " + Player.EHP
                + "\n" + Player.Name + "'s Hunger: " + Player.Hunger
                + "\n" + Player.Name + "'s Money: " + Player.Money
                + '\n' + currentSituation.description);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Hero's name: ");
        Player.Name = in.next();
        Story story = new Story();
        String nameCurrentSituation = "start";
        Situation currentSituation = story.situations.get(nameCurrentSituation);

        do {
            Player.deltaStats(currentSituation);
            if (Player.EHP <= 0) {
                System.out.println(Player.Name + " have defeated the Evil!!! YOU WON!");
                return;
            }
            if (Player.HP <= 0) {
                System.out.println(Player.Name + " shamefully died in this world. GAME OVER!");
                return;
            }
            if (Player.Hunger <= 0) {
                System.out.println(Player.Name + " shamefully starved to death in this world. GAME OVER!");
                return;
            }
            boolean retry = false;
            while(!retry) {
                Player.printStats(currentSituation);
                try {
                    nameCurrentSituation = currentSituation.ways.get(in.nextInt() - 1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Choose another path!");
                    retry = true;
                }
                currentSituation = story.situations.get(nameCurrentSituation);
            }
        } while (currentSituation.ways.size() != 0);
        Player.deltaStats(currentSituation);
        Player.printStats(currentSituation);
    }

}
