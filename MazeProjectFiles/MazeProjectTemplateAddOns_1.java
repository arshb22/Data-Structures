import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class MazeProjectTemplateAddOns extends JPanel implements KeyListener
{
	private JFrame frame;
	private int col=0, row=0,dir = 0; //Location and direction of explorer
	private int size = 40;  		  //size of grid square in pixels
	private boolean debug = true;     //Set to true to print debug info
	private Location endLoc;		  //Finish line of maze
	private Location trapLoc;
	private Location portalLoc1;
	private Location keyLoc;
	private int numRows = 7, numCols=20; // set based on uploaded data
	private char[][] maze=new char[numRows][numCols];
	int stepCounter = 0;
	private boolean win = false;
	private boolean trap = false;
	private Explorer noob;
	private boolean is3D = false;
	private Location noobLocation;

	public MazeProjectTemplate()
	{
		setBoard();  //write this method to read board from file
		frame=new JFrame("A-Mazing Program");
		frame.setSize(1000,800);
		frame.add(this);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	public void paintComponent(Graphics g)
	{

		//Make Background Blank
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0,0,frame.getWidth(),frame.getHeight());

		//Error is line 358 (up) and 293 (down) at F
		//Error is line 350 (up) and 307 (down) at E

		if(is3D)
		{
			g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Comic Sans", Font.BOLD,20));
			g2.drawString("3D Maze! ",100,30);

			boolean end = false;
			boolean trap1 = false;
			boolean portal1 = false;
			boolean key1 = false;

			boolean stop = false;
			int dist1 = 0;
			int agh = 0;
			if(noob.getDir()==1)
			{
				do
				{
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()+agh] == ' ')
						dist1++;
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()+agh] == 'T')
					{
						dist1++;
						stop = true;
						trap1 = true;
					}
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()+agh] == 'P')
					{
						dist1++;
						stop = true;
						portal1 = true;
					}
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()+agh] == 'K')
					{
						dist1++;
						//stop = true;
						key1 = true;
					}
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()+agh] == '#')
						stop = true;
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()+agh] == 'F')
					{
						dist1++;
						stop = true;
						end = true;
					}
					agh++;
				}while(stop==false && noob.getLoc().getC()+agh <= maze[0].length);

				if(dist1>5)
					dist1 = 5;
			}

			if(noob.getDir()==2)
			{
				do
				{
					if(maze[noob.getLoc().getR()+agh][noob.getLoc().getC()] == ' ')
						dist1++;
					if(maze[noob.getLoc().getR()+agh][noob.getLoc().getC()] == 'T')
					{
						dist1++;
						stop = true;
						trap1 = true;
					}
					if(maze[noob.getLoc().getR()+agh][noob.getLoc().getC()] == 'P')
					{
						dist1++;
						stop = true;
						portal1 = true;
					}
					if(maze[noob.getLoc().getR()+agh][noob.getLoc().getC()] == 'K')
					{
						dist1++;
						//stop = true;
						key1 = true;
					}
					if(maze[noob.getLoc().getR()+agh][noob.getLoc().getC()] == '#')
						stop = true;
					if(maze[noob.getLoc().getR()+agh][noob.getLoc().getC()] == 'F')
					{
						dist1++;
						stop = true;
						end = true;
					}
					agh++;
				}while(stop==false && noob.getLoc().getR()+agh <= maze.length);

				if(dist1>5)
					dist1 = 5;
			}
			//need to make sure it doesn't do a check if it's on the edge
			if(noob.getDir()==3)
			{
				do
				{
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()-agh] == ' ')
						dist1++;
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()-agh] == 'T')
					{
						dist1++;
						stop = true;
						trap1 = true;
					}
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()-agh] == 'P')
					{
						dist1++;
						stop = true;
						portal1 = true;
					}
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()-agh] == 'K')
					{
						dist1++;
						//stop = true;
						key1 = true;
					}
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()-agh] == '#')
						stop = true;
					if(maze[noob.getLoc().getR()][noob.getLoc().getC()-agh] == 'F')
					{
						dist1++;
						stop = true;
						end = true;
					}
					agh++;
				}while(stop==false && noob.getLoc().getC()-agh >= 0);

				if(dist1>5)
					dist1 = 5;
			}
			if(noob.getDir()==0)
			{
				do
				{
					if(maze[noob.getLoc().getR()-agh][noob.getLoc().getC()] == ' ')
						dist1++;
					if(maze[noob.getLoc().getR()-agh][noob.getLoc().getC()] == 'T')
					{
						dist1++;
						stop = true;
						trap1 = true;
					}
					if(maze[noob.getLoc().getR()-agh][noob.getLoc().getC()] == 'P')
					{
						dist1++;
						stop = true;
						portal1 = true;
					}
					if(maze[noob.getLoc().getR()-agh][noob.getLoc().getC()] == 'K')
					{
						dist1++;
						//stop = true;
						key1 = true;
					}
					if(maze[noob.getLoc().getR()-agh][noob.getLoc().getC()] == '#')
						stop = true;
					if(maze[noob.getLoc().getR()-agh][noob.getLoc().getC()] == 'F')
					{
						dist1++;
						stop = true;
						end = true;
					}
					agh++;
				}while(stop==false && noob.getLoc().getR()-agh >=0);

				if(dist1>5)
					dist1 = 5;
			}
			//now you have to draw the wall


			for(int i = 0; i<dist1; i++)
			{
				System.out.println(dist1);
			//Left wall
			int[]xLocs = {100 + (i*50),150 + (i*50),150 + (i*50),100 + (i*50)};
			int[]yLocs = {100 + (i*50),150 + (i*50),650 - (i*50),700 - (i*50)};
			Polygon leftWall = new Polygon(xLocs, yLocs, xLocs.length);
			g2.setColor(Color.WHITE);
			g2.fill(leftWall);
			g2.setColor(Color.BLACK);
			g2.draw(leftWall);

			//Ceiling
			int[]xLocs1 = {100 + (i*50),150 + (i*50),650 - (i*50),700 - (i*50)};
			int[]yLocs1 = {100 + (i*50),150 + (i*50),150 + (i*50),100 + (i*50)};
			Polygon ceiling = new Polygon(xLocs1, yLocs1, xLocs1.length);
			g2.setColor(Color.WHITE);
			g2.fill(ceiling);
			g2.setColor(Color.BLACK);
			g2.draw(ceiling);


			//Right Wall
			int[]xLocs2 = {700 - (i*50),650 - (i*50),650 - (i*50),700 - (i*50)};
			int[]yLocs2 = {100 + (i*50),150 + (i*50),650 - (i*50),700 - (i*50)};
			Polygon rightWall = new Polygon(xLocs2, yLocs2, xLocs2.length);
			g2.setColor(Color.WHITE);
			g2.fill(rightWall);
			g2.setColor(Color.BLACK);
			g2.draw(rightWall);

			//Floor
			int[]xLocs3 = {100 + (i*50),150 + (i*50),650 - (i*50),700 - (i*50)};
			int[]yLocs3 = {700 - (i*50),650 - (i*50),650 - (i*50),700 - (i*50)};
			Polygon floor = new Polygon(xLocs3, yLocs3, xLocs3.length);
			g2.setColor(Color.WHITE);
			g2.fill(floor);
			g2.setColor(Color.BLACK);
			g2.draw(floor);

			//WALL LOGIC
			//distance of 4 - 4 on each side
				//dimensions
				if(dist1==4)
				{
					int[] xLocsT = {300,500,500,300};
					int[] yLocsT = {300,300,500,500};
					Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
					if(portal1)
					{
						g2.setColor(Color.BLUE);
					}
					if(trap1)
					{
						g2.setColor(Color.RED);
					}
					if(key1 && noob.getDir() == 3)
					{
						g2.setColor(Color.ORANGE);
					}
					if(key1 && noob.getDir()!=3)
					{
						g2.setColor(Color.WHITE);
					}
					if(end)
					{
						g2.setColor(Color.YELLOW);
					}
					else if(trap1!=true && portal1!=true && key1!=true)
					{
						g2.setColor(Color.WHITE);
					}
					g2.fill(rect);
					g2.setColor(Color.BLACK);
					g2.draw(rect);
				}

			//distance of 3 - 3 on each side
				//dimensions
				if(dist1==3)
				{
					int[] xLocsT = {250,550,550,250};
					int[] yLocsT = {250,250,550,550};
					Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
					if(portal1)
					{
						g2.setColor(Color.BLUE);
					}
					if(trap1)
					{
						g2.setColor(Color.RED);
					}
					if(key1 && noob.getDir() == 3)
					{
						g2.setColor(Color.ORANGE);
					}
					if(key1 && noob.getDir()!=3)
					{
						g2.setColor(Color.WHITE);
					}
					if(end)
					{
						g2.setColor(Color.YELLOW);
					}
					else if(trap1!=true && portal1!=true && key1!=true)
					{
						g2.setColor(Color.WHITE);
					}
					g2.fill(rect);
					g2.setColor(Color.BLACK);
					g2.draw(rect);
				}

			//distance of 2 - 2 on each side
				//dimensions
				if(dist1==2)
				{
					int[] xLocsT = {200,600,600,200};
					int[] yLocsT = {200,200,600,600};
					Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
					if(portal1)
					{
						g2.setColor(Color.BLUE);
					}
					if(trap1)
					{
						g2.setColor(Color.RED);
					}
					if(key1 && noob.getDir() == 3)
					{
						g2.setColor(Color.ORANGE);
					}
					if(key1 && noob.getDir()!=3)
					{
						g2.setColor(Color.WHITE);
					}
					if(end)
					{
						g2.setColor(Color.YELLOW);
					}

					else if(trap1!=true && portal1!=true && key1!=true)
					{
						g2.setColor(Color.WHITE);
					}

					g2.fill(rect);
					g2.setColor(Color.BLACK);
					g2.draw(rect);
				}

			//distance of 1 - 1 on each side
				//dimensions
				if(dist1==1)
				{
					int[] xLocsT = {150,650,650,150}; //150,650,150,650
					int[] yLocsT = {150,150,650,650}; //150,150,650,650
					Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
					if(portal1)
					{
						g2.setColor(Color.BLUE);
					}
					if(trap1)
					{
						g2.setColor(Color.RED);
					}
					if(key1 && noob.getDir() == 3)
					{
						g2.setColor(Color.ORANGE);
					}
					if(key1 && noob.getDir()!=3)
					{
						g2.setColor(Color.WHITE);
					}
					if(end)
					{
						g2.setColor(Color.YELLOW);
					}
					else if(trap1!=true && portal1!=true && key1!=true)
					{
						g2.setColor(Color.WHITE);
					}

					g2.fill(rect);
					g2.setColor(Color.BLACK);
					g2.draw(rect);
				}

			//Direction 1 (right)
			if(noob.getDir()==1)
			{
				if(noob.getLoc().getR()-1>=0)
					if(maze[noob.getLoc().getR()-1][noob.getLoc().getC()+i] == ' ' || maze[noob.getLoc().getR()-1][noob.getLoc().getC()+i] == 'T' || maze[noob.getLoc().getR()-1][noob.getLoc().getC()+i] == 'P')
					{
						int[] xLocsT = {100 + (i*50),150 + (i*50),150 + (i*50),100+(i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
				if(noob.getLoc().getR()+1<maze.length)
					if(maze[noob.getLoc().getR()+1][noob.getLoc().getC()+i] == ' ' || maze[noob.getLoc().getR()+1][noob.getLoc().getC()+i] == 'T' || maze[noob.getLoc().getR()+1][noob.getLoc().getC()+i] == 'P' || maze[noob.getLoc().getR()+1][noob.getLoc().getC()+i] == 'K')
					{
						int[] xLocsT = {700 - (i*50),650 - (i*50),650 - (i*50),700 - (i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
			}

			//Direction 2 (down)
			if(noob.getDir()==2)
			{
				//Open Passage
				if(noob.getLoc().getC()+1<maze[0].length)
					if(maze[noob.getLoc().getR()+i][noob.getLoc().getC()+1] == ' ' || maze[noob.getLoc().getR()+i][noob.getLoc().getC()+1] == 'T' || maze[noob.getLoc().getR()+i][noob.getLoc().getC()+1] == 'P' || maze[noob.getLoc().getR()+i][noob.getLoc().getC()+1] == 'K')
					{
						int[] xLocsT = {100 + (i*50),150 + (i*50),150 + (i*50),100+(i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
				if(noob.getLoc().getC()-1>=0)
					if(maze[noob.getLoc().getR()+i][noob.getLoc().getC()-1] == ' ' || maze[noob.getLoc().getR()+i][noob.getLoc().getC()-1] == 'T' || maze[noob.getLoc().getR()+i][noob.getLoc().getC()-1] == 'P' || maze[noob.getLoc().getR()+i][noob.getLoc().getC()-1] == 'K')
					{
						int[] xLocsT = {700 - (i*50),650 - (i*50),650 - (i*50),700 - (i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
			}

			//Direction 3 (left)
			if(noob.getDir()==3)
			{
				//Open Passage
				if(noob.getLoc().getR()+1<maze.length)
					if(maze[noob.getLoc().getR()+1][noob.getLoc().getC()-i] == ' ' || maze[noob.getLoc().getR()+1][noob.getLoc().getC()-i] == 'T' || maze[noob.getLoc().getR()+1][noob.getLoc().getC()-i] == 'P' || maze[noob.getLoc().getR()+1][noob.getLoc().getC()-i] == 'K')
					{
						int[] xLocsT = {100 + (i*50),150 + (i*50),150 + (i*50),100+(i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
				if(noob.getLoc().getR()-1>=0)
					if(maze[noob.getLoc().getR()-1][noob.getLoc().getC()-i] == ' ' || maze[noob.getLoc().getR()-1][noob.getLoc().getC()-i] == 'T' || maze[noob.getLoc().getR()-1][noob.getLoc().getC()-i] == 'P' || maze[noob.getLoc().getR()-1][noob.getLoc().getC()-i] == 'K')
					{
						int[] xLocsT = {700 - (i*50),650 - (i*50),650 - (i*50),700 - (i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
			}

			//Direction 0 (up)
			if(noob.getDir()==0)
			{
				//Open Passage
				if(noob.getLoc().getC()-1>=0)
					if(maze[noob.getLoc().getR()-i][noob.getLoc().getC()-1] == ' ' || maze[noob.getLoc().getR()-i][noob.getLoc().getC()-1] == 'T'|| maze[noob.getLoc().getR()-i][noob.getLoc().getC()-1] == 'P' || maze[noob.getLoc().getR()-i][noob.getLoc().getC()-1] == 'K')
					{
						int[] xLocsT = {100 + (i*50),150 + (i*50),150 + (i*50),100+(i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
				if(noob.getLoc().getC()+1<maze[0].length)
					if(maze[noob.getLoc().getR()-i][noob.getLoc().getC()+1] == ' ' || maze[noob.getLoc().getR()-i][noob.getLoc().getC()+1] == 'T' || maze[noob.getLoc().getR()-i][noob.getLoc().getC()+1] == 'P' || maze[noob.getLoc().getR()-i][noob.getLoc().getC()+1] == 'K')
					{
						int[] xLocsT = {700 - (i*50),650 - (i*50),650 - (i*50),700 - (i*50)};
						int[] yLocsT = {150 + (i*50),150 + (i*50),650 - (i*50),650 - (i*50)};
						Polygon rect = new Polygon(xLocsT, yLocsT, xLocsT.length);
						g2.setColor(Color.GRAY);
						g2.fill(rect);
						g2.setColor(Color.BLACK);
						g2.draw(rect);
					}
			}

			}//above for loop

		//this ends the is3D check
		}else
		{
				// DRAW MAZE
				g2.setColor(Color.GRAY);
				for(int c=0;c<maze[0].length;c++)
				for(int r=0;r<maze.length;r++){
					if (noob != null && noob.atLocation(r,c))
					{
									//EXPLORER
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(noob.getColor());
						g2.fill(noob.getPoly());
						g2.setColor(Color.GRAY);
					}
					/*
					if (noob.atLocation(r,c))
					{
						//EXPLORER
						g2.setColor(noob.getColor());
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(Color.GRAY);
					}
					*/
					else if (maze[r][c] == 'F'){
						//SET FINISH OR GOAL SQUARE
						g2.setColor(Color.YELLOW);
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(Color.GRAY);
					}
					else if(maze[r][c] == 'T')
					{
						g2.setColor(Color.RED);
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(Color.GRAY);
					}
					else if(maze[r][c] == 'P')
					{
						g2.setColor(Color.BLUE);
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(Color.GRAY);
					}
					else if(maze[r][c] == 'K')
					{
						g2.setColor(Color.ORANGE);
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(Color.GRAY);
					}
					else if(maze[r][c]==' ') // OPEN SQUARE GRAY
						g2.fillRect(c*size+size,r*size+size,size,size);
					else // BLOCKED SQUARE GRAY OUTLINE
						g2.drawRect(c*size+size,r*size+size,size,size);
		}
		}

		if (debug){ // PRINT EXTRA INFO TO HELP DEBUG
			if(is3D==false)
			{
			g2.setColor(Color.YELLOW);
			g2.drawString("Direction = " + noob.getDir(),40, numRows*size+2*size);
			g2.setColor(Color.GRAY);
			g2.drawString("Number of Steps = " + noob.getNumSteps(),40, numRows*size+3*size);
		    }
		}
		if(trap)
		{
			if(is3D==false)
			{
				g2.setColor(Color.CYAN);
				g2.drawString("Trapped!",40, numRows*size+4*size);
				g2.setColor(Color.GRAY);
			}
			if(is3D==true)
			{
				g2.setColor(Color.GREEN);
				g2.drawString("Trapped!",800, numRows*size+4*size);
				g2.setColor(Color.GRAY);
			}
		}
		if(win)
		{
			if(is3D==false)
			{
				g2.setColor(Color.CYAN);
				g2.drawString("YOU WON!",40, numRows*size+4*size);
				g2.setColor(Color.GRAY);
			}
			if(is3D==true)
			{
				g2.setColor(Color.GREEN);
				g2.drawString("YOU WON!",800, numRows*size+4*size);
				g2.setColor(Color.GRAY);
			}
		}
	}
	public void keyPressed(KeyEvent e)
	{
		if(win == false && trap == false)
		{
			noob.move(e.getKeyCode(),maze);
		}

		if(e.getKeyCode() == 32)
		{
			is3D = !is3D;
		}
		if(endLoc.equals(noob.getLoc()))
			win = true;
		if(trapLoc.equals(noob.getLoc()))
			trap = true;
		if(portalLoc1.equals(noob.getLoc()))
		{
			noob.getLoc().putR(2);
			noob.getLoc().putC(16);
		}
		if(keyLoc.equals(noob.getLoc()))
		{
			maze[2][13] = ' ';
		}
		repaint();

	}
	public void keyReleased(KeyEvent e) //Required for interface, leave empty
	{
	}
	public void keyTyped(KeyEvent e) // Required for interface, leave open
	{
	}

	public void setBoard()
	{
		// Read maze from file and set to maze 2d array
		maze[0][0] = 'E';
		maze[0][1] = ' ';
		maze[0][2] = ' ';

		File name = new File("maze2.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			int r = 0;
			while((text=input.readLine())!=null)
			{
				char[] x = text.toCharArray();
				for(int c = 0; c<x.length;c++)
				{
					maze[r][c] = x[c];
					System.out.println(r+","+c);
					if(text.charAt(c) == 'E')
					{
						noob = new Explorer(new Location(r,c),1,size,Color.RED);
						noobLocation = new Location(r,c);
						maze[r][c] = ' ';
						//System.out.println("IMPORTANT: " + r + " " + c);
					}
					if(text.charAt(c) == 'F')
					{
						endLoc = new Location(r,c);
					}
					if(text.charAt(c) == 'T')
					{
						trapLoc = new Location(r,c);
					}
					if(text.charAt(c) == 'P')
					{
						portalLoc1 = new Location(r,c);
					}
					if(text.charAt(c) == 'K')
					{
						keyLoc = new Location(r,c);
					}
				}
				r++;
			}
		} catch(IOException io)
		{
			System.err.println("File does not exist");
		}

	}

	public static void main(String[] args)
	{
		new MazeProjectTemplate();
	}
}