package examples;

import gui_elements.CHSlider;
import gui_elements.CHSwitch;

import java.awt.Dimension;

import javax.swing.JFrame;

public class SwitchExample 
{

	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("switch example");
		fenster.setPreferredSize(new Dimension(640, 480));
		fenster.getContentPane().setLayout(null);
		
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CHSwitch value1=new CHSwitch("switch1");
		fenster.add(value1);
		
		CHSwitch sw2=new CHSwitch("switch2");
		fenster.add(sw2);
		
		fenster.pack();
		fenster.setVisible(true);
	}
}
