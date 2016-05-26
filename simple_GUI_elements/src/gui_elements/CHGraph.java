package gui_elements;
import java.awt.Color;
import java.awt.Graphics;




public class CHGraph extends CHObject 
{
	private int xAchsePos;
	private int yAchsePos;
	private int xDimension=300;
	private int yDimension=200;
	
	double daten[];
	int dataSize=100;
	
	double scalex=1;
	double scaley=50;
	double xMax=10000;
	double xMin=0;
	
	public CHGraph(String graphName)
	{
		super(graphName);
		this.add(labelText);
		
		daten=new double[dataSize];

		xAchsePos=yDimension/2;
		yAchsePos=40;
		
		// test data
		for(int n=0;n<dataSize;n++)daten[n]=Math.sin((double)n/5);
		xMax=dataSize;
		
		scalex=xDimension/(xMax-xMin);
		
		width=xDimension;
		heigth=yDimension;
		super.setBounds(next_xPosition,next_yPosition,width,heigth);
		next_yPosition+=heigth;
	}
	
	@Override 
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // original paintComponent aus JPanel aufrufen
		g.setColor(Color.blue);
		
		double y=0;

			for(int n=0;n<(dataSize-2);n++)
			{

				int p1x=(int)(n*scalex);
				int p1y=(int)(daten[n]*scaley);
				int p2x=(int)((n+1)*scalex);
				int p2y=(int)(daten[n+1]*scaley);
				
				g.drawLine(yAchsePos+p1x,xAchsePos-p1y,yAchsePos+p2x,xAchsePos-p2y);
				y=daten[n+1];
			}


		// draw axis
		g.setColor(Color.gray);
		g.drawLine(0,xAchsePos,xDimension,xAchsePos);
		g.drawLine(yAchsePos,0,yAchsePos,yDimension);

		// Beschriftung
		//g.drawString(""+y, xDimension/2, 10 );

		//g.drawString(""+y, 0, xAchsePos);
	}
}
