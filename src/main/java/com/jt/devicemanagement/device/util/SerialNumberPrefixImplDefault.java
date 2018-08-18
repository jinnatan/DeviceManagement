package com.jt.devicemanagement.device.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("default")
@Component
public class SerialNumberPrefixImplDefault implements SerialNumberPrefix {
    @Override
    public String getPrefix() {
        return "prod-";
    }
}
