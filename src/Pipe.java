import processing.core.*;

public class Pipe 
{
	PApplet p;
	float top;
	float bottom;
	float x;
	float width = 20;
	float speed = 5;
	boolean highlight = false;
	
	public Pipe(PApplet p)
	{
		this.p = p;
		top = p.random(0, p.height/2);
		bottom = p.random(0, p.height/2);
		x = p.width;
	}
	
	public void show()
	{
		p.fill(255);
		if(this.highlight)
			p.fill(255,0,0);
		p.rect(x, 0, width, top);
		p.rect(x, p.height, width, -bottom);
	}
	
	public void update()
	{
		x-=speed;
	}
	
	public boolean hits(Bird b)
	{
		if(b.getY() < top || b.getY() > p.height - bottom)
		{
			if(b.getX() < x+width && b.getX() > x)
			{
				highlight = true;
				p.fill(255,255,255);
			}
		}
		return false;
	}
	
	
	public float getX()
	{
		return x;
	}
	

}
