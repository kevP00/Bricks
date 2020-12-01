package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import application.gameState.GameStateManager;


public class GamePanel extends JPanel implements Runnable, KeyListener
{
	private static final long serialVersionUID = 1L;
	public static int WIDTH=800;//400
	public static int HEIGHT=600;//300
	private Thread thread;
	private boolean isRunning=false;
	private int FPS= 60;
	private long targetTime =1000/FPS;
	private long currentFPS;
	private GameStateManager gsm;
	
	
	public GamePanel()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		addKeyListener(this);
		setFocusable(true);
		start();
	}
	
	private void start()
	{
		isRunning=true;
		thread=new Thread(this);
		thread.start();
	}
	
	public void init()
	{
		gsm= new GameStateManager();
	}
	
	public void run()
	{
		init();
		long start;
		long elapsed;
		long wait;
		
		while(isRunning)
		{
			start=System.nanoTime();
			tick();
			repaint();
			elapsed= System.nanoTime() - start;
			wait= targetTime -elapsed / 1000000;
			
			if(wait< 0)
			{
				wait=16;
			}
			
			currentFPS= 1000/wait;
			
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void tick()
	{
		gsm.tick();
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.drawString("FPS: " + currentFPS, 2 , 10);
		gsm.draw(g);
	}
	

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		gsm.keyPressed(k);
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		gsm.keyReleased(k);
	}
	
	
}
