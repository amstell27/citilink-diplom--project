package models.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class ServiceInformation {
    private String id,
            name;
    private Integer amount,
            price;
}
