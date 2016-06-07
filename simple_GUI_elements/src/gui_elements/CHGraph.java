package gui_elements;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.SwingUtilities;

public class CHGraph extends CHObject 
{
	public boolean autoScaleY=true;
	GraphScale graphScale;
	private int xAchsePos;
	private int yAchsePos;
	private int xDimension=400;
	private int yDimension=300;
	
	double daten[];
	int dataSize=100;
	
	double scalex=1;
	double scaley=0.5;
	
	double xMin=0;
	double xMax=10000;

	double yMin=-256;
	double yMax=256;
	
	RingBuffer buffer;
	
	public void setMinMaxY(double yMin, double yMax)
	{
		this.yMin=yMin;
		this.yMax=yMax;
		scaley=yDimension/2/(yMax-yMin);
	}
	
	public CHGraph(String graphName, int dataSize)
	{
		super(graphName);
		this.add(labelText);
		
		graphScale = new GraphScale();
		
		//daten=new double[dataSize];
		daten=new double[0];
		xAchsePos=yDimension/2;
		yAchsePos=40;
		this.dataSize=dataSize;
		// dummy test data
		//for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/5);
		double[] daten=new double[dataSize];
		buffer=new RingBuffer(daten);
		//buffer = new RingBuffer(dataSize);
		
		xMax=daten.length;		
		scalex=(xDimension-yAchsePos)/(xMax-xMin);
		if(autoScaleY)
		{
			scaley=graphScale.getAutoScale(daten, xAchsePos, yDimension-xAchsePos);
			yMin=graphScale.getMin();
			yMax=graphScale.getMax();
		}
		super.setBounds(next_xPosition,next_yPosition,xDimension,yDimension);

		clearChart();
	}
	
	public CHGraph(String graphName)
	{
		this(graphName, 100);
	}
	
	public CHGraph(String graphName,double[] data)
	{
		this(graphName);
		
		buffer=new RingBuffer(data);
		
		daten=data;
		dataSize=daten.length;
		xMax=dataSize;		
		scalex=(xDimension-yAchsePos)/(xMax-xMin);
		if(autoScaleY)
		{
			scaley=graphScale.getAutoScale(daten, xAchsePos, yDimension-xAchsePos);
			yMin=graphScale.getMin();
			yMax=graphScale.getMax();
		}
	}
	
	public void setData(double[] data)
	{
		buffer=new RingBuffer(data);
		
		daten=data;
		dataSize=daten.length;
		xMax=dataSize;		
		scalex=(xDimension-yAchsePos)/(xMax-xMin);
		if(autoScaleY) scaley=graphScale.getAutoScale(data, xAchsePos, yDimension-xAchsePos);
		repaint();
	}
	
	public void setData(int[] data)
	{
		buffer=new RingBuffer(data);
		
		daten=buffer.getData();
		dataSize=daten.length;
		xMax=dataSize;		
		scalex=(xDimension-yAchsePos)/(xMax-xMin);
		if(autoScaleY) scaley=graphScale.getAutoScale(daten, xAchsePos, yDimension-xAchsePos);
		repaint();
	}
	
	public void clearChart()
	{
		buffer.clear();
	}
	
	public void addValue(double value)
	{
		buffer.ringBufferAdd(value);
		SwingUtilities.invokeLater // prevent race condition due to slow UI
		(
			new Runnable() 
			{
				@Override
				public void run() 
				{
						repaint();
				}
			}
		);
	}
	
	public int calcPosX(double x)
	{
		int result;
		
		result=(int)(x*scalex);
		result=yAchsePos+result;
		return result;
	}
	
	public int calcPosY(double y)
	{
		int result;
		
		result=(int)(y*scaley);
		result=xAchsePos-result;
		return result;
	}
	
	protected void showAxisY(Graphics g)
	{
		// Beschriftung
		g.drawString(""+graphScale.getMin(),yAchsePos-30,calcPosY(graphScale.getMin()));
		g.drawString(""+graphScale.getMax(),yAchsePos-30,calcPosY(graphScale.getMax()));
	}
	
	@Override 
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen
		g.setColor(Color.blue);
		dataSize=buffer.fillSize;
		if(dataSize>1) // draw a graph
		{	
			for(int n=0;n<(dataSize-1);n++)
			{
				int p1x=calcPosX(n);
				int p1y=calcPosY(buffer.ringBufGetValue(n));
				int p2x=calcPosX((n+1));
				int p2y=calcPosY(buffer.ringBufGetValue(n+1));
				
				g.drawLine(p1x,p1y,p2x,p2y);
			}
		}
		if(dataSize==1) // draw only a point
		{
			int p1x=calcPosX(0);
			int p1y=calcPosY(buffer.ringBufGetValue(0));
			int PointSize=3;
			g.drawRect(p1x-PointSize/2, p1y-PointSize/2, PointSize, PointSize);
		}

		// draw axis
		g.setColor(Color.gray);
		g.drawLine(0,xAchsePos,xDimension,xAchsePos); // |
		g.drawLine(yAchsePos,0,yAchsePos,yDimension); // -
		
		showAxisY(g);

	}
}
/* simple_GUI_elements
 * © ChrisMicro 2016.
 *
 * This file is part of simple_GUI_elements.
 *
 * simple_GUI_elements is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * simple_GUI_elements is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with simple_GUI_elements.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you use simple_GUI_elements in public project you can inform me about this by e-mail,
 * of course if you want it.
 *
 * web-site: https://github.com/ChrisMicro/java_simple_GUI_elements
 */