package mdaq.google;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinator {
    private PlusCodeJunction origin;
    private PlusCodeJunction destination;
    private long distance;

    public Coordinator(PlusCodeJunction originPlusCode, PlusCodeJunction destinationPlusCode) {
        this.origin = originPlusCode;
        this.destination = destinationPlusCode;
    }

}
