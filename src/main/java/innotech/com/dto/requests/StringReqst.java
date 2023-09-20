package innotech.com.dto.requests;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class StringReqst {

    /**
     *
     *   min size=1, требуется хотя бы один символ
     *
     */
    @Size(min = 1, message = "minimum length is 1 character")
    private String string;

    public StringReqst(){}

    public static class Builder{
        private final StringReqst stringReqst=new StringReqst();

        public Builder string(String string){
            stringReqst.string=string;
            return this;
        }

        public StringReqst build(){
            return stringReqst;
        }
    }


}
