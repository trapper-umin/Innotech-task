package innotech.com.controllers.interfaces;

import innotech.com.dto.requests.StringReqst;
import innotech.com.dto.responses.MapResp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IStringController {

    @GetMapping
    ResponseEntity<MapResp> countCharacters
            (@RequestBody @Valid StringReqst stringReqst,
             BindingResult bindingResult);
}
