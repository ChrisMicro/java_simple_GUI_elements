package gui_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Curve 
{
	Color   curveColor;
	int     PointSize  = 3;
	boolean showPoints = false;
	
	Dimension drawPanelDimension;
	
	RingBuffer buffer;
	GraphScale xScale;
	GraphScale yScale;
	
	Color [] colorArray={Color.BLUE,Color.RED,Color.green,Color.YELLOW};
	static int defaultColorIndex=0;
	
	public void setVisibleLinePoints(boolean showPoints)
	{
		this.showPoints=showPoints;
	}
	
	public Curve(int dataLength)
	{
		curveColor=colorArray[defaultColorIndex++];
		if(defaultColorIndex>=colorArray.length)defaultColorIndex=0;

		buffer=new RingBuffer(dataLength);
		xScale=new GraphScale();
		yScale=new GraphScale();

		setDimension(new Dimension(100,100));
		setScale_y(-1.5,1.5);
		xScale.setLimits(0, 100, drawPanelDimension.getWidth());
	}
	
	public Curve()
	{
		this(100);
	}
	
	public void setData(double [] data)
	{
		buffer.setData(data);
	}
	
	public void setData(int [] data)
	{
		buffer.setData(data);
	}
	
	public void clear()
	{
		buffer.clear();
	}
	
	public void setDimension(Dimension d)
	{
		drawPanelDimension=d;
		xScale.setLimits(0, buffer.getBufferSize(), drawPanelDimension.getWidth());
		yScale.setLimits(-0.1, 1, drawPanelDimension.getHeight());	
	}
	
	public void setDimension(int x, int y)
	{
		setDimension(new Dimension(x,y));
		//repaint();
	}

	public void setScale_x(double min, double max)
	{
		xScale.setLimits(min, max, drawPanelDimension.getWidth());
	}
	
	public void setScale_y(double min, double max)
	{
		yScale.setLimits(min, max, drawPanelDimension.getHeight());	
	}
	

	
	public void addValue(double value)
	{
		buffer.add(value);
		xScale.setLimits(0, buffer.getFillSize(), drawPanelDimension.getWidth());

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
	

	protected void paintComponent(Graphics g)
	{
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
		// x-axis
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(0, calcPosY(0), drawPanelDimension.width, calcPosY(0));
		//g.drawRect(0, 0, drawPanelDimension.width, drawPanelDimension.height);

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
/*		curve.setBounds(0,0,600,400);
		fenster.add(curve);
	

		fenster.add(curve);*/
		
		curve.setDimension(200,100);

		
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
