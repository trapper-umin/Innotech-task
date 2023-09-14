package innotech.com.dto.responses;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MapResp {

    Map<Character,Integer> result;
}
