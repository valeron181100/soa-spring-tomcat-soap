package valeron.bondar.controllers;


import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import valeron.bondar.exceptions.ResponseException;
import valeron.bondar.model.Coordinates;
import valeron.bondar.model.Vehicle;
import io.spring.guides.gs_producing_web_service.VehicleType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.LocalDateTime;
import java.util.Date;

import io.spring.guides.gs_producing_web_service.FuelType;
import valeron.bondar.model.Vehicles;
import valeron.bondar.services.WheelsIncreaseService;
import valeron.bondar.services.WheelsRangeService;
import valeron.bondar.utils.VehicleUtils;

@Endpoint
public class VehiclesEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


    @Autowired
    WheelsRangeService rangeService;

    @Autowired
    WheelsIncreaseService increaseService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addWheelsRequest")
    @ResponsePayload
    public AddWheelsResponse increaseWheels(@RequestPayload AddWheelsRequest request) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException, ResponseException {
        AddWheelsResponse response = new AddWheelsResponse();
        increaseService.increaseWheels(request.getVehicleId().intValue(), request.getWheels());
        response.setResponseCode(BigInteger.valueOf(200));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getVehicleRequest")
    @ResponsePayload
    public GetVehicleResponse getVehiclesInRange(@RequestPayload GetVehicleRequest request) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException, ResponseException {
        GetVehicleResponse response = new GetVehicleResponse();

        Vehicles vehiclesByNumberOfWheels = this.rangeService.getVehiclesByNumberOfWheels((int) request.getFrom(), (int) request.getTo());
        response.getVehicles().addAll(VehicleUtils.toVehicleDTOList(vehiclesByNumberOfWheels.getVehicle()));

        return response;
    }
}
