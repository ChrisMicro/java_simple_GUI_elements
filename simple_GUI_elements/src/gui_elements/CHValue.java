package gui_elements;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CHValue extends CHObject
{
//	JLabel labelText;
	JTextField valueText;
//	static int next_xPosition=0;
//	static int next_yPosition=0;
	
	int textHeigth=20;
	int width;
	int heigth=30;
	int labelWidth=80;
	int textFieldWidth=60;
	
	public CHValue(String label, String value)
	{
		super(label);
		width=labelWidth+textFieldWidth;
		labelText=new JLabel(label);
		super.add(labelText,"West");
		valueText=new JTextField(value);
		super.add(valueText,"East");
		valueText.setCaretColor(Color.WHITE);
		valueText.setHorizontalAlignment(SwingConstants.CENTER);
		valueText.setPreferredSize( new Dimension( textFieldWidth, textHeigth ) );
		super.setBounds(next_xPosition,next_yPosition,width,heigth);
		next_yPosition+=heigth;
	}
	public CHValue(String label, int value)
	{
		this(label, ""+value);
	}

	public void setValueText(String value)
	{
		valueText.setText(value);
	}
	
	public void setValue(float value)
	{
		valueText.setText(String.format("%.2f", value));

	}
	public void setValue(double value)
	{
		valueText.setText(String.format("%.2f", value));
	}
}
