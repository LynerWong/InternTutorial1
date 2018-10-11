package intern.tutorial.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Parameter {

    @JsonProperty("param1")
    private List<String> param1;

    @JsonProperty("param2")
    private Param2 param2;
}
