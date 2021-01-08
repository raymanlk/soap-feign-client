package com.soap.client;

import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import com.soap.client.wsdl.GetCountryRequest;
import com.soap.client.wsdl.GetCountryResponse;

public interface WebServiceCallInterface {
    @RequestLine("POST")
    @Headers({"Content-Type: text/xml"})
    GetCountryResponse get(@RequestBody GetCountryRequest addRequest);
}