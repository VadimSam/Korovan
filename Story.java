package me.vadimsam;

import java.util.ArrayList;
import java.util.HashMap;

class Story {
    HashMap<String, Situation> situations = new HashMap<>();

    Story() {

        Situation temp;
        ArrayList<String> waysTemp;

        temp = new Situation();
        temp.description = "Welcome to this wonderful world, " + Player.Name + "!\n" +
                "You are standing in the middle of a forest edge!\n" +
                "1. Go to the elf's zone. \n" +
                "2. Go to the people's zone. \n" +
                "3. Go to the palace zone. \n" +
                "4. Go to the Evil's zone.";
        temp.deltaHP = 0;
        temp.deltaHunger = 0;
        temp.deltaMoney = 0;
        temp.deltaEHP = 0;
        waysTemp = new ArrayList<>();
        waysTemp.add("elf");
        waysTemp.add("people");
        waysTemp.add("palace");
        waysTemp.add("evil");
        temp.ways = waysTemp;
        situations.put("start", temp);

        temp = new Situation();
        temp.description = "Welcome to the elf forest! \n" +
                "Warning! Wooden houses, solders and Evil's minions are running over you! \n" +
                "They beat you up. \n" +
                "1. Go to the people's zone. \n" +
                "2. Go to the palace zone. \n" +
                "3. Go to the Evil's zone.";
        temp.deltaHP = -10;
        temp.deltaHunger = -10;
        temp.deltaMoney = 0;
        temp.deltaEHP = 0;
        waysTemp = new ArrayList<>();
        waysTemp.add("people");
        waysTemp.add("palace");
        waysTemp.add("evil");
        temp.ways = waysTemp;
        situations.put("elf", temp);

        temp = new Situation();
        temp.description = "Welcome to the village! \n" +
                "Here you can buy food and medicine. \n" +
                "1. Go to the palace zone. \n" +
                "2. Go to the elf's zone. \n" +
                "3. Go to the Evil's zone. \n" +
                "4. Buy food. \n" +
                "5. Buy medicine.";
        temp.deltaHP = -10;
        temp.deltaHunger = -20;
        temp.deltaMoney = 0;
        temp.deltaEHP = 0;
        waysTemp = new ArrayList<>();
        temp.ways = waysTemp;
        waysTemp.add("palace");
        waysTemp.add("elf");
        waysTemp.add("evil");
        waysTemp.add("food");
        waysTemp.add("first-aid-kit");
        situations.put("people", temp);

        temp = new Situation();
        temp.description = "You cured yourself! \n" + "1. Return to the people's zone.";
        temp.deltaHP = 100;
        temp.deltaHunger = 0;
        temp.deltaMoney = -10;
        temp.deltaEHP = 0;
        waysTemp = new ArrayList<>();
        temp.ways = waysTemp;
        waysTemp.add("people");
        situations.put("first-aid-kit", temp);

        temp = new Situation();
        temp.description = "You ate your food!\n" + "1. Return to the people's zone.";
        temp.deltaHP = 0;
        temp.deltaHunger = 100;
        temp.deltaMoney = -5;
        temp.deltaEHP = 0;
        waysTemp = new ArrayList<>();
        temp.ways = waysTemp;
        waysTemp.add("people");
        situations.put("food", temp);

        temp = new Situation();
        temp.description = "You have reached the Palace! \n" +
                "Solders is running over you! \n" +
                "You were beaten, fined, and asked not to disturb His Majesty! \n" +
                "1. Go to the elf's zone. \n" +
                "2. Go to the people's zone. \n" +
                "3. Go to the Evil's zone.";
        temp.deltaHP = -20;
        temp.deltaHunger = -5;
        temp.deltaMoney = -5;
        temp.deltaEHP = 0;
        waysTemp = new ArrayList<>();
        temp.ways = waysTemp;
        waysTemp.add("elf");
        waysTemp.add("people");
        waysTemp.add("evil");
        situations.put("palace", temp);

        temp = new Situation();
        temp.description = "You have reached fort in the mountains! \n" +
                "Evil's guard is running over you! \n" +
                "You were beaten, robbed, and told not to come here again! \n" +
                "1. Go to the elf's zone. \n" +
                "2. Go to the people's zone. \n" +
                "3. Go to the palace zone. \n" +
                "4. Gо against Evil.";
        temp.deltaHP = -30;
        temp.deltaHunger = -10;
        temp.deltaMoney = -10;
        temp.deltaHP = 0;
        waysTemp = new ArrayList<>();
        temp.ways = waysTemp;
        waysTemp.add("elf");
        waysTemp.add("people");
        waysTemp.add("palace");
        waysTemp.add("fight");
        situations.put("evil", temp);

        temp = new Situation();
        temp.description = "You are fighting against Evil.\n" +
                "1. Go to the people's zone. \n" +
                "2. Strike Evil.";
        temp.deltaHP = -30;
        temp.deltaHunger = -10;
        temp.deltaMoney = -10;
        temp.deltaEHP = -10;
        waysTemp = new ArrayList<>();
        temp.ways = waysTemp;
        waysTemp.add("people");
        waysTemp.add("fight");
        situations.put("fight", temp);

    }
}