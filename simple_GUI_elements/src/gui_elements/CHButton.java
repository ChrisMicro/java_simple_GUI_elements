package gui_elements;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CHButton extends CHObject implements ActionListener
{
	JButton button1;

	boolean wasPressed_flag=false;
	
	public CHButton(String labelName, String buttonString)
	{
		super(labelName);

		super.add(labelText);
		button1 = new JButton(buttonString);

        button1.addActionListener(this);

		super.add(button1);

		Dimension d=super.getPreferredSize();
		
		//width=d.width;
		//heigth=d.height+5;
		super.setBounds(next_xPosition,next_yPosition,d.width,d.height+5);
		//next_yPosition+=heigth;
	}
	public CHButton(String buttonString)
	{
		this("",buttonString);
	}
	
	public boolean isPressed()
	{
		boolean flag;
		flag = wasPressed_flag;
		wasPressed_flag = false;
		return flag;
	}
		
    public void actionPerformed(ActionEvent ae) 
    {

        if(ae.getSource() == this.button1)
        {
            wasPressed_flag=true;
        }


        	
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