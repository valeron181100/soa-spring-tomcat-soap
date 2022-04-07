package valeron.bondar.utils;

import io.spring.guides.gs_producing_web_service.CoordinatesDTO;
import io.spring.guides.gs_producing_web_service.FuelType;
import io.spring.guides.gs_producing_web_service.VehicleDTO;
import io.spring.guides.gs_producing_web_service.VehicleType;
import valeron.bondar.model.Vehicle;
import valeron.bondar.model.VehicleFields;

import java.util.ArrayList;
import java.util.List;

public class VehicleUtils {
    public static String getFindAllVehiclesString(Integer startIndex, Integer maxResults, VehicleFields sortField, boolean isDistinctOrder, String filters) {
        if (filters == null)
            filters = "";
        String orderStr = isDistinctOrder ? " desc" : "";

        String limits = "";
        if (startIndex != null)
            limits += " OFFSET " + startIndex + " ";
        if (maxResults != null) {
            limits += " LIMIT " + maxResults + " ";
        }

        return "select * from vehicle" + limits + filters + " order by " + sortField.getFieldName() + orderStr;
    }
    public static VehicleDTO toVehicleDTO(Vehicle vehicle) {
        CoordinatesDTO coordinatesDTO = new CoordinatesDTO();
        coordinatesDTO.setYCoord(vehicle.getCoordinates().getyCoord());
        coordinatesDTO.setXCoord(vehicle.getCoordinates().getxCoord());
        coordinatesDTO.setId(vehicle.getCoordinates().getId());
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setType(VehicleType.fromValue(vehicle.getType().toString()));
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setName(vehicle.getName());
        vehicleDTO.setFuelType(FuelType.fromValue(vehicle.getFuelType().toString()));
        vehicleDTO.setCoordinates(coordinatesDTO);
        vehicleDTO.setCreationDate(vehicle.getCreationDate().toString());
        vehicleDTO.setEnginePower((int)vehicle.getEnginePower());
        vehicleDTO.setNumberOfWheels((int)vehicle.getNumberOfWheels());
        return vehicleDTO;
    }

    public static List<VehicleDTO> toVehicleDTOList(List<Vehicle> vehicles) {
        List<VehicleDTO> resultList = new ArrayList<>();
        vehicles.forEach(p -> resultList.add(toVehicleDTO(p)));
        return resultList;
    }
}
