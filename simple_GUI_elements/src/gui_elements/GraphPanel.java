package gui_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GraphPanel extends CHObject
{
	JTextField valueText;

	private int xDimension=400;
	private int yDimension=250;
	
	JPanel drawing;
	CHValue title;
	
	public GraphPanel(String label)
	{
		super(label);
		CHValue title=new CHValue("hallo test hallo", "geth nicht so schnell");
		this.add(title);
		super.setBounds(next_xPosition,next_yPosition,xDimension,yDimension);
		JPanel drawing=new JPanel();
		this.setLayout(null);
		/*
		this.add(drawing);
		drawing.setBackground(Color.CYAN);
		
		drawing.setBounds(10, 10, 100, 100);
		*/
		
/*
		valueText=new JTextField(value);
		valueText.setCaretColor(Color.WHITE);
		valueText.setHorizontalAlignment(SwingConstants.CENTER);
		valueText.setPreferredSize( new Dimension( textFieldWidth, textHeigth ) );
		super.add(valueText,"East");


		if(d.width>labelWidth) labelWidth=d.width+10;

		int width=labelWidth+textFieldWidth;
		
		Point p=this.getLocation();
		super.setBounds(p.x,p.y,width,heigth);
		*/
	}
	
	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    GraphPanel graphTitle=new GraphPanel("graph title");
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
