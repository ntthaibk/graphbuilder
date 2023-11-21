package mdaq.google;

import lombok.Data;

@Data
public class PlusCodeJunction {
    private String junctionName;
    private String plusCode;

    public PlusCodeJunction(String junctionName, String plusCode) {
        this.junctionName = junctionName;
        this.plusCode = plusCode;
    }
}
