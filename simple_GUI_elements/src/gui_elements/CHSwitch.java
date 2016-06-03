package gui_elements;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CHSwitch extends CHObject implements ActionListener
{
	JRadioButton button1;
	JRadioButton button2;
	
	boolean switchState=false;
	boolean isChangedFlag=false;
	
	public CHSwitch(String name, String offText, String onText)
	{
		super(name);

		super.add(labelText);
        button1 = new JRadioButton (offText, true);
        button2 = new JRadioButton (onText, false);

        button1.addActionListener(this);
        button2.addActionListener(this);

		super.add(button1);
		super.add(button2);
		Dimension d=super.getPreferredSize();
		
		//width=d.width;
		//heigth=d.height+5;
		super.setBounds(next_xPosition,next_yPosition,d.width,d.height+5);
		//next_yPosition+=heigth;
	}
	
	public CHSwitch(String name)
	{
		this(name,"off","on");
	}
    
	public boolean isOn()
	{
		return switchState;
	}
	
	public boolean isChanged()
	{
		boolean flag;
		flag = isChangedFlag;
		isChangedFlag = false;
		return flag;
	}
	
    public void actionPerformed(ActionEvent ae) 
    {

        if(ae.getSource() == this.button1)
        {
            button1.setSelected(true);
            button2.setSelected(false);
            switchState=false;
        }
        if(ae.getSource() == this.button2)
        {
            button1.setSelected(false);
            button2.setSelected(true);
            switchState=true;
        }
        
        //if(switchState)System.out.println("on");
        //else System.out.println("off");
		isChangedFlag=true;
        	
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