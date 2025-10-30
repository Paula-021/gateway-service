package com.gateway.service.gatewayservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

@Service
public class GatewayService {

    public void sendUdpPacket(String message, String ipAddress, int port) throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {

            byte[] data = message.getBytes();

            InetAddress ipAddressInet = InetAddress.getByName(ipAddress);

            DatagramPacket packet = new DatagramPacket(data, data.length, ipAddressInet, port); //pacote UDP

            socket.send(packet);

        }
    }

    public static String getCheckSum(String partialRCQ, int parse) {
        String hexadecimal = "";
        int c = 0;
        for (int i = 0; i < parse; i++) {
            char ch = partialRCQ.charAt(i);
            byte b1 = (byte) ch;
            c = c ^ b1;
            hexadecimal = Integer.toHexString(c);
            if (hexadecimal.length() < 2) {
                hexadecimal = "0" + hexadecimal;
            }
        }


        return hexadecimal.toUpperCase();
    }



}
