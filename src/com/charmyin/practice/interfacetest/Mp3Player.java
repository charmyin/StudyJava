package com.charmyin.practice.interfacetest;

import org.junit.Test;

public class Mp3Player implements USB {

	@Override
	public void readData() {
		
	}
	String version = "aaa";
	@Test
	public void testInterface(){
		Mp3Player mp3 = new Mp3Player();
		if(mp3 instanceof USB){
			System.out.println("本播放器支持usb！");
		}
		System.out.println("usb版本号为：" + version);
		
	}

}
