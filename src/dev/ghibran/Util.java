package dev.ghibran;

public class Util {
	
	
	public static float map(float val ,float start,float stop,float min,float max){
		return min +(max - min) * ((val-start)/(stop-start));
	}
	
	public static float restrict(float val,float min,float max){
		if(val <= min){
			return min;
		}
		else if(val >= max){
			return max;
		}
		return val;
		
	}
}
