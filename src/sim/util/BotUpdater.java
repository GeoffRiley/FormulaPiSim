/**
* Copyright 2016 Tim Pearce
**/

package sim.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import sim.object.Bot;
import sim.object.LapTimer;

public class BotUpdater{

	protected Bot bot;
	protected Timer timer;
	protected LapTimer laptimer;
	
	
	public BotUpdater(Bot bot){
		this.bot = bot;
		this.laptimer = bot.laptimer;
	}

	public void start()
	{
		
		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bot.move();
				if (laptimer != null)
					laptimer.check();
				
				timer.restart();
			}
		});
		timer.start();
	}
	
	public void stop()
	{
		timer.stop();
	}
	
	
	
}
