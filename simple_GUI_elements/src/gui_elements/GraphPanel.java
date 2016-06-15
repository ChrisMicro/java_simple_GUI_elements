package gui_elements;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GraphPanel extends CHObject
{
	JTextField valueText;

	private int xDimension=410;
	private int yDimension=300;
	
	int titleHeight=25;
	int titleWidth;
	int drawingHeight;
	int drawingLeftBorderWidth=110;
	int drawingRightBorderWidth=40;
	int drawingUpperBorderHeight=titleHeight;
	int drawingLowerBorderHeight=35;
	int frameBorder=5;

	int drawingWidth;
	
	double xMin =  0;
	double xMax = 10;
	double yMin = -1;
	double yMax =  10;
		
	CurvePanel drawing;
	CHObject titleFrame;
	CHLabeledValue title;
	CHRectangleBorder box;
	
	Axis xAxis;
	Axis yAxis;
	
	
	private void setPositions()
	{
		titleWidth=xDimension-drawingLeftBorderWidth-drawingRightBorderWidth;

		drawingWidth=xDimension-drawingLeftBorderWidth-drawingRightBorderWidth;
		drawingHeight=yDimension-drawingLowerBorderHeight-drawingUpperBorderHeight-frameBorder;
	}
	
	public GraphPanel(String titleText,Curve curve)
	{
		super(titleText);
		this.setLayout(null);

		super.setBounds(next_xPosition,next_yPosition,xDimension,yDimension);
		
		//xLabel_=new JLabel();
		//yLabel_=new JLabel();

		titleFrame=new CHObject(titleText);
		this.add(titleFrame);
		
		JLabel text=new JLabel(titleText);
		titleFrame.add(text);
		
		drawing=new CurvePanel();
		this.add(drawing);
		//drawing.setBackground(Color.LIGHT_GRAY);
		drawing.setBackground(Color.WHITE);

		setPositions();
		titleFrame.setBounds(drawingLeftBorderWidth,frameBorder,titleWidth,titleHeight);
		drawing.setBounds(drawingLeftBorderWidth, drawingUpperBorderHeight+frameBorder, drawingWidth, drawingHeight);
		//drawing.setBounds(drawingLeftBorderWidth, drawingUpperBorderHeight+frameBorder, drawingWidth, 100);
		
		drawing.add(curve);
		
		//************* x axis **********************************
		xAxis=new Axis(Axis.AXIS_X,"time [s]");
		
		int xPos=drawingLeftBorderWidth;
		int yPos=yDimension-drawingLowerBorderHeight;
		
		xAxis.setBounds(xPos,yPos,drawingWidth,drawingLowerBorderHeight);
		
		//this.add(xAxis);
		
		//************* y axis **********************************
		yAxis=new Axis(Axis.AXIS_Y,"amplitude [V]");
		
		xPos=frameBorder;
		yPos=drawingUpperBorderHeight;
		
		yAxis.setBounds(xPos,yPos,drawingLeftBorderWidth,drawingHeight);
		
		this.add(yAxis);

		
		box=new CHRectangleBorder("none");
		//CHBox box=new CHBox("");
		this.add(box);
		box.setBounds(0, 0,this.getWidth(),this.getHeight());
	}
	
	public void add(Curve curve)
	{
		drawing.add(curve);
	}
	
	public void removeCurves()
	{
		drawing.removeCurves();
	}
	
	public void set_xlabel(String xLabel)
	{
		xAxis.setName(xLabel);
		//this.xLabel=xLabel;
	//	xLabel_.setText(xLabel);
	//	showAxis_x();
	}
	
	public void set_ylabel(String yLabel)
	{
		yAxis.setName(yLabel);
		//this.yLabel=yLabel;
	//	yLabel_.setText(yLabel);
	//	showAxis_y();
	}
	
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		xDimension=width;
		yDimension=height;
		setPositions();
		if(titleFrame!=null)titleFrame.setBounds(drawingLeftBorderWidth,frameBorder,titleWidth,titleHeight);
		if(drawing!=null)drawing.setBounds(drawingLeftBorderWidth, drawingUpperBorderHeight+frameBorder, drawingWidth, drawingHeight);
		if(box!=null)box.setBounds(0, 0,this.getWidth(),this.getHeight());
		if(yAxis!=null) yAxis.setBounds(frameBorder,drawingUpperBorderHeight+frameBorder,drawingLeftBorderWidth,drawingHeight);
		if(yAxis!=null)
		{
			int xPos=drawingLeftBorderWidth;
			int yPos=yDimension-drawingLowerBorderHeight;
			
			xAxis.setBounds(xPos,yPos,drawingWidth,drawingLowerBorderHeight-frameBorder);
		}
	}
	
	public void setScale_y(double min, double max)
	{
		drawing.setScale_y(min, max);
		yAxis.setMinMax(min, max);
		repaint();
	}
	
	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //GraphPanel graph1=new GraphPanel("chart title");
		//fenster.add(graph1);
		//graph1.setBounds(10,10,200,100);
	
		Curve curve=new Curve();
		curve.setVisibleLinePoints(true);
				
	    GraphPanel graph2=new GraphPanel("rolling chart",curve);

		graph2.setPosition(10, 250);	
		graph2.set_xlabel("time [s]");
		graph2.set_ylabel("voltage [V]");
		graph2.setBounds(30,30,400,300);
		graph2.setScale_y(-5, 5);
		
		fenster.add(graph2);
		
	    //GraphPanel graph3=new GraphPanel("rolling chart",curve);
		//fenster.add(graph3);
		//graph2.setBounds(0,0,270,300);
		
		fenster.pack();
		fenster.setVisible(true);
		
		int dataSize=100;
		for(int n=0;n<dataSize;n++)
		{
			curve.addValue(Math.sin((double)n/5));
			//curve1.addValue(Math.cos((double)n/5));
			//curve2.addValue(Math.sin((double)n/7));
			//curve3.addValue(Math.cos((double)n/10));
			graph2.repaint();
			int t_ms=20;
		    try 
		    {
		        Thread.sleep(t_ms);           
		    } catch(InterruptedException ex) 
		    {
		        Thread.currentThread().interrupt();
		    }
		}
		graph2.setScale_y(-2, 2);
		

		
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
