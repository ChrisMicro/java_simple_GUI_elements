package examples;

import gui_elements.CHSlider;
import gui_elements.CHValue;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ATestAllExample 
{

	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("slider example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHValue value1=new CHValue("example","CHValue");
		fenster.add(value1);
		value1.setPosition(20, 20);
	
		CHValue value2=new CHValue("number","123");
		fenster.add(value2);


		CHSlider value3=new CHSlider("CHSlider",5);
		fenster.add(value3);
		value3.setPosition(150, 150);
		
		CHSlider value4=new CHSlider("speed [m/s]",10);
		fenster.add(value4);
		value4.setPosition(150, 250);
				
		fenster.pack();
		fenster.setVisible(true);
		
	}
}
