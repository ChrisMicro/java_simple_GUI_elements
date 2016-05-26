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

		CHGraph value1=new CHGraph("temperature");
		value1.setPosition(100, 100);
		fenster.add(value1);
		
		CHGraph value2=new CHGraph("temperature");

		fenster.add(value2);

		
		fenster.pack();
		fenster.setVisible(true);
		
	}
}
