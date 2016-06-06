package gui_elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CHRectangleBorder extends CHObject
{
	JTextField valueText;

	int boxWidth       = 300;
	int textHeigth     = 20;
	int height         = 40;
	int textSize       = 20;
	
	Color backGroundColor;
	
	public CHRectangleBorder(String label)
	{
		super(label);
		
		labelText=new JLabel(label);
		
		super.setLayout(null);

		//labelText=new JLabel(label,SwingConstants.CENTER);
		
		//labelText.setBounds(1,1,boxWidth,textHeigth+height/2);
		
		//labelText.setForeground(Color.white);
		
		//super.add(labelText);

		Color himmelBlau=new Color(114,159,207);
		backGroundColor=himmelBlau;

		setTextSize(height/2);

		Point p=this.getLocation();
		//super.setBounds(p.x,p.y,boxWidth,height);
		setBounds(p.x,p.y,boxWidth,height);
	}
	
	public void setTextSize(int textSize)
	{
		this.textSize=textSize;
		Font labelFont = labelText.getFont();
		labelText.setFont(new Font(labelFont.getName(), Font.PLAIN, textSize));
	}
	
	@Override 
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		boxWidth=width;
		labelText.setBounds(0,0,boxWidth,textHeigth+height/2);
		setTextSize(height/2);
	}
	
	public void setWidth(int width)
	{
		Rectangle r=this.getBounds();
		setBounds(r.x, r.y, width, r.height);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen
		Rectangle r=this.getBounds();
		
		int k=2;
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(0, 0,r.width-2+k,r.height-2+k);
		g.setColor(Color.WHITE);
		g.drawRect(1, 1,r.width-4+k,r.height-4+k);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(2, 2,r.width-6+k,r.height-6+k);
		g.setColor(Color.GRAY);
		g.drawRect(3, 3,r.width-8+k,r.height-8+k);


	}

}