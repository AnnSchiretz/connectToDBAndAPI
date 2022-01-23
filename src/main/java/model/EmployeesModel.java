package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Data
@Getter
@Jacksonized
@AllArgsConstructor
@Builder
@JsonIgnoreProperties
public class EmployeesModel {

    @Expose
    @SerializedName("name")
    String name;
    @Expose
    @SerializedName("job")
    String job;

}
