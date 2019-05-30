package dev.ghibran.game.handler;

import java.util.List;

import dev.ghibran.game.objects.creature.Creature;

public class CollisionHandler<X extends Creature> extends Handler {

	
	List<X> list;
	Creature subject;
	
	public CollisionHandler(List<X> list,Creature subject){
		this.list = list;
		this.subject = subject;
	}
	@Override
	public void tick() {
		
		for(int i = 0; i <list.size();i++){
			if(list.get(i).getBounds().intersects(subject.getBounds()))

				subject.collision(list.get(i));
		}
	}

}
