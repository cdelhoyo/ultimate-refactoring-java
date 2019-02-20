package replacePrimitiveConstantsWithType;

import java.util.Objects;

public class Quality {
    private final static String Excellent = "Excellent";
    private final static String Good = "Good";
    private final static String Bad = "Bad";
    private final static String Terrible = "Terrible";

    private String quality;

    private Quality(String quality) {
        this.quality = quality;
    }

    public static Quality Excellent() {
        return new Quality(Excellent);
    }

    public static Quality Good() {
        return new Quality(Good);
    }

    public static Quality Bad() {
        return new Quality(Bad);
    }

    public static Quality Terrible() {
        return new Quality(Terrible);
    }

    public static Quality createQuality(Quality quality) {
        return quality;
    }

    public String getQuality() {
        return quality;
    }

    public boolean isExcellent() {
        return Objects.equals(quality, Excellent);
    }

    public boolean isTerrible() {
        return Objects.equals(quality, Terrible);
    }

    public boolean isGood() {
        return Objects.equals(quality, Good);
    }

    public boolean isBad() {
        return Objects.equals(quality, Bad);
    }
}
