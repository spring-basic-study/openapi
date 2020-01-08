package me.ohtaeg.domain.response;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Primary
public class Blog extends OpenApi implements Serializable {
    private static final long serialVersionUID = 1576360151347505333L;
}
