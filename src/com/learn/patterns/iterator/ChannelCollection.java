package com.learn.patterns.iterator;

public interface ChannelCollection {

	void addChannel(Channel c);

	void removeChannel(Channel c);

	ChannelIterator iterator(ChannelTypeEnum type);
}
