package com.hapangama.carshop.dto;

import com.hapangama.carshop.domian.User;
import com.hapangama.carshop.util.VehicleBrand;
import com.hapangama.carshop.util.VehicleType;
import lombok.Data;

@Data
public class InquiryDto {
    private User user;
    private VehicleBrand preferredBrand;
    private VehicleType preferredType;
    private String preferredYear;
}
