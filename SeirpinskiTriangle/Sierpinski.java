import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// STARTER FOR STUDENTS
public class Sierpinski extends JPanel implements KeyListener
{
	JFrame frame;
	ArrayList<Point> points;
	int currX,currY;
  ArrayList<Point> values = new ArrayList<Point>();
	public Sierpinski()
	{
		frame=new JFrame("Sierpinski Triangle Simulator");
		frame.add(this);
		frame.setSize(1200,700);  // You can change size if you want
		// points=/* result of calling point generator method*;/

		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		/* Set Background Color you Wish */
		g.setColor(Color.BLACK);
    
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		// Print all points here
    for(int i = 0;i < values.size(); i++)
    {
      g.fillOval(values.get(i).x,values.get(i).y,2,2);
    }
	}

	public void addPoint()
	{
    
	}

  public void addThree()
  {
    values.add(new Point(1, 1, Color.WHITE));
    values.add(new Point(1, 1, Color.WHITE));
    values.add(new Point(1, 1, Color.WHITE));
  }

	public void keyPressed(KeyEvent e)
	{
		// Get a key to add 5 points at a time & speed process
		System.out.println(e.getKeyCode());
	}
	public void keyReleased(KeyEvent e)
	{
	}
	public void keyTyped(KeyEvent e)
	{
	}

	public static void main(String[] args)
	{
		Sierpinski app=new Sierpinski();
    app.addThree();
	}

	// Write a simple odered pair embedded class
	public class Point
	{
    int x,y;
    Color a;
    Point(int x, int y, Color a)
    {
      this.x = x;
      this.y = y;
      this.a = a;
    }
	}
}