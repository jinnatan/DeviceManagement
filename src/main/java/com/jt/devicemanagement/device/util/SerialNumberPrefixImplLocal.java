package com.jt.devicemanagement.device.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class SerialNumberPrefixImplLocal implements SerialNumberPrefix {
    @Override
    public String getPrefix() {
        return "local-";
    }
}