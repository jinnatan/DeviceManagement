package com.jt.devicemanagement.device.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class SerialNumberPrefixImplLocal implements SerialNumberPrefix {
    @Value("${serialNumber.prefix.local}")
    private String prefix;

    @Override
    public String getPrefix() {
        return prefix;
    }
}