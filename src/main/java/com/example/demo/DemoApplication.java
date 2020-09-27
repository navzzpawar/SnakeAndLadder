package com.example.demo;

import com.example.demo.SnakeAndLadder.Inputs;
import com.example.demo.SnakeAndLadder.PlayGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		int noOfSnakes = Integer.valueOf(args[0]);
		Map<Integer,Integer> headAndTailOfSnakes = new HashMap<>();
		Map<Integer,Integer> topAndBottomOfLadders = new HashMap<>();
		int noOfLadders = Integer.valueOf(args[noOfSnakes*2+1]);
		int noOfpersons = Integer.valueOf(args[(noOfLadders+noOfSnakes)*2+2]);
		Map<String,Integer> players = new HashMap<>();
		Inputs.prepareInputsFromCommandLineArgumentsAndPrint(args, noOfSnakes, headAndTailOfSnakes, topAndBottomOfLadders, noOfLadders, noOfpersons, players);
		System.out.println(PlayGame.startTheGame(players,headAndTailOfSnakes,topAndBottomOfLadders).getKey()+ " won the match! congratulations...");
		SpringApplication.run(DemoApplication.class, args);
	}
}
