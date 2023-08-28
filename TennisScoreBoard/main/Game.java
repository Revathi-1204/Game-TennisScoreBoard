package com.learning.hello.tennis;

import java.util.Scanner;

public class Game {

	Player p1 = new Player();
	Player p2 = new Player();

	public void reset() {
		p1.match=0;
		p1.score=0;
		p1.set=0;
		p2.match=0;
		p2.score=0;
		p2.set=0;
	}
	
	public void getGame() {

		if ((p1.getScore() >= 40 && p2.getScore() >= 40)) {
			if (p1.getScore() - p2.getScore() == 20) {
				gameOver1();

			}

			else if (p2.getScore() - p1.getScore() == 20) {

				gameOver2();

			}

		}

		else if (p1.getScore() > 40 && p2.getScore() <= 30) {

			gameOver1();

		}

		else if (p2.getScore() > 40 && p1.getScore() <= 30) {

			gameOver2();

		}
		System.out.println("game " + p1.score);
		System.out.println("match " + p1.match);
		System.out.println("set " + p1.set);
		System.out.println("game " + p2.score);
		System.out.println("match " + p2.match);
		System.out.println("set " + p2.set);
		
	}

	public void gameOver1() {
		p1.resetScore();
		p2.resetScore();
		p1.updateMatch();
		if ((p1.match >= 6 && (p1.match - p2.match) >= 2) || (p1.match == 7 && p2.match == 6)) {
			p1.updateSet();
			if (p1.set == 3) {
				p1.resetSet();
				p2.resetSet();

			}

			p1.resetMatch();
			p2.resetMatch();
		}
	}

	public void gameOver2() {
		p1.resetScore();
		p2.resetScore();
		p2.updateMatch();
		if ((p2.match >= 6 && (p2.match - p1.match) >= 2) || (p2.match == 7 && p1.match == 6)) {
			p2.updateSet();
			if (p2.set == 3) {
				p2.resetSet();
				p1.resetSet();
				
			}

			p2.resetMatch();
			p1.resetMatch();


		}
	}
	
	public void updateScore1() {
			p1.updateScore();
	}
		
	public void updateScore2() {
		p2.updateScore();
		}	
	
	
	
	public int getPlayer1Score() {
		return p1.score;
	}
	
	public int getPlayer2Score() {
		return p2.score;
	}
	
	public int getPlayer1Match() {
		return p1.match;
	}
	public int getPlayer2Match() {
		return p2.match;
	}
	public int getPlayer1Set() {
		return p1.set;
	}
	public int getPlayer2set() {
		return p2.set;
	}
	
	

	public static void main(String[] args) {
		Game g = new Game();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
		g.getGame();
	}

}
