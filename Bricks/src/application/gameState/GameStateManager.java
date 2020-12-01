package application.gameState;

import java.awt.Graphics;
import java.util.Stack;


public class GameStateManager 
{
	public static Stack <GameState> states;
	
	public GameStateManager()
	{
		states = new Stack<GameState>();
		states.push(new Level1State(this));
	}
	
	public void tick()
	{
		if(states.size() > 0 )
		{
		states.peek().tick();
		}
	}
	
	public void draw(Graphics g)
	{
		if(states.size() > 0 )
		{
		states.peek().draw(g);
		}
	}
	
	public void keyPressed(int k)
	{
		if(states.size() > 0 )
		{
		states.peek().keyPressed(k);
		}
		}
	
	public void keyReleased(int k)
	{
		if(states.size() > 0 )
		{
		states.peek().keyReleased(k);
		}
	}
}
