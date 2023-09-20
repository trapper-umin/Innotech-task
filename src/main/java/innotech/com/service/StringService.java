package innotech.com.service;

import innotech.com.dto.requests.StringReqst;
import innotech.com.dto.responses.MapResp;
import innotech.com.util.exception.NotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StringService {
    public ResponseEntity<MapResp> countCharacters(StringReqst stringReqst,
                                                   BindingResult bindingResult) {

        validation(bindingResult);

        Map<Character,Integer> symbolQuantity = new HashMap<>();

        for (char c : stringReqst.getString().toCharArray()) {
            symbolQuantity.put(c, symbolQuantity.getOrDefault(c, 0) + 1);
        }

        return ResponseEntity.ok(
                new MapResp
                        .Builder()
                        .result(sortedMap(symbolQuantity))
                        .build()
        );
    }

    private Map<Character,Integer> sortedMap(Map<Character,Integer> map){
        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private void validation(BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            StringBuilder message=new StringBuilder();
            FieldError error=bindingResult.getFieldError();

            if (error != null) {
                message
                        .append(error.getField())
                        .append(": ")
                        .append(error.getDefaultMessage());
            }

            throw new NotValidException(message.toString());
        }
    }
}
