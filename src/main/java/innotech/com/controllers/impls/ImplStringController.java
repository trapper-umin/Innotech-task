package innotech.com.controllers.impls;

import innotech.com.controllers.interfaces.IStringController;
import innotech.com.dto.requests.StringReqst;
import innotech.com.dto.responses.MapResp;
import innotech.com.service.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@RequiredArgsConstructor
public abstract class ImplStringController implements IStringController {

    private final StringService service;

    @Override
    public ResponseEntity<MapResp> countCharacters(StringReqst stringReqst, BindingResult bindingResult) {
        return service.countCharacters(stringReqst, bindingResult);
    }
}
