package application.gameState;

import java.awt.Graphics;
import java.util.ArrayList;

import application.GamePanel;
import application.entities.Ball;
import application.entities.Brick;
import application.entities.Player;
import application.physics.Collision;


public class Level1State extends GameState
{
	
	private int[][]ids;
		
	
	public Level1State(GameStateManager gsm) {
		super(gsm);

	}

	private Player player;
	private Ball ball;
	private ArrayList<Brick> bricks;
	
	private Collision collision;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		player=new Player();
		ball=new Ball(GamePanel.WIDTH/2-5,GamePanel.HEIGHT/2-5,5);
		bricks= new ArrayList<Brick>();
		
		ids= new int [10][14];
		for(int i=0; i < ids.length; i++)
		{
			for(int j=0; j < ids[0].length; j++)
			{
				if(i <= 1)
				{
					ids[i][j]= 4;
				}
				if(i <= 3 && i >= 2)
				{
					ids[i][j]= 3;
				}
				if(i <= 5 && i >= 4)
				{
					ids[i][j]= 2;
				}
				if(i <= 7 && i >= 6)
				{
					ids[i][j]= 1;
				}
			}
		}
		
		
		for(int i=0; i < ids.length; i++)
		{
			for(int j=0; j < ids[0].length; j++)
			{
				bricks.add(new Brick( j * 55 + 10, i * 15 + 10, ids[i][j]));
			}
		}
		
		
		collision=new Collision();

		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		ball.tick();
		
		
		collision.paddleBall(player,ball);
		for(int i=0; i<bricks.size(); i++)
		{
			collision.ballBrick(ball, bricks.get(i));
			if(bricks.get(i).getHealth() <= 0)
			{
				bricks.remove(i);
				i--;
			}
		}
		
	}
	@Override
	public void draw(Graphics g) {
		player.draw(g);
		ball.draw(g);
		
		for(int i=0; i<bricks.size(); i++)
		{
			bricks.get(i).draw(g);
		}

		
	}
	@Override
	public void keyPressed(int k) {
		player.keyPressed(k);
		
	}
	@Override
	public void keyReleased(int k) {
		player.keyReleased(k);
		
	}
}