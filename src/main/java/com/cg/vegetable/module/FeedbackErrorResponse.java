package com.cg.vegetable.module;

import lombok.Data;

@Data
public class FeedbackErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
}
