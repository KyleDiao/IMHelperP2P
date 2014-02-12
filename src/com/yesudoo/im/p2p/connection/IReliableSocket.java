package com.yesudoo.im.p2p.connection;

public interface IReliableSocket {

	public int send(byte[] data, int length);

	public int recieve(byte[] data, int length);

	public void close();
}
