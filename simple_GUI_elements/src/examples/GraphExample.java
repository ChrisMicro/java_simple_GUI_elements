package examples;

import gui_elements.CHGraph;
import gui_elements.CHValue;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GraphExample 
{

	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHGraph value1=new CHGraph("signal");
		value1.setPosition(100, 10);
		fenster.add(value1);
		
		int dataSize=500;
		double[] daten=new double[dataSize];
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/5);
		CHGraph value2=new CHGraph("HF signal",daten);

		fenster.add(value2);

		
		fenster.pack();
		fenster.setVisible(true);
		
	}
}
