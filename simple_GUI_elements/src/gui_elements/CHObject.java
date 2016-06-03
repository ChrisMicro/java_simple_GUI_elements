package gui_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CHObject extends JPanel
{

	public JLabel labelText;
	public String name;

	static int next_xPosition=10;
	static int next_yPosition=10;
	
	int width=100;
	int heigth=25;
	
	int LayoutManagerLineDistance=5;
	
	public CHObject(String name)
	{
		labelText=new JLabel(name);
		//this.setBounds(next_xPosition,next_yPosition,width,heigth);
		setPosition(next_xPosition,next_yPosition);
	}
	
	public void setName(String name)
	{
		labelText.setText(name);
		
	}
	
	// minimalistic layout manager
	public void setPosition(int x, int y)
	{
		this.setBounds(x, y, width, heigth);
	}
	

	@Override 
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);

		next_yPosition=y+heigth+LayoutManagerLineDistance;	
		next_xPosition=x;
	}
	
	@Override 
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen
		//Dimension d=this.getSize();
		//Point p=this.getLocation();
		Rectangle r=this.getBounds();
	
		int thickness = 2;
		Graphics2D g2;
		g2=(Graphics2D) g;
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(thickness));
		
		g.drawRect(0,0,r.width,r.height);
		g2.setStroke(oldStroke);
	}
	
	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHObject value1=new CHObject("object");
		//value1.setPosition(100, 10);
		fenster.add(value1);
		
		CHObject value2=new CHObject("object2");
		//value1.setPosition(100, 10);
		fenster.add(value2);
		
		fenster.pack();
		fenster.setVisible(true);
		
	}
}
