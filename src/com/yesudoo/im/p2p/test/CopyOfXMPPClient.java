package com.yesudoo.im.p2p.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamListener;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamSession;
import org.jivesoftware.smackx.filetransfer.FileTransferListener;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.FileTransferNegotiator;
import org.jivesoftware.smackx.filetransfer.FileTransferRequest;
import org.jivesoftware.smackx.filetransfer.IncomingFileTransfer;
import org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer;

public class CopyOfXMPPClient {
	private static final String targetJID = "testej@yesudoo.test";
	private static final int BUFFER_SIZE = 1000;

	public static void main(String[] args) {
		ConnectionConfiguration config = new ConnectionConfiguration(
				"192.168.1.139", 5222);
		config.setCompressionEnabled(true);
		config.setSASLAuthenticationEnabled(true);
		config.setServiceName("yesudoo.test");
		SmackConfiguration.setLocalSocks5ProxyPort(7779);// diff from the original
		Socks5BytestreamManager sock5manager;
		Connection connection = new XMPPConnection(config);
		// Connect to the server
		try {
			connection.connect();

			// Log into the server

			connection.login("dyr2", "dyr2", "SomeResource");
			
			
			
			
			

			FileTransferNegotiator.setServiceEnabled(connection, true);
			System.out.println(connection.getServiceName());
			sock5manager = Socks5BytestreamManager.getBytestreamManager(connection);
			sock5manager.addIncomingBytestreamListener(new Socks5BytestreamListener() {
				
				@Override
				public void incomingBytestreamRequest(Socks5BytestreamRequest request) {
					// TODO Auto-generated method stub
					System.out.println(request.getFrom());
					Socks5BytestreamSession sock5session;
					InputStream in;
					OutputStream out;
					try {
						sock5session = request.accept();
						in = sock5session.getInputStream();
						out = new FileOutputStream("/home/yesudoodevh/dyrShare/test.txt");
						writeToStream(in, out);
						out.flush();
						out.close();
						in.close();
						sock5session.close();
					} catch (XMPPException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		ChatManager chatmanager = connection.getChatManager();
		Chat newChat = chatmanager.createChat(targetJID, new MessageListener() {
			public void processMessage(Chat chat, Message message) {
				System.out.println("copy Received message: "
						+ message.getBody());
			}
		});
		final FileTransferManager manager = new FileTransferManager(connection);
		// Create the listener
		manager.addFileTransferListener(new FileTransferListener() {
			public void fileTransferRequest(FileTransferRequest request) {
				
				System.out.println("File received from: \t"+request.getRequestor());
				System.out.println("Filename: \t"+request.getFileName());
				System.out.println("Filesize: \t"+request.getFileSize());
				System.out.println("Description: \t"+request.getDescription());
				// Check to see if the request should be accepted
				if (request.getFileSize() > 1000) {
					// Accept it
					IncomingFileTransfer transfer = request.accept();
					try {
						transfer.recieveFile(new File(request.getFileName()));
					} catch (XMPPException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					// Reject it
					request.reject();
					System.out.println("file is too small");
				}
			}
		});

		try {
			boolean quitFlag = false;
			Scanner sc = new Scanner(System.in);
			String cmd = "";
			while (!quitFlag) {
				cmd = sc.nextLine();
				if (cmd.equals("quit")) {
					quitFlag = true;
				} else if (cmd.equals("file")) {
					
					// Create the outgoing file transfer
					OutgoingFileTransfer transfer = manager
							.createOutgoingFileTransfer(targetJID+"/SomeResource");
					// Send the file
					transfer.sendFile(
							new File("/home/yesudoodevh/test.txt"),
							"You won't believe this!");
				} else {
					newChat.sendMessage(cmd);
				}
			}
			sc.close();
		} catch (XMPPException e) {
			System.out.println("Error Delivering block");
		}

		// Disconnect from the server
		connection.disconnect();
	}
	private static int amountWritten;
	protected static void writeToStream(final InputStream in, final OutputStream out)
			throws XMPPException
    {
		final byte[] b = new byte[BUFFER_SIZE];
		int count = 0;
		amountWritten = 0;

        do {
			// write to the output stream
			try {
				out.write(b, 0, count);
			} catch (IOException e) {
				throw new XMPPException("error writing to output stream", e);
			}

			amountWritten += count;

			// read more bytes from the input stream
			try {
				count = in.read(b);
			} catch (IOException e) {
				throw new XMPPException("error reading from input stream", e);
			}
		} while (count != -1);

		
	}
}