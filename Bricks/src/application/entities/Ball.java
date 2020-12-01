package application.entities;

import java.awt.Color;

import java.awt.Graphics;

import application.GamePanel;

public class Ball 
{
	private int x,y,r;
	private int dx,dy;
	
	
	public Ball(int x,int y,int r)
	{
		this.x=x;
		this.y=y;		//position
		this.r=r;
		dx=1;
		dy=1;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void tick()
	{
		if(x+r >= GamePanel.WIDTH || x-r <=0)
		{
			dx *= -1;
		}
		if(y-r<=0)
		{
			dy *= -1;
		}
		
		x+=dx;
		y+=dy;
	}
	
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(x-r, y-r, 2*r, 2*r);
	}
}
