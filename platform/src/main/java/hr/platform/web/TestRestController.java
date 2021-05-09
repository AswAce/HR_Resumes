package hr.platform.web;

import com.fasterxml.jackson.databind.node.ObjectNode;
import hr.platform.model.bindingModel.TestResultBindingModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
public class TestRestController {

// TODO: 04-May-21 We have the data in JavaScrip JSon we need to organise it and send it to the controller 


    @PostMapping(value="/english",consumes = "application/json")
    public void englishScore(@RequestBody TestResultBindingModel json
    ) {
        System.out.println();

//        return ResponseEntity.ok()
//                .build();


    }
}
