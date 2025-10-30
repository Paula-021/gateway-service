package com.gateway.service.gatewayservice.endpoints;

import com.gateway.service.gatewayservice.endpoints.dtos.GpsDataRequestDTO;
import com.gateway.service.gatewayservice.services.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.*;
import java.time.OffsetDateTime;

@RestController
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    @PostMapping("/forward/Data")
    public ResponseEntity<?> forwardData(@RequestBody GpsDataRequestDTO gpsDataRequestDTO) {
        try{
        String ipAddress = "200.123.156.18";
        int port = 5004;

        String header = ">RCQ01";

        //coventer data
        String deviceTimeString = gpsDataRequestDTO.getPosition().getDeviceTime();
        OffsetDateTime dateTime = OffsetDateTime.parse(deviceTimeString);
        String formattedDateTime = String.format("%02d%02d%02d%02d%02d%02d", dateTime.getDayOfMonth(), dateTime.getMonthValue(),
                dateTime.getYear() % 100, dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());

        String latitude = String.format("%.5f",  gpsDataRequestDTO.getPosition().getLatitude()).replace(".", "").replace(",", "");

            Double longitude = gpsDataRequestDTO.getPosition().getLongitude();

// Extrai a parte inteira
            int parteInteira = longitude.intValue();

// Extrai o sinal (positivo ou negativo)
            String sinal = longitude < 0 ? "-" : "";

// Pega o valor absoluto (sem sinal)
            double valorAbsoluto = Math.abs(longitude);

// Formata com 5 casas decimais
            String formatado = String.format("%.5f", valorAbsoluto);
            System.out.println(formatado);// exemplo: "57.56104"

// Divide parte inteira e decimal
            String[] partes = formatado.split(",");
            String inteira = partes[0];
            String decimal = partes[1];

// Se a parte inteira tiver só 2 dígitos, adiciona um zero à esquerda
            if (inteira.length() == 2) {
                inteira = "0" + inteira;
            }

// Junta tudo e adiciona o sinal
            String longitudeString = sinal + inteira + decimal;

            //System.out.println(longitudeString);

        int speedInt = (int) gpsDataRequestDTO.getPosition().getSpeed();
        String speed = String.format("%03d", speedInt);

        int courseInt = (int) gpsDataRequestDTO.getPosition().getCourse();
        String course = String.format("%03d", courseInt);

        boolean ignition = gpsDataRequestDTO.getPosition().getAttributes().isIgnition();
        String ignitionHexadecimal = ignition  ? "FF" : "7F";

        String ii = "00";

        int batteryLevel = gpsDataRequestDTO.getPosition().getAttributes().getBatteryLevel();
        String batteryLevelFormatted = String.format("%03d", batteryLevel);

        double totalDistance = gpsDataRequestDTO.getPosition().getAttributes().getTotalDistance();
        String totalDistanceFormatted = String.format("%08X", (int) totalDistance);

        String fixedSequence = "13020700011129;#0001;ID="+ gpsDataRequestDTO.getDevice().getUniqueId()+";*";

        String partialRCQ = header + formattedDateTime + latitude + longitudeString + speed + course +
                ignitionHexadecimal + ii + batteryLevelFormatted + totalDistanceFormatted + fixedSequence;



        String finalMessage = partialRCQ +
                gatewayService.getCheckSum(partialRCQ, partialRCQ.length()) + "<";

        gatewayService.sendUdpPacket(finalMessage, ipAddress, port);

            return ResponseEntity.ok().body(finalMessage);

        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
