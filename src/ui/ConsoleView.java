package ui;

import java.util.Observable;

import Game.NumberGame;

public class ConsoleView implements java.util.Observer {
	private NumberGame game;

	public ConsoleView(NumberGame game) {
		this.game = game;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(game.getCount());
	}


}
