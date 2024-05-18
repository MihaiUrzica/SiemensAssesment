package com.urzica_mihai.siemens_assesment.service;

import com.urzica_mihai.siemens_assesment.dao.entity.HotelEntity;
import com.urzica_mihai.siemens_assesment.utils.GeographicalPoint;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

@Service
@NoArgsConstructor
public class LocationService {

    private static final String AMAZON_CHECK_IP_URL = "http://checkip.amazonaws.com/";
    private static final String GEOLOCATION_BY_IP_URL = "http://ip-api.com/json/";
    private static final String GEOLOCATION_REQUEST_PARAMS = "?fields=lat,lon";
    private static final int EARTH_RADIUS_IN_METERS = 6371000;

    public double distanceFromHotel(HotelEntity hotel) throws IOException {
        GeographicalPoint startPoint = getUserPosition();
        GeographicalPoint endPoint = new GeographicalPoint(hotel.getLatitude(),hotel.getLongitude());

        double startPointLatRadian = Math.toRadians(startPoint.getLatitude());
        double startPointLongRadian = Math.toRadians(startPoint.getLongitude());
        double endPointLatRadian = Math.toRadians(endPoint.getLatitude());
        double endPointLongRadian = Math.toRadians(endPoint.getLongitude());

        double latitudeDifference = endPointLatRadian - startPointLatRadian;
        double longitudeDifference = endPointLongRadian - startPointLongRadian;

        double a = Math.sin(latitudeDifference / 2) * Math.sin(latitudeDifference / 2) +
                Math.cos(startPointLatRadian) * Math.cos(endPointLatRadian) * Math.sin(longitudeDifference / 2)
                        * Math.sin(longitudeDifference / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_IN_METERS * c;
    }

    private GeographicalPoint getUserPosition() throws IOException {

        URL url = new URL(AMAZON_CHECK_IP_URL);
        BufferedReader ipFindBr = new BufferedReader(new InputStreamReader(url.openStream()));
        String myIpAddress = ipFindBr.readLine();
        ipFindBr.close();

        URL locationURL = new URL(GEOLOCATION_BY_IP_URL + myIpAddress + GEOLOCATION_REQUEST_PARAMS);
        BufferedReader locationFindBr = new BufferedReader(new InputStreamReader(locationURL.openStream()));
        String result = locationFindBr.readLine();
        locationFindBr.close();

        JSONObject jsonObject = new JSONObject(result);
        BigDecimal latitude = (BigDecimal) jsonObject.get("lat");
        BigDecimal longitude = (BigDecimal) jsonObject.get("lon");

        double lat = latitude.doubleValue();
        double lon = longitude.doubleValue();

        return new GeographicalPoint(lat, lon);
    }

}
