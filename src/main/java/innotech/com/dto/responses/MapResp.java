package innotech.com.dto.responses;

import lombok.*;

import java.util.Map;

@Getter
@Setter
public class MapResp {

    Map<Character,Integer> result;

    public MapResp(){
    }

    public MapResp(Map<Character,Integer> result){
        this.result=result;
    }

    public static class Builder{
        private final MapResp mapResp=new MapResp();

        public Builder result(Map<Character,Integer> result){
            mapResp.result=result;
            return this;
        }

        public MapResp build(){
            return mapResp;
        }
    }
}
