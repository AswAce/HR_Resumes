package hr.platform.model.bindingModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResultBindingModel {

    private String testName;
    private List<SingleScoreBindingModel> scores = new ArrayList<>();
}
