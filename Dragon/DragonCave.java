package Dragon;


/**
 * Класс Пещеры
 *
 *
 */

public class DragonCave{

    private float depth = 1.0F;//Поле может быть null

    public float getDepth() {
        return depth;
    }

    public void setDepth(Float num) {
        this.depth = num;
    }

    @Override
    public String toString() {
        if(depth <= 0){
            return "null";
        }
        return "" + depth;
    }


}

