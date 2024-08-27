package com.example.realiti_task.entity;

public class Unit {
	private int unitnumber;
	private int floornumber;
	private int blocknumber;
	private boolean available;
	private String modelUuid;

	// Getters and setters omitted for brevity
	public int getUnitnumber() {
		return unitnumber;
	}

	public void setUnitnumber(int unitnumber) {
		this.unitnumber = unitnumber;
	}

	public int getFloornumber() {
		return floornumber;
	}

	public void setFloornumber(int floornumber) {
		this.floornumber = floornumber;
	}

	public int getBlocknumber() {
		return blocknumber;
	}

	public void setBlocknumber(int blocknumber) {
		this.blocknumber = blocknumber;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getModelUuid() {
		return modelUuid;
	}

	public void setModelUuid(String modelUuid) {
		this.modelUuid = modelUuid;
	}

}
