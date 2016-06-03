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