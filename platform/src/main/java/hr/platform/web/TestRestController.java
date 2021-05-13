package hr.platform.web;

import hr.platform.model.bindingModel.TestResultBindingModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class TestRestController {

// TODO: 04-May-21 We have the data in JavaScrip JSon we need to organise it and send it to the controller 


    @PostMapping(value = "english", consumes = "application/json")
    public ResponseEntity<TestResultBindingModel> englishScore(@RequestBody TestResultBindingModel tests
    ) {
        System.out.println();

        return ResponseEntity.ok()
                .build();


    }
}
