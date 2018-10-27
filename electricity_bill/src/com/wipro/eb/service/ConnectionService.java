package com.wipro.eb.service;
import com.wipro.eb.entity.*;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;
public class ConnectionService {
	int flag=0;
	float ans=0;
	float k;
	float[] slabs=new float[3];
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		try
		{
	if((currentReading<0 )||( previousReading<0)||(currentReading<previousReading))
	{
		flag=-1;
		new InvalidReadingException().toString();
	}
	if(!(type.equals("Domestic")||type.equals("Commercial")))
		{
		flag=-2;
		new InvalidConnectionException().toString();
		
		}
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	if(flag==0)
		return true;
		else
	return false;
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		boolean hi=validate( currentReading,previousReading,type);
				if(hi)
				{
					if(type=="Domestic")
					{
						slabs[0]=2.3f;
						slabs[1]=4.2f;
						slabs[2]=5.5f;
						Domestic obj=new Domestic(currentReading, previousReading,slabs);
						ans=obj.computeBill();
					}
					if(type=="Commercial")
					{
						slabs[0]= 5.2f;
						slabs[1]=6.8f;
						slabs[2]=8.3f;
						Commercial obj= new Commercial(currentReading, previousReading, slabs);
						ans=obj.computeBill();
					}
					
					}
				if(flag==0)
				return ans;
				else 
				{ float p=flag;
				return p;
				}
		
	}
	public String generateBill(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		k=calculateBillAmt(currentReading,previousReading,type);
		if(k==-1)
			
			return "invalid data";
		else if(k==-2)
			return "invalid connection";
		else
		{
			StringBuilder sb=new StringBuilder();
			sb.append("amount to be paid");
		sb.append(k);
		String str=sb.toString();
		return str;
		}

}
}

