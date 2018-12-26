 import java.util.ArrayList;
import processing.core.*;

public class FlappyBird extends PApplet
{
	Bird bird;
	ArrayList<Pipe> pipes;

	public static void main(String[] args) 
	{
		PApplet.main("FlappyBird");

	}
	
	public void settings()
	{
		size(400,600, P2D);
	}
	
	public void setup()
	{
		bird = new Bird(this);
		pipes = new ArrayList<Pipe>(2);
	}
	
	public void draw()
	{
		background(0);
		bird.show();
		bird.update();
		
		if(keyPressed)
		{
			bird.up();
		}
		
		if(frameCount % 100 == 0)
			pipes.add(new Pipe(this));
		
		for(int i = 0; i < pipes.size(); i++)
		{
			pipes.get(i).show();
			pipes.get(i).update();
			
			pipes.get(i).hits(bird);
			
			if(pipes.get(i).getX() < -20)
			{
				pipes.remove(i);
			}
		}
	}

}
