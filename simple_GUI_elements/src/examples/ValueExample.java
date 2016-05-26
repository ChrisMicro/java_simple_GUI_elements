package examples;

import gui_elements.CHValue;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ValueExample 
{

	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHValue value1=new CHValue("name","rabbit");
		fenster.add(value1);
	
		CHValue value2=new CHValue("weight","2 Kg");
		fenster.add(value2);

		CHValue value3=new CHValue("speed","40 km/h");
		fenster.add(value3);
		value3.setPosition(200, 200);
		
		CHValue value4=new CHValue("brains","superb");
		fenster.add(value4);
		
		CHValue value5=new CHValue("color","brown");
		fenster.add(value5);
		
		fenster.pack();
		fenster.setVisible(true);
		
	}
}
