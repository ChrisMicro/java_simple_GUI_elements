package examples;

import gui_elements.CHGraph;
import gui_elements.CHSlider;
import gui_elements.CHSwitch;
import gui_elements.CHValue;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ATestAllExample 
{

	public static void delay_ms(int t_ms)
	{
		// delay
	    try 
	    {
	        Thread.sleep(t_ms);           
	    } catch(InterruptedException ex) 
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	
	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("slider example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHValue value1=new CHValue("example","all");
		fenster.add(value1);
		value1.setPosition(10, 10);
	
		CHSwitch switch1=new CHSwitch("switch1");
		fenster.add(switch1);
		
		int dataSize=500;
		double[] daten=new double[dataSize];
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/10);
		CHGraph graph1=new CHGraph("simple graph",daten);
		graph1.setMinMaxY(-1.5, 1.5);

		graph1.setPosition(200, 10);
		
		fenster.add(graph1);
		
		CHSlider rateSlider=new CHSlider("rate [ms]",100,0,100);
		fenster.add(rateSlider);
		
		fenster.pack();
		fenster.setVisible(true);
		
		// loop dynamically update chart 
		for(int n=0;n<10000;n++)
		{
			graph1.addValue(Math.sin((double)n/10));
			
			int t_ms=rateSlider.getInt();
			delay_ms(t_ms);
		}
		
	}
}
