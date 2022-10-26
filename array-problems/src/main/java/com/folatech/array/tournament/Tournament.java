package com.folatech.array.tournament;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Reference: https://www.algoexpert.io/questions/tournament-winner
 * 
 * 
 * There's an algorithms tournament taking place in which teams of programmers
 * compete against each other to solve algorithmic problems as fast as possible.
 * Teams compete in a round robin, where each team faces off against all other
 * teams. Only two teams compete against each other at a time, and for each
 * competition, one team is designated the home team, while the other team is
 * the away team. In each competition there's always one winner and one loser;
 * there are no ties. A team receives 3 points if it wins and 0 points if it
 * loses. The winner of the tournament is the team that receives the most amount
 * of points.
 *
 *
 * Given an array of pairs representing the teams that have competed against
 * each other and an array containing the results of each competition, write a
 * function that returns the winner of the tournament. The input arrays are
 * named
 *
 * Sample Input = [ ["HTML", "C#"], ["C#", "Python"], ["Python", "HTML"], ], [0,
 * 0, 1]
 * 
 * Sample Output = "Python"
 * 
 * 
 * 
 */
public class Tournament {

	public static void main(String[] args) {
		List<List<String>> competitions = List.of(List.of("HTML", "C#"), List.of("C#", "Python"),
				List.of("Python", "HTML"));
		List<Integer> results = List.of(0, 0, 1);

		System.out.println("competitions: " + competitions);
		System.out.println("results: " + results);

		String winner = findWinner(competitions, results);

		System.out.println("winner: " + winner);
	}

	static String findWinner(List<List<String>> competitions, List<Integer> results) {

		Map<String, Integer> scoreBoard = new HashMap<>();

		for (int i = 0; i < competitions.size(); i++) {

			List<String> competition = competitions.get(i);

			/**
			 * flip here, 0 means 1 and 1 means 0
			 */
			int winnerIndex = results.get(i) == 0 ? 1 : 0;

			String winner = competition.get(winnerIndex);

			if (scoreBoard.get(winner) != null) {
				int score = scoreBoard.get(winner);
				score += 3;
				scoreBoard.put(winner, score);
			} else {
				scoreBoard.put(winner, 3);
			}

			System.out.println("winner: " + winner);

		}

		System.out.println("scoreBoard: " + scoreBoard);

		if (scoreBoard.isEmpty()) {
			return "";
		}
		
		
		// find the competitor with the highest score
		Map.Entry<String, Integer> winnerEntry = null;

		for (Map.Entry<String, Integer> competitor : scoreBoard.entrySet()) {
			if (winnerEntry == null || competitor.getValue().compareTo(winnerEntry.getValue()) > 0) {
				winnerEntry = competitor;
			}
		}

		return winnerEntry.getKey();

//		return scoreBoard.keySet().stream().max((entry1, entry2) -> scoreBoard.get(entry1) > scoreBoard.get(entry2) ? 1 : -1).get();

	}

}
