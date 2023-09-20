package innotech.com.dto.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResp {

    private String message;

    public static class Builder{
        private final ErrorResp errorResp=new ErrorResp();

        public Builder message(String string){
            errorResp.message=string;
            return this;
        }

        public ErrorResp build(){
            return errorResp;
        }
    }
}
