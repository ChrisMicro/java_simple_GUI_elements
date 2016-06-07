package gui_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Curve extends JPanel
{
	Color curveColor;
	int PointSize=3;
	boolean showPoints=true;
	
	Dimension drawPanelDimension;
	
	RingBuffer buffer;
	GraphScale xScale;
	GraphScale yScale;

	
	public Curve()
	{
		curveColor=Color.red;
		int dataSize=100;
		

		setDrawPanelDimension(new Dimension(100,100));
		/*
		double[] daten=new double[dataSize];
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/5);

		buffer=new RingBuffer(daten);*/
		buffer=new RingBuffer(100);
	}
	
	public void setDrawPanelDimension(Dimension d)
	{
		drawPanelDimension=d;
		xScale=new GraphScale();
		xScale.setLimits(0, 100, drawPanelDimension.getWidth());
		
		yScale=new GraphScale();
		yScale.setLimits(-1.5, 1.5, drawPanelDimension.getHeight());
	}
	
	public void setDrawPanelDimension(int x, int y)
	{
		setDrawPanelDimension(new Dimension(x,y));
	}
	
	public void addValue(double value)
	{
		buffer.add(value);
		xScale.setLimits(0, buffer.getFillSize(), drawPanelDimension.getWidth());
		repaint();
	}
	
	public int calcPosX(double x)
	{
		int result;
		
		//result=(int)(x);
		result=xScale.calculatePosition(x);
		return result;
	}
	
	public int calcPosY(double x)
	{
		int result;
		
		int yOffset=yScale.getAxisWidthInPixel();
		result=yOffset-yScale.calculatePosition(x);

		return result;
	}
	
	@Override 
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen
		g.setColor(curveColor);
		int dataSize=buffer.getFillSize();
		

		
		if(dataSize>1) // draw a graph
		{	
			for(int n=0;n<(dataSize-1);n++)
			{
				int p1x=calcPosX(n);
				int p1y=calcPosY(buffer.ringBufGetValue(n));
				int p2x=calcPosX((n+1));
				int p2y=calcPosY(buffer.ringBufGetValue(n+1));
				
				g.drawLine(p1x,p1y,p2x,p2y);
				if(showPoints)
				{
					if(n==0)g.drawRect(p1x-PointSize/2, p1y-PointSize/2, PointSize, PointSize);
					g.drawRect(p2x-PointSize/2, p2y-PointSize/2, PointSize, PointSize);
				}
			}
		}
		if(dataSize==1) // draw only a point
		{
			int p1x=calcPosX(0);
			int p1y=calcPosY(buffer.ringBufGetValue(0));

			g.drawRect(p1x-PointSize/2, p1y-PointSize/2, PointSize, PointSize);
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("curve plot");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Curve curve=new Curve();
		curve.setBounds(0,0,600,400);
		fenster.add(curve);
	

		fenster.add(curve);

		
		fenster.pack();
		fenster.setVisible(true);
		
		int dataSize=200;
		for(int n=0;n<dataSize;n++)
		{
			curve.addValue(Math.sin((double)n/5));
			int t_ms=20;
		    try 
		    {
		        Thread.sleep(t_ms);           
		    } catch(InterruptedException ex) 
		    {
		        Thread.currentThread().interrupt();
		    }
		}

	}

}
