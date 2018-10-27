package com.wipro.eb.entity;

public class Domestic extends connection {
	public Domestic(int currentReading, int previousReading,float slabs[])
	{ super(currentReading,previousReading,slabs);
		
	}
	public float computeBill()
	{
		float bill=0;
		int unit=0;
		int unit2=0;
			int units=currentReading-previousReading;
			if(units<=50)
			{
				bill=units*slabs[0];
				
			}
			else if(units<=100 && units>50)
			{
				unit=units-50;
						if(unit<50)
						 bill=(unit*slabs[1])+(50*slabs[0]);
						
			}
						else
						{
							unit2=units-100;
						bill=(50*slabs[0])+(50* slabs[1])+(unit2 *slabs[2]);
		}
			return bill;
			
		
	}

}
