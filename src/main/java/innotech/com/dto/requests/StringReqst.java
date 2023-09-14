package innotech.com.dto.requests;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StringReqst {

    /**
     *
     *   min size=1, требуется хотя бы один символ
     *
     */
    @Size(min = 1, message = "minimum length is 1 character")
    private String string;

}
