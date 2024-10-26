package com.frontend;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.request.*;

public class Frontend {
    public static final String sequencerIP = "192.168.137.89";
    public static final int sequencerPort = 2233;

    public static void main(String[] args) {
            FrontendImpl feImpl = new FrontendImpl();
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/frontend?wsdl", feImpl);
        System.out.println("Frontend server is published: " + endpoint.isPublished());

        //TODO: Assign port numbers to all devices
        Runnable thread1 = new FrontendThread(44553, feImpl); //this port is frontend's



        Executor executor = Executors.newFixedThreadPool(1);
        executor.execute(thread1);
    }
}