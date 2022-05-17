package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class Service {

    private String productId;

    private String serviceId;


}
