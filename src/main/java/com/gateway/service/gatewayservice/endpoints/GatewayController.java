package com.gateway.service.gatewayservice.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.*;

@RestController
public class GatewayController {

    @GetMapping("/forward/Data")
    public ResponseEntity<?> forwardData(@RequestParam Long id, @RequestParam String code, @RequestParam String gprmc) {
        String ipDestino = "http://200.123.156.18";
        int portaDestino = 5004;

        try (DatagramSocket socket = new DatagramSocket()) {
            String mensagem = id + "/" + code + "/" + gprmc;

            byte[] dados = mensagem.getBytes();

            InetAddress ipDestinoInet = InetAddress.getByName(ipDestino);

            DatagramPacket packet = new DatagramPacket(dados, dados.length, ipDestinoInet, portaDestino);

            socket.send(packet);

            return ResponseEntity.ok().body(mensagem);

        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
