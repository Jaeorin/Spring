package com.cos.around.Model;

import lombok.Data;

@Data
public class HeartCountDTO implements Comparable<HeartCountDTO>{
	private int num;
	private int heartCount;
	
	
	
	@Override
	public int compareTo(HeartCountDTO hd) {
		int count1 = this.heartCount;
		int count2 = hd.getHeartCount();
		if(count1 < count2) {
			return -1;
		}else if(count1 > count2) {
			return 1;
		}
		return 0;
	}
}
