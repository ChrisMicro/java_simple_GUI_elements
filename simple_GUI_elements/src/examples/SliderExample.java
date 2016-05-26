package examples;

import gui_elements.CHSlider;

import java.awt.Dimension;

import javax.swing.JFrame;

public class SliderExample 
{

	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("slider example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHSlider value1=new CHSlider("name",123);
		fenster.add(value1);
	
		CHSlider value2=new CHSlider("weight",0);
		fenster.add(value2);

		CHSlider value3=new CHSlider("speed",5);
		fenster.add(value3);
		value3.setPosition(200, 200);
		
		CHSlider value4=new CHSlider("brains",10);
		fenster.add(value4);
		
		CHSlider value5=new CHSlider("color",3);
		fenster.add(value5);
		
		fenster.pack();
		fenster.setVisible(true);
		
	}
}
