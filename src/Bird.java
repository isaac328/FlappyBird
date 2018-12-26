import processing.core.*;
public class Bird 
{
	PApplet p;
	float y;
	float x;
	float grav = 0.5f;
	float velocity = 0;
	float lift = -4;
	
	
	public Bird(PApplet p)
	{
		this.p = p;
		y = p.height/2;
		x = 100;
	}
	
	public void show()
	{
		p.fill(255);
		p.ellipse(x, y, 20, 20);
	}
	
	public void update()
	{
		velocity += grav;
		velocity*=0.9;
		y += velocity;
		
		if (y > p.height)
		{
			y = p.height;
		}
		
		if (y < 0)
		{
			y = 0;
		}
	}
	
	public void up()
	{
		this.velocity += lift;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getX()
	{
		return x;
	}
}
