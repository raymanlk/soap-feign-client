package com.soap.client;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import feign.jaxb.JAXBContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientConfiguration {

    private static final JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
            .withMarshallerJAXBEncoding("UTF-8")
            .withMarshallerSchemaLocation("http://localhost:8080/ws/countries.wsdl")
            .build();

    @Bean
    public Encoder feignEncoder() {
        return new SOAPEncoder(jaxbFactory);
    }
    @Bean
    public Decoder feignDecoder() {
        return new SOAPDecoder(jaxbFactory);
    }
}
