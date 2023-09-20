package innotech.com.service;

import innotech.com.dto.requests.StringReqst;
import innotech.com.dto.responses.MapResp;

import innotech.com.util.exception.NotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import static org.junit.jupiter.api.Assertions.*;

public class StringServiceTest {

    private StringService stringService;

    @BeforeEach
    public void setUp() {
        stringService = new StringService();
    }

    @Test
    public void testCountCharacters() {

        StringReqst stringReqst = new StringReqst
                .Builder()
                .string("aabbc")
                .build();

        BindingResult bindingResult = new BeanPropertyBindingResult(stringReqst, "stringReqst");

        ResponseEntity<MapResp> responseEntity = stringService.countCharacters(stringReqst, bindingResult);
        MapResp mapResp = responseEntity.getBody();

        assertNotNull(responseEntity);
        assertNotNull(mapResp);
        assertEquals(2, mapResp.getResult().get('a'));
        assertEquals(2, mapResp.getResult().get('b'));
        assertEquals(1, mapResp.getResult().get('c'));
    }

    @Test
    public void testValidation() {

        StringReqst stringReqst = new StringReqst
                .Builder()
                .string("valid string")
                .build();

        BindingResult bindingResult = new BeanPropertyBindingResult(stringReqst, "stringReqst");
        bindingResult.addError(new FieldError("stringReqst", "string", "Should be not empty"));

        try {
            stringService.countCharacters(stringReqst, bindingResult);
            fail("Expected NotValidException to be thrown");
        } catch (NotValidException e) {
            assertNotNull(e.getMessage());
            assertEquals("string: Should be not empty", e.getMessage());
        }
    }
}
