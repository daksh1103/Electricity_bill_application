package com.wipro.eb.entity;

public abstract class connection {
	int previousReading;
	int currentReading;
	float[] slabs;
	
	public int getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(int previousReading) {
		this.previousReading = previousReading;
	}
	public int getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(int currentReading) {
		this.currentReading = currentReading;
	}
	public float[] getSlabs() {
		return slabs;
	}
	public void setSlabs(float[] slabs) {
		this.slabs = slabs;
	}
	public connection(int currentRead, int previousRead,float slab[])
	{
		currentReading=currentRead;
		previousReading=previousRead;
		slabs=slab;
	}
	public abstract float computeBill();
	
}


