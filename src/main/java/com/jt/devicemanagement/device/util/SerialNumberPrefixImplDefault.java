package com.jt.devicemanagement.device.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("default")
@Component
public class SerialNumberPrefixImplDefault implements SerialNumberPrefix {
    @Value("${serialNumber.prefix.production}")
    private String prefix;

    @Override
    public String getPrefix() {
        return prefix;
    }
}
