package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class ArtistModel {

    @SerializedName("ArtistId")
    int id;
    @SerializedName("Name")
    String artistName;

    public ArtistModel(Integer id, String name) {
        this.id = id;
        this.artistName = name;
    }


}
