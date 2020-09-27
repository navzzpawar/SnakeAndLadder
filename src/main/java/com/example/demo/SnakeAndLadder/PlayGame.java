package com.example.demo.SnakeAndLadder;

import java.util.*;

public class PlayGame {
    public static Map.Entry<String, Integer> startTheGame(Map<String, Integer> players, Map<Integer, Integer> headAndTailOfSnakes, Map<Integer, Integer> topAndBottomOfLadders) {
        List<Map.Entry<String,Integer>> list = new ArrayList<>(players.entrySet());
        Optional<Map.Entry<String,Integer>> optional = players.entrySet().stream().filter(item -> item.getValue().equals(100)).findFirst();
        if(optional.isPresent()){
            return (Map.Entry<String, Integer>) optional.get();
        }
        list.stream().forEach(item -> {
            int randomNo = getRandomNumber();
            int random = item.getValue() + randomNo;
            if(random <= 100){
                System.out.println(item.getKey()+" moves the dice and got "+randomNo+" and moved to "+random);
                item.setValue(random);
            }
            checkWhetherPlayerCaughtSnakeOrGotLadder(headAndTailOfSnakes, topAndBottomOfLadders, item, random);
        });
        return startTheGame(players,headAndTailOfSnakes,topAndBottomOfLadders);
    }

    private static void checkWhetherPlayerCaughtSnakeOrGotLadder(Map<Integer, Integer> headAndTailOfSnakes, Map<Integer, Integer> topAndBottomOfLadders, Map.Entry<String, Integer> item, int random) {
        if(headAndTailOfSnakes.get(random)!= null){
            System.out.println(item.getKey()+" caught by snake at "+random+" and went to "+headAndTailOfSnakes.get(random));
            item.setValue(headAndTailOfSnakes.get(random));
        } else if(topAndBottomOfLadders.get(random)!= null){
            System.out.println(item.getKey()+" got a ladder "+random+" and moved to "+topAndBottomOfLadders.get(random));
            item.setValue(topAndBottomOfLadders.get(random));
        }
    }

    private static int getRandomNumber() {
        return new Random().nextInt((6 - 1) + 1 ) + 1;
    }
}
