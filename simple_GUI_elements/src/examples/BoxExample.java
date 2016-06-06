package examples;

import gui_elements.CHBox;
import gui_elements.CHValue;

import java.awt.Dimension;

import javax.swing.JFrame;

public class BoxExample 
{

	public static void main(String[] args) 
	{
		JFrame fenster;
		fenster=new JFrame("value example");
	    fenster.setPreferredSize(new Dimension(640, 480));
	    fenster.getContentPane().setLayout(null);

	    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CHBox value1=new CHBox("title name");
		fenster.add(value1);
		
		CHBox value2=new CHBox("box2");
		fenster.add(value2);
		value2.setPosition(100, 100);

		
		CHBox value3=new CHBox("large box");
		fenster.add(value3);
		//value3.setTextSize(25);

		value3.setBounds(100, 200,500,100);
		
		CHBox value4=new CHBox("small box");
		fenster.add(value4);
		//value3.setTextSize(25);

		value4.setBounds(10, 400,500,30);
	
		
		fenster.pack();
		fenster.setVisible(true);
		
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