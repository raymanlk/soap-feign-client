package com.soap.client;

import com.soap.client.wsdl.GetCountryRequest;
import com.soap.client.wsdl.GetCountryResponse;
import com.soap.client.wsdl.Country;
import feign.Feign;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @GetMapping(path="/view")
    @ResponseBody
    public ResponseEntity<Country> getJSON(@RequestParam String country) {
        WebServiceCallInterface myWebServiceCallInterface = Feign.builder()
                .target(WebServiceCallInterface.class, "http://localhost:8080/ws/countries");
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        GetCountryResponse response = myWebServiceCallInterface.get(request);
        return new ResponseEntity<>(response.getCountry(), HttpStatus.OK);
    }
}
