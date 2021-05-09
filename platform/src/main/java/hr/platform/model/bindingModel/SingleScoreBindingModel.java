package hr.platform.model.bindingModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleScoreBindingModel {

    private String email;
    private String score;
}
