package examples;

import gui_elements.CHBox;
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
		window=new JFrame("test all example");
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
		CHBox titleBox=new CHBox("java simple gui elements");
		titleBox.setWidth(600);
		window.add(titleBox);
		
		CHValue value1=new CHValue("example","all");
		window.add(value1);
		//value1.setPosition(10, 10);
	
		CHSwitch switch1=new CHSwitch("switch1");
		window.add(switch1);
		
		int dataSize=500;
		double[] daten=new double[dataSize];
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/10);
		CHGraph graph1=new CHGraph("simple graph",daten);
		graph1.setMinMaxY(-1.5, 1.5);

		graph1.setPosition(200, 60);
		
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