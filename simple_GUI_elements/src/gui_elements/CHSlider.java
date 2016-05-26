package gui_elements;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CHSlider extends JPanel
{

	JLabel labelText;
	JTextField valueText;
	static int next_xPosition=0;
	static int next_yPosition=0;
	
	int width=300;
	int heigth=50;

	public CHSlider(String label, int value)
	{
		super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		labelText=new JLabel(label);
		//super.add(labelText,"West");
		super.add(labelText);

		JSlider meinSlider = new JSlider();
		 
		meinSlider.setMinimum(0);

		meinSlider.setMaximum(20);

		meinSlider.setMajorTickSpacing(5);
		meinSlider.setMinorTickSpacing(1);
 		meinSlider.createStandardLabels(1);
 		meinSlider.setPaintTicks(true);
 		meinSlider.setPaintLabels(true);
 		meinSlider.setValue(value);
 		meinSlider.addChangeListener(new SliderListener());
		//super.add(meinSlider,"East");
 		super.add(meinSlider);
		//meinSlider.setPreferredSize( new Dimension( 100, heigth ) );
 		
		valueText=new JTextField(""+value);
		super.add(valueText);
		valueText.setCaretColor(Color.WHITE);
		valueText.setPreferredSize( new Dimension( 100, 20 ) );
			
		super.setBounds(next_xPosition,next_yPosition,width,heigth);
		next_yPosition+=heigth;
	}
	
	public void setPosition(int x, int y)
	{
		super.setBounds(x,y,width,heigth);
		next_yPosition+=heigth;	
		next_yPosition+=heigth;	
		next_xPosition=x;
	}
	
	public void setValueText(String value)
	{
		valueText.setText(value);
	}
	
	class SliderListener implements ChangeListener {
	    public void stateChanged(ChangeEvent e) 
	    {
	        JSlider source = (JSlider)e.getSource();

            int value = (int)source.getValue();
            valueText.setText(""+value);
	    }
	}
}
