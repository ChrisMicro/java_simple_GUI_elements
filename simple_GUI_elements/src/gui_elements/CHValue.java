package gui_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;



/*
 * CHValue format
 * 
 * label      text
 * labelWidth textFieldWidth
 */

public class CHValue extends CHObject
{
	JTextField valueText;
	
	//int textHeigth     = 20;
	//int heigth         = 30;
	int textFieldWidth = 60;
	int defaultStyle=0;
	
	public CHValue(String label, String value)
	{
		super(label);

		valueText=new JTextField(value);
		// turn off cursor
		//valueText.setCaretColor(Color.WHITE);
		//valueText.setHorizontalAlignment(SwingConstants.CENTER);
		setStyle(defaultStyle);

		super.add(valueText,"East");

		Dimension d1=valueText.getPreferredSize();
		
		if(d1.width>textFieldWidth) textFieldWidth=d1.width;

		valueText.setPreferredSize( new Dimension( textFieldWidth, d1.height ) );
		
		int width=textFieldWidth;		
		Point p=this.getLocation();
		this.setBounds(p.x,p.y,width,d1.height+4);
	}
	
	public void setStyle(int style)
	{
		if(style==0)
		{
			valueText.setCaretColor(Color.WHITE);
			//valueText.setBackground(Color.WHITE);
			valueText.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if(style==1)
		{
			valueText.setCaretColor(Color.WHITE);
			valueText.setBackground(Color.LIGHT_GRAY);
			valueText.setForeground(Color.BLUE);
			valueText.setHorizontalAlignment(SwingConstants.CENTER);
			//valueText.setBorder()
			//Border b=valueText.getBorder();
			
		}
	}
	
	public CHValue(String label, int value)
	{
		this(label, ""+value);
	}

	public void setValueText(String value)
	{
		valueText.setText(value);
	}
	public void setValue(String value)
	{
		valueText.setText(value);
	}
	public void setValue(float value)
	{
		valueText.setText(String.format("%.2f", value));
	}
	
	public void setValue(double value)
	{
		if(value==0)valueText.setText("0");
		else		valueText.setText(String.format("%.2f", value));
	}
	
	public int getInt()
	{
		int k=0;
		try
		{
			k=Integer.parseInt(valueText.getText());			
		}catch(Exception e)
		{
			
		}
		return k;
	}
	
	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHValue value1=new CHValue("name","rabbit");
		fenster.add(value1);

		CHValue value2=new CHValue("name","10m");
		fenster.add(value2);
		System.out.println(value2.getInt());
		
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
