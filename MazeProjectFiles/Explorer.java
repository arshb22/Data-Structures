import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Polygon;

public class Explorer
{
	private Location loc;
	private int dir;
	private int size;
	private Color color;
	private boolean debug = true;
	private int numSteps;

	//constructor that sets loc, direction, size and color of explorer
	public Explorer(Location loc, int dir, int size, Color color)
	{
		this.loc = loc;
		this.dir = dir;
		this.size = size;
		this.color = color;
	}

	//returns color
	public Color getColor()
	{
		return color;
	}

	//returns location
	public Location getLoc()
	{
		return loc;
	}

	//returns direction
	public int getDir()
	{
		return dir;
	}

	//returns true if explorer at end
	public boolean atLocation(int r, int c)
	{
		return(r == loc.getR() && c == loc.getC());
	}

	//incriments steps every time keyispressed and it changes position
	public int getNumSteps()
	{
		return numSteps;
	}

	//called every time the explorer moves
	public void move(int key, char[][]maze)
	{
				//System.out.println(e.getKeyCode());
				//forward
				//gets location every time it moves for debug purposes
				int r = getLoc().getR();
				int c = getLoc().getC();
				if(debug) System.out.println("Move called ("+r+","+c+") dir = "+dir);
				if(key==38)
				{
					//0=up 1=right 2=down 3=left
					if(dir==0)
					{
						//changes r by one every time this button is pressed using setR and parsing -1
						//checks if it's not at top or is wall
						if(r>0 && maze[r-1][c]!='#')
						{
							getLoc().setR(-1);
							numSteps++;
						}
					}
					if(dir==1)
					{
						//changes c by one every time this button is pressed using setC and parsing +1
						//checks if it's not at end or is wall
						if(c<maze[r].length-1 && maze[r][c+1] !='#')
						{
							getLoc().setC(+1);
							numSteps++;
						}
					}
					if(dir==2)
					{
						//changes r by one every time this button is pressed using setR and parsing +1
						//checks if it's not at bottom or is wall
						if(r<maze.length-1 && maze[r+1][c] != '#')
						{
							getLoc().setR(+1);
							numSteps++;
						}
					}
					//changes c by one every time this button is pressed using setC and parsing -1
					//checks if it's not at front or is wall
					if(dir==3)
					{
						if(c>0 && maze[r][c-1] !='#')
						{
							getLoc().setC(-1);
							numSteps++;
						}
					}

				}
				//changes direction if right key is pressed and rotates it
				if(key==39) //rotate right
				{
					dir++;
					if(dir>3)
						dir=0;
				}
				//changes direction if left key is pressed and rotates it
				if(key==37)
				{
					dir--;
					if(dir<0)
						dir=3;
				}
				if(debug) System.out.println("After Move("+getLoc().getR()+","+getLoc().getR()+") dir = "+dir + " " + numSteps);
		//repaint();
	}

	//makes the explorer look like an arrow
	public Polygon getPoly(){
			int r=getLoc().getR();
			int c=getLoc().getC();
			Polygon arrowHead = new Polygon();
			//checks direction and sets it based on size
			if (dir == 0){
				arrowHead.addPoint( c*size+size,r*size+2*size);
				arrowHead.addPoint( (int)(c*size+size*1.5), (r*size+size));
				arrowHead.addPoint( c*size+size*2,r*size+size*2);
			}
			if (dir == 1 ){
				arrowHead.addPoint( c*size+size,r*size+size);
				arrowHead.addPoint( c*size+size*2, (int)(r*size+size*1.5));
				arrowHead.addPoint( c*size+size,r*size+size*2);
			}
			if (dir == 2 ){
				arrowHead.addPoint( c*size+size,r*size+size);
				arrowHead.addPoint( (int)(c*size+size*1.5), (r*size+size*2));
				arrowHead.addPoint( c*size+2*size,r*size+size);
			}
			if (dir == 3 ){
				arrowHead.addPoint( c*size+2*size,r*size+size);
				arrowHead.addPoint( c*size+size, (int)(r*size+size*1.5));
				arrowHead.addPoint( c*size+2*size,r*size+2*size);
			}
			return arrowHead;
	}
}