package gui_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CHObject extends JPanel
{

	public JLabel labelText;
	public String name;

	static int next_xPosition=10;
	static int next_yPosition=10;
		
	int defaultWidth  = 100;
	int defaultHeight = 25;
	
	int LayoutManagerLineDistance=5;
	
	public CHObject(String name)
	{
		labelText=new JLabel(name);

		setBounds(next_xPosition,next_yPosition,defaultWidth,defaultHeight);
	}
	
	public void setName(String name)
	{
		labelText.setText(name);	
	}
	
	// minimalistic layout manager
	public void setPosition(int x, int y)
	{
		this.setBounds(x, y, this.getWidth(),this.getHeight());
	}
	
	@Override 
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);

		next_yPosition = y+this.getHeight() + LayoutManagerLineDistance;	
		next_xPosition = x;
	}
	
	@Override 
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen

		Rectangle r=this.getBounds();
	
		int thickness = 2;
		Graphics2D g2;
		g2=(Graphics2D) g;
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(thickness));
		
		g.setColor(Color.white);
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
