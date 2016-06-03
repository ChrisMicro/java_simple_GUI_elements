package gui_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CHValue extends CHObject
{
//	JLabel labelText;
	JTextField valueText;
//	static int next_xPosition=0;
//	static int next_yPosition=0;
	
	int textHeigth     = 20;
	int heigth         = 30;
	int labelWidth     = 80;
	int textFieldWidth = 60;
	
	public CHValue(String label, String value)
	{
		super(label);

		labelText=new JLabel(label);
		Dimension d=labelText.getPreferredSize();
		super.add(labelText,"West");

		valueText=new JTextField(value);
		valueText.setCaretColor(Color.WHITE);
		valueText.setHorizontalAlignment(SwingConstants.CENTER);
		valueText.setPreferredSize( new Dimension( textFieldWidth, textHeigth ) );
		super.add(valueText,"East");


		if(d.width>labelWidth) labelWidth=d.width+10;

		int width=labelWidth+textFieldWidth;
		
		Point p=this.getLocation();
		super.setBounds(p.x,p.y,width,heigth);
	}
	
	public CHValue(String label, int value)
	{
		this(label, ""+value);
	}

	public void setValueText(String value)
	{
		valueText.setText(value);
	}
	
	public void setValue(float value)
	{
		valueText.setText(String.format("%.2f", value));

	}
	public void setValue(double value)
	{
		valueText.setText(String.format("%.2f", value));
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
