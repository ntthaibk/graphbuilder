package mdaq.google;

import lombok.Data;

@Data
public class DistancePair {
    private PlusCodeJunction origin;
    private PlusCodeJunction destination;

    public DistancePair(PlusCodeJunction origin, PlusCodeJunction destination) {
        this.origin = origin;
        this.destination = destination;
    }
}
