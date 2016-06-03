package examples;

import gui_elements.CHGraph;
import gui_elements.CHSlider;
import gui_elements.CHSwitch;
import gui_elements.CHValue;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ATestAllExample 
{
	boolean runLoop=true;
	JFrame window;

	public static void delay_ms(int t_ms)
	{
	    try 
	    {
	        Thread.sleep(t_ms);           
	    } catch(InterruptedException ex) 
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	
	public ATestAllExample()
	{
		window=new JFrame("slider example");
	    window.setPreferredSize(new Dimension(640, 480));
	    window.getContentPane().setLayout(null);

	    //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.addWindowListener
		(
			new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e) 
				{
					runLoop=false;
					delay_ms(500);
					System.exit(0);        
				}        
			}
		);
	}

	public void runArduinoStyle()
	{
		/***************************************************************
		 * 
		 * setup
		 * 
		 ***************************************************************/
		CHValue value1=new CHValue("example","all");
		window.add(value1);
		value1.setPosition(10, 10);
	
		CHSwitch switch1=new CHSwitch("switch1");
		window.add(switch1);
		
		int dataSize=500;
		double[] daten=new double[dataSize];
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/10);
		CHGraph graph1=new CHGraph("simple graph",daten);
		graph1.setMinMaxY(-1.5, 1.5);

		graph1.setPosition(200, 10);
		
		window.add(graph1);
		
		CHSlider rateSlider=new CHSlider("rate [ms]",100,0,100);
		window.add(rateSlider);
		
		window.pack();
		window.setVisible(true);
		
		/***************************************************************
		 * 
		 * loop
		 * 
		 ***************************************************************/
		int n=0;
		// dynamically update chart 
		while (runLoop)
		{
			graph1.addValue(Math.sin((double)n/10));
			n++;
			
			int t_ms=rateSlider.getInt();
			t_ms=Math.max(t_ms, 1);
			delay_ms(t_ms);
		}
	}
	
	public static void main(String[] args) 
	{
		ATestAllExample a=new ATestAllExample();
		a.runArduinoStyle();
	}
}
