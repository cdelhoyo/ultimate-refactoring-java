package replacePrimitiveConstantsWithType;

public class QualityCalculator {
    private int score = 0;

    public void rateLocation(Quality quality){
        if (quality.isExcellent()){
            score += 10;
        }
        if (quality.isGood()){
            score += 7;
        }
        if (quality.isBad()){
            score -= 2;
        }
        if (quality.isTerrible()){
            score -= 10;
        }
    }

    public void rateFacilities(Quality quality){
        if (quality.isExcellent()){
            score += 2;
        }
        if (quality.isGood()){
            score += 1;
        }
        if (quality.isBad()){
            score -= 1;
        }
        if (quality.isTerrible()){
            score -= 2;
        }
    }

    public int getScore() {
        return score;
    }
}
