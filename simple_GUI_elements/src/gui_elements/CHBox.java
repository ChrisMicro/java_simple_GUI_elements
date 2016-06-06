package gui_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CHBox extends CHObject
{
	JTextField valueText;

	int boxWidth       = 300;
	int textHeigth     = 20;
	int height         = 40;
	int textSize       = 20;
	
	Color backGroundColor;
	
	public CHBox(String label)
	{
		super(label);
		
		labelText=new JLabel(label);
		
		super.setLayout(null);

		labelText=new JLabel(label,SwingConstants.CENTER);
		
		Dimension d=labelText.getPreferredSize();
		//labelWidth=d.width;
	
		//labelText.setBounds(1+(boxWidth)/2,1,boxWidth,textHeigth+height/2);
		labelText.setBounds(1,1,boxWidth,textHeigth+height/2);
		
		labelText.setForeground(Color.white);
		
		super.add(labelText);
		//Dimension d=labelText.getPreferredSize();
		
		//super.add(labelText,"West");
		
		//backGroundColor=Color.BLUE;
		Color himmelBlau=new Color(114,159,207);
		backGroundColor=himmelBlau;

		//Font labelFont = labelText.getFont();
		//labelText.setFont(new Font(labelFont.getName(), Font.PLAIN, textSize));
		setTextSize(height/2);
		/*
		valueText=new JTextField(value);
		valueText.setCaretColor(Color.WHITE);
		valueText.setHorizontalAlignment(SwingConstants.CENTER);
		valueText.setPreferredSize( new Dimension( textFieldWidth, textHeigth ) );
		super.add(valueText,"East");


		if(d.width>labelWidth) labelWidth=d.width+10;

		int width=labelWidth+textFieldWidth;
		*/
		Point p=this.getLocation();
		super.setBounds(p.x,p.y,boxWidth,height);
	}
	public void setTextSize(int textSize)
	{
		this.textSize=textSize;
		Font labelFont = labelText.getFont();
		labelText.setFont(new Font(labelFont.getName(), Font.PLAIN, textSize));
	}
	
	@Override 
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		boxWidth=width;
		labelText.setBounds(1,1,boxWidth,textHeigth+height/2);
		setTextSize(height/2);
	}
	
	public void setWidth(int width)
	{
		Rectangle r=this.getBounds();
		setBounds(r.x, r.y, width, r.height);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen
		g.setColor(backGroundColor);
		//Point p=this.getLocation();
		//g.drawRect(0, 0,boxWidth,height);
		Rectangle r=this.getBounds();
		//g.fillRect(1, 1,boxWidth-2,height-2);
		g.fillRect(1, 1,r.width-2,r.height-2);
		g.setColor(Color.white);
		//Point p=this.getLocation();
        //g.drawString("This is gona be awesome",p.x,p.y); 
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
