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
		
		width=d.width;
		heigth=d.height+5;
		super.setBounds(next_xPosition,next_yPosition,width,heigth);
		next_yPosition+=heigth;
	}
	
	public CHSwitch(String name)
	{
		this(name,"off","on");
	}
    
	public boolean isOn()
	{
		return switchState;
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
        
        if(switchState)System.out.println("on");
        else System.out.println("off");
        	
    } 
}
