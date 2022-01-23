package model;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class JobUser {

    @Expose
    String name;
    @Expose
    String job;
    @Expose
    String id;
    @Expose
    String createdAt;
}
