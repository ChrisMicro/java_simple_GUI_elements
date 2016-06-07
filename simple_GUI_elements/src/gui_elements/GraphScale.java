package gui_elements;

public class GraphScale 
{
	double min,max;
	double scale=1;
	double axisStartPosition=0;
	double maxAxis=1;
	
	public double getMin()
	{
		return min;
	}
	
	public double getMax()
	{
		return max;
	}
	
	public int getAxisWidthInPixel()
	{
		return (int)maxAxis;
	}
	
	public double signedCeilPercent(double x, double percent)
	{
		double faktor=percent/100;
		double temp;
		double sign=1;
		if(x<0) sign=-1;
		x=sign*x;
		temp=x/faktor;
		temp=Math.ceil(temp);
		temp=temp*faktor;
		temp=sign*temp;
		return temp;
	}
	
	public void setLimits(double min, double max, double axisWidthInPixel)
	{
		this.min=min;
		this.max=max;
		maxAxis=axisWidthInPixel;
		scale= (maxAxis-axisStartPosition)/(max-min);
	}
	
	public double getAutoScale(double []daten, double axisStartPosition, double axisWidth)
	{
		this.axisStartPosition=axisStartPosition;
		this.maxAxis=axisStartPosition+axisWidth;
		
		min=Double.MAX_VALUE;
		max=-Double.MAX_VALUE;
		for(int n=0;n<daten.length;n++)
		{
			double d=daten[n];
			min=Math.min(d, min);
			max=Math.max(d,max);
		}
		//System.out.println("min:"+min);
		//System.out.println("max:"+max);
		
		// quantize min and max

		double percent=10;

		min=signedCeilPercent(min, percent);

		max=signedCeilPercent(max, percent);
		
		
		scale= (maxAxis-axisStartPosition)/(max-min);
		return scale;
	}
	
	public int calculatePosition(double x)
	{
		return (int)( (x-min)*scale);
	}

	public static void main(String[] args) 
	{
		double[] daten ={1,2,3,-10,10};
		GraphScale gs=new GraphScale();
		System.out.println("scale:"+gs.getAutoScale(daten,0,100));
		System.out.println("pos:"+gs.calculatePosition(-10));
		System.out.println("pos:"+gs.calculatePosition(10));
	}
}
