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
		
		CHSlider rateSlider=new CHSlider("rate [ms]",100,0,100);
		fenster.add(rateSlider);
		
		int dataSize=500;
		double[] daten=new double[dataSize];
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/5);
		CHGraph value5=new CHGraph("simple graph",daten);
		fenster.add(value5);
		value5.setPosition(150, 200);
		
		fenster.pack();
		fenster.setVisible(true);
		
		// dynamically update chart 
		for(int n=0;n<10000;n++)
		{
			value5.addValue(Math.sin((double)n/10));
			
			int delay_ms=rateSlider.getInt();
			// delay
		    try 
		    {
		        Thread.sleep(delay_ms);           
		    } catch(InterruptedException ex) 
		    {
		        Thread.currentThread().interrupt();
		    }
		}
		
	}
}
