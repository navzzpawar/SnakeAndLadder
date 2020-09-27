package com.example.demo.SnakeAndLadder;

import java.util.Map;

public class Inputs {
    public static void prepareInputsFromCommandLineArgumentsAndPrint(String[] args, int noOfSnakes, Map<Integer, Integer> headAndTailOfSnakes, Map<Integer, Integer> topAndBottomOfLadders, int noOfLadders, int noOfpersons, Map<String, Integer> players) {
        for (int i=1;i < noOfSnakes*2;i++){
            headAndTailOfSnakes.put(Integer.valueOf(args[i]),Integer.valueOf(args[i+1]));
            i++;
        }
        for (int i=noOfSnakes*2+2;i < (noOfSnakes+noOfLadders)*2+2;i++){
            topAndBottomOfLadders.put(Integer.valueOf(args[i]),Integer.valueOf(args[i+1]));
            i++;
        }
        for (int i=(noOfLadders+noOfSnakes)*2+3;i < (noOfLadders+noOfSnakes)*2+3+noOfpersons;i++){
            players.put(args[i],0);
        }
        System.out.println(noOfSnakes);
        System.out.println(headAndTailOfSnakes);
        System.out.println(noOfLadders);
        System.out.println(topAndBottomOfLadders);
        System.out.println(noOfpersons);
        System.out.println(players);
    }
}
