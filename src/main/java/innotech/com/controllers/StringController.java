package innotech.com.controllers;

import innotech.com.controllers.impls.ImplStringController;
import innotech.com.service.StringService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0/string")
public class StringController extends ImplStringController {


    public StringController(StringService service) {
        super(service);
    }
}
