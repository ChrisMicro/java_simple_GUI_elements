/*
============================================================================
Name        : ringBuffer.c
Author      : chris
Version     :
Copyright   : GPL lizense 3
              ( chris (at) roboterclub-freiburg.de )
Description : This ringBuffer overwrites circular the old values if
              the bufferSize is overflow.
              It is not a FIFO. 
              
History: original code was in C

============================================================================
*/

package gui_elements;


public class RingBuffer 
{
	double[] data;
	int bufferSize;
	int writePosition;
	int fillSize;
	
	public RingBuffer(int dataLength)
	{
		data=new double[dataLength];
		bufferSize=dataLength;
		writePosition = 0;
		fillSize      = 0;
	}
	
	public void add(double value)
	{
		ringBufferAdd(value);
	}
	public int getFillSize()
	{
		return fillSize;
	}
	
	public void setData(double[] data)
	{
		this.data=data;
		bufferSize=data.length;
		writePosition = 0;
		fillSize      = bufferSize;
	}
	
	public static double[] copyFromIntArray(int[] source) {
	    double[] dest = new double[source.length];
	    for(int i=0; i<source.length; i++) {
	        dest[i] = source[i];
	    }
	    return dest;
	}
	
	public void clear()
	{
		fillSize=0;
	}
	
	public void setData(int[] data)
	{
		this.data=copyFromIntArray(data);
		bufferSize=data.length;
		writePosition = 0;
		fillSize      = bufferSize;
	}
	
	public double[] getData()
	{
		double [] data=new double[fillSize];
		for(int n=0;n<fillSize;n++) ringBufGetValue(n);
		return data;
	}
	
	public RingBuffer(double[] data)
	{
		this.setData(data);
	}
	
	public RingBuffer(int[] data)
	{
		this.setData(data);
	}
	
	public void ringBufferAdd( double value)
	{
	 data[writePosition] = value;

	 writePosition++;
	 // wrap arround if overflow
	 if ( writePosition >= bufferSize ) writePosition = 0;  
	 
	 fillSize++;
	 // if buffer is full, no longer increase fillSize 
	 if(fillSize >= bufferSize) fillSize = bufferSize;
	}

	//read a value from position n relative to the current write position
	public double ringBufGetValue( int index)
	{
	 int pos;

	 pos = writePosition + index - fillSize;

	 // if wrap arround
	 if ( pos < 0 ) pos += bufferSize; 

	 return data[pos];
	}

	public int ringBufGetFillSize( )
	{
	 return fillSize;
	}

	public double getBufferSize() 
	{
		return bufferSize;
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




