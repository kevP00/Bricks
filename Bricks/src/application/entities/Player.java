package application.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import application.GamePanel;

public class Player extends Rectangle
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean left= false, right=false;
	private int moveSpeed=4;
	private Rectangle topL, topC, topR;
	private Rectangle sideL,sideR;
	
	public Player()
	{
		setBounds(GamePanel.WIDTH/ 2- 90, GamePanel.HEIGHT - 30, 150,20);
		topL= new Rectangle(x,y-1,width/3,1);
		topC= new Rectangle(x + width/2,y -1, width/3,1);
		topR=new Rectangle(x + 2 * (width/3), y-1, width/3, 1);
		sideL= new Rectangle(x-1,y,1,height);
		sideR= new Rectangle(x+width,y,1,height);
	}
	
	public void tick()
	{
		if(x <= 0 )
		{
			left=false;
		}
		if(x + width >= GamePanel.WIDTH)
		{
			right=false;
		}
		if(left)
		{
			x -= moveSpeed;
		}
		if(right)
		{
			x+=moveSpeed;
		}
		calculateEdges();
	}
	
	private void calculateEdges()
	{
		topL.setBounds(x,y,width/3,1);
		topC.setBounds(x+width/3,y,width/3,1);
		topR.setBounds(x+2*(width/3),y,width/3,1);
		sideL.setBounds(x-1,y,1,height);
		sideR.setBounds(x+width, y, 1, height);
	}
	
	public void draw(Graphics g)
	{	
		
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.BLUE);
		g.fillRect(topL.x, topL.y, topL.width, topL.height);
		g.setColor(Color.CYAN);
		g.fillRect(topC.x, topC.y, topC.width, topC.height);
		g.setColor(Color.RED);
		g.fillRect(topR.x, topR.y, topR.width, topR.height);
		g.fillRect(sideL.x, sideL.y, sideL.width, sideL.height);
		g.fillRect(sideR.x, sideR.y, sideR.width, sideR.height); 
	}
	
	public void keyPressed(int k)
	{
		if(k == KeyEvent.VK_LEFT)
		{
			left=true;
			right=false;
		}
		if(k == KeyEvent.VK_RIGHT)
		{
			right=true;
			left=false;
		}
		
	}

	public Rectangle getTopL() {
		return topL;
	}

	public Rectangle getTopC() {
		return topC;
	}

	public Rectangle getTopR() {
		return topR;
	}

	public Rectangle getSideL() {
		return sideL;
	}

	public Rectangle getSideR() {
		return sideR;
	}

	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
