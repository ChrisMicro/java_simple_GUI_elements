package gui_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Axis extends CHObject
{
	//JTextField valueText;
	public final static int AXIS_X = 0;
	public final static int AXIS_Y = 1;
	
	int axisDirection=AXIS_X;

	int textHeight     = 25;
	
	CHValue MinLabel;
	CHValue MaxLabel;
	CHValue axisLabel;
	
	public Axis(int axisDirection, String label)
	{
		super(label);
				
		super.setLayout(null);

		this.axisDirection=axisDirection;
		
		axisLabel=new CHValue(label,label);
		MinLabel=new CHValue("yMin","yMin");
		MaxLabel=new CHValue("yMax","yMax");
	
		super.add(MinLabel);
		super.add(MaxLabel);
		super.add(axisLabel);
	}

	public void setName(String name)
	{
		axisLabel.setValue(name);
	}
	
	@Override 
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		int border=2;
		int labelWidth=width-2*border;


		if(axisLabel!=null)
		{
			if(axisDirection==AXIS_X)
			{
				labelWidth=60;
				axisLabel.setBounds(width/2-labelWidth/2,border,labelWidth,textHeight);
				MinLabel.setBounds(border,border,labelWidth,textHeight);
				MaxLabel.setBounds(width-border-labelWidth,border,labelWidth,textHeight);
			}else
			{
				axisLabel.setBounds(border,height/2-textHeight/2,labelWidth,textHeight);
				MinLabel.setBounds(border,height-textHeight-border,labelWidth,textHeight);
				MaxLabel.setBounds(border,border,labelWidth,textHeight);
			}
		}

	}
	
	public void setMinMax(double min, double max)
	{
		MinLabel.setValue(min);
		MaxLabel.setValue(max);
	}
	
	public void setWidth(int width)
	{
		Rectangle r=this.getBounds();
		setBounds(r.x, r.y, width, r.height);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen
		//g.setColor(backGroundColor);

		//Rectangle r=this.getBounds();

		//g.drawRect(0, 0,r.width-1,r.height-1);

	}
	
	public static void main(String[] args) 
	{
		JFrame window;
		window=new JFrame("box example");
	    window.setPreferredSize(new Dimension(640, 480));
	    window.getContentPane().setLayout(null);

	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Axis xAxis=new Axis(Axis.AXIS_X,"time [s]");
		xAxis.setBounds(100,300,300,40);
		xAxis.setMinMax(0, 100);
		
		Axis yAxis=new Axis(Axis.AXIS_Y,"amplitude [V]");
		yAxis.setBounds(0,0,100,240);
		yAxis.setMinMax(-1, 2);

		window.add(xAxis);
		window.add(yAxis);

		window.pack();
		window.setVisible(true);
		
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
