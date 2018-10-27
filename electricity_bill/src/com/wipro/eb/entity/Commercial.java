package com.wipro.eb.entity;

public class Commercial extends connection {
	public Commercial(int currentReading, int previousReading,float slabs[])
	{
		super(currentReading,previousReading,slabs);
	}
	float duty=0;
	float pay=0;
	
	public float computeBill()
	{   float bill=0;
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
	if(bill>=10000)
	{
		duty=bill*0.09f;
		pay=bill+duty;
	}
	else if(bill>=5000)
	{
		duty=bill*0.06f;
		pay=bill+duty;
	}
	else
		duty=bill*0.02f;
	pay=bill+duty;
	return pay;
	}
		
	}

