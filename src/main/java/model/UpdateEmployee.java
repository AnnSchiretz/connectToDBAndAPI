package model;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UpdateEmployee {

    @Expose
    String name;
    @Expose
    String job;
    @Expose
    String updatedAt;

}
