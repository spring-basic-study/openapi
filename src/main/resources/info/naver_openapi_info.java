package info;


import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
@ConfigurationProperties(prefix = "naver.openapi")
public class naver_openapi_info {
	@Getter @Setter
	private String blogUrl;
	@Getter @Setter 
	private String movieUrl;
	@Getter @Setter
    private String clientId;	
	@Getter @Setter
    private String clientSecret;

	
}
