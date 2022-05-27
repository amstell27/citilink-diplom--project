package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import models.service.SubItemsModel;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductModel {

    @JsonProperty("1617484")
    private SubItemsModel product;

    @JsonProperty("420251")
    private ProductInformation productInformation;
}
