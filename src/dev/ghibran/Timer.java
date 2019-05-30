package dev.ghibran;

public class Timer {
	
	private long timer,before;
	private boolean started = false;
	
	public Timer(){
		timer =0;
		before = System.nanoTime();
	}
	
	public void tick(){
		if(started)
			timer += System.nanoTime() - before;
		
		before = System.nanoTime();
	}
	
	public long getTime(){
		return timer / 100000000;
	}
	
	public void start(){
		started = true;
	}
	public void stop(){
		reset();
		started = false;
	}
	public void reset(){
		timer = 0;
	}
}
