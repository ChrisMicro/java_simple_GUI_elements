package gui_elements;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GraphPanel extends CHObject
{
	JTextField valueText;

	private int xDimension=300;
	private int yDimension=200;
	
	int titleHeight=25;
	int drawingLeftBorderWidth=80;
	int drawingRightBorderWidth=50;
	int drawingUpperBorderHeight=titleHeight;
	int drawingLowerBorderHeight=25;

	int drawingWidth;
	
	double xMin=0;
	double xMax=10;
	double yMin=0;
	double yMax=10;
	
	String xLabel;
	String yLabel;
	
	JPanel drawing;
	CHLabeledValue title;
	
	public GraphPanel(String titleText)
	{
		super(titleText);
		//CHValue title=new CHValue("titleText", "");
		//this.add(title);
		super.setBounds(next_xPosition,next_yPosition,xDimension,yDimension);
		JPanel drawing=new JPanel();
		this.setLayout(null);
		
		CHObject titleFrame=new CHObject(titleText);
		this.add(titleFrame);
		JLabel text=new JLabel(titleText);
		titleFrame.add(text);
		int titleWidth=xDimension-drawingLeftBorderWidth-drawingRightBorderWidth;
		titleFrame.setBounds(drawingLeftBorderWidth,0,titleWidth,titleHeight);
		
		this.add(drawing);
		drawing.setBackground(Color.LIGHT_GRAY);
		
		drawingWidth=xDimension-drawingLeftBorderWidth-drawingRightBorderWidth;
		int drawingHeight=yDimension-drawingLowerBorderHeight-drawingUpperBorderHeight;
		
		drawing.setBounds(drawingLeftBorderWidth, drawingUpperBorderHeight, drawingWidth, drawingHeight);
		
		showAxis_x();
		showAxis_y();
		
	}
	
	public void showAxis_x()
	{
		//************** X-Axis *************************
		CHValue xMinLabel=new CHValue("xMin","-");
		this.add(xMinLabel);
		xMinLabel.setValue(xMin);
		
		int yPos=yDimension-drawingLowerBorderHeight;
		xMinLabel.setPosition(drawingLeftBorderWidth, yPos);
		
		CHValue xMaxLabel=new CHValue("xMax","-");
		this.add(xMaxLabel);
		xMaxLabel.setValue(xMax);
		
		int xPos=xDimension-drawingRightBorderWidth;
		xMaxLabel.setPosition(xPos, yPos);
	}
	
	public void showAxis_y()
	{
		//************** Y-Axis *************************
		int xPos=0;
		
		CHValue yMaxLabel=new CHValue("yMax","yMax");
		this.add(yMaxLabel);
		yMaxLabel.setValue(yMax);
		
		int textHeigth=yMaxLabel.getHeight();
		
		yMaxLabel.setPosition(xPos, drawingUpperBorderHeight-textHeigth/2);
		
		CHValue yMinLabel=new CHValue("yMin","yMin");
		this.add(yMinLabel);
		yMinLabel.setValue(yMin);
		
		int yPos=yDimension-drawingLowerBorderHeight-textHeigth/2;
		
		yMinLabel.setPosition(xPos, yPos);
	}
	
	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    GraphPanel graphTitle=new GraphPanel("chart title");
		fenster.add(graphTitle);
	
		fenster.pack();
		fenster.setVisible(true);
		
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
