package examples;

import gui_elements.CHGraph;
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

		CHValue value1=new CHValue("example","all");
		fenster.add(value1);
		value1.setPosition(150, 10);
	
		//CHValue value2=new CHValue("number","123");
		//fenster.add(value2);

		CHSlider value3=new CHSlider("CHSlider",5);
		fenster.add(value3);
		value3.setPosition(150, 60);
		
		CHSlider value4=new CHSlider("speed [m/s]",10);
		fenster.add(value4);
		
		int dataSize=500;
		double[] daten=new double[dataSize];
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/5);
		CHGraph value5=new CHGraph("simple graph",daten);
		fenster.add(value5);
		value5.setPosition(150, 200);
				
		fenster.pack();
		fenster.setVisible(true);
		
	}
}
