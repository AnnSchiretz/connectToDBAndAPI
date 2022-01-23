package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Getter
@Jacksonized
@AllArgsConstructor
@Builder
@JsonIgnoreProperties
public class UserList {

    @Expose
    int page;
    @SerializedName("per_page")
    @Expose
    int perPage;
    @Expose
    int total;
    @SerializedName("total_pages")
    @Expose
    int totalPages;
    @Expose
    List<UserInSystem> data;
}
