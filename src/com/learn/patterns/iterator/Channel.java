package com.learn.patterns.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Channel {

	private double frequency;
	private ChannelTypeEnum TYPE;
}
