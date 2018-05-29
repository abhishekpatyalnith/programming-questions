package com.learn.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChannelCollectionImpl implements ChannelCollection {

	private List<Channel> channelList;
	
	public ChannelCollectionImpl() {
		this.channelList = new ArrayList<>();
	}

	@Override
	public void addChannel(Channel c) {
		this.channelList.add(c);
	}

	@Override
	public void removeChannel(Channel c) {
		this.channelList.remove(c);
	}

	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, this.channelList);
	}

	private class ChannelIteratorImpl implements ChannelIterator {

		private ChannelTypeEnum type;
		private List<Channel> channels;
		private int position;

		public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> c) {
			this.type = type;
			this.channels = c;
		}

		@Override
		public boolean hasNext() {
			while (position < channels.size()) {
				if (channels.get(position).getTYPE().equals(type)) {
					return true;
				} else {
					position++;
				}
			}
			return false;
		}

		@Override
		public Channel next() {
			Channel c = channels.get(position);
			position++;
			return c;
		}

	}
}
