package application.physics;

import java.awt.Point;
import java.awt.Rectangle;
import application.entities.Ball;
import application.entities.Brick;
import application.entities.Player;


public class Collision 
{
	private static int bX;
	private static int bY;
	private static int bR;
	
	
	
	private static boolean ballPaddle(Rectangle r, Point p)
	{
		return r.contains(p);
	}
	
	private boolean brickBall(Brick b, Point p)
	{
		return b.contains(p);
	}


	public void paddleBall(Player player, Ball ball) 
	{
		bX=ball.getX();
		bY= ball.getY();
		bR=ball.getR();
		
		if(ballPaddle(player.getTopL(), new Point(bX,bY+bR)))
				{
					ball.setDy(ball.getDy()* -1);
					ball.setDx(-2);
				}
		if(ballPaddle(player.getTopC(), new Point(bX,bY+bR)))
		{
			ball.setDy(ball.getDy()* -1);
			ball.setDx(0);
		}
		if(ballPaddle(player.getTopR(), new Point(bX,bY+bR)))
		{
			ball.setDy(ball.getDy()* -1);
			ball.setDx(2);
		}
		if(ballPaddle(player.getSideL(),new Point (bX+bR,bY)))
		{
			ball.setDx(ball.getDx()*-1);
		}
		if(ballPaddle(player.getSideR(), new Point(bX-bR,bY)))
		{
			ball.setDx(ball.getDx()*-1);
		}
		
	}


	public void ballBrick(Ball ball, Brick brick) 
	{
		// TODO Auto-generated method stub
		bX=ball.getX();
		bY= ball.getY();
		bR=ball.getR();	
		
		
		if(brickBall (brick, new Point(bX+bR,bY)) || brickBall(brick, new Point(bX-bR,bY)))
		{
			brick.setHealth(brick.getHealth()-1);
			ball.setDx(ball.getDx() * -1);
			
		}
		if(brickBall(brick,new Point (bX,bY-bR)) || brickBall( brick, new Point(bX,bY+bR)))
		{
			brick.setHealth(brick.getHealth() - 1);
			ball.setDy(ball.getDy() * -1);
		}
		
	}
}
