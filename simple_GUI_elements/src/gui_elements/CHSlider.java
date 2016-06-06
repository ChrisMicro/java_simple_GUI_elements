package gui_elements;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CHSlider extends CHObject
{
	JTextField valueText;
	int sliderValue;
	
	int textHeigth=20;
	int labelWidth=100;
	int lableWidthDistanceToSlider=5;
	int sliderWidth=160;
	int textFieldWidth=60;

	int defalutHeight=50;
	int borderDistance=3;

	public CHSlider(String label, int value, int min, int max)
	{
		super(label);

		super.setLayout(null);

		labelText=new JLabel(label,SwingConstants.CENTER);

		Dimension d=labelText.getPreferredSize();
		labelWidth=d.width+lableWidthDistanceToSlider;
		labelText.setBounds(borderDistance,2*borderDistance,labelWidth,textHeigth);
		int width;
		width=labelWidth+sliderWidth+textFieldWidth+2*borderDistance;
		super.add(labelText);
		
		sliderValue=value;

		JSlider meinSlider = new JSlider();
		 
		meinSlider.setMinimum(min);

		meinSlider.setMaximum(max);

		int minorSpace=(max-min)/20;
		int majorSpace=minorSpace*5;
		
		meinSlider.setMajorTickSpacing(majorSpace);
		meinSlider.setMinorTickSpacing(minorSpace);
		//meinSlider.setMajorTickSpacing(5);
		//meinSlider.setMinorTickSpacing(1);
 		meinSlider.createStandardLabels(1);
 		meinSlider.setPaintTicks(true);
 		meinSlider.setPaintLabels(true);
 		meinSlider.setValue(value);
 		meinSlider.addChangeListener(new SliderListener());
 		meinSlider.setBounds(labelWidth,1,sliderWidth,defalutHeight);
 		super.add(meinSlider);
 		
		valueText=new JTextField(""+value);
		valueText.setHorizontalAlignment(SwingConstants.CENTER);
		valueText.setBounds(labelWidth+sliderWidth,2*borderDistance,textFieldWidth,textHeigth);
		super.add(valueText);
		valueText.setCaretColor(Color.WHITE);
		
		Point p=this.getLocation();
		super.setBounds(p.x,p.y,width,defalutHeight+2);

	}
	public CHSlider(String label, int value)
	{
		this(label, value, 0, 20);
	}

	public void setValueText(String value)
	{
		valueText.setText(value);
	}
	
	public int getInt()
	{
		return sliderValue;
	}
	
	class SliderListener implements ChangeListener {
	    public void stateChanged(ChangeEvent e) 
	    {
	        JSlider source = (JSlider)e.getSource();

            int value = (int)source.getValue();
            sliderValue=value;
            valueText.setText(""+value);
	    }
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