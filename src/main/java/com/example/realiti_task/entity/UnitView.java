package com.example.realiti_task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitView {
	private int unitnumber;
	private boolean available;
	private String modelUuid;

}
