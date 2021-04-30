/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author chura
 */
public class UnoCard {

    enum Color {
        Red, Blue, Yellow, Green, Wild;

        private static final Color[] color = Color.values();

        public static Color getColor(int i) {
            return Color.color[i];
        }
    }

    enum Value {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, PlusTwo, Reverse, Skip, Wild, WildFour;

        private static final Value[] value = Value.values();

        public static Value getValue(int i) {
            return Value.value[i];
        }
    }

    private final Color color;
    private final Value value;

    public UnoCard(final Color color, final Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UnoCard [color=" + color + ", value=" + value + "]";
    }

}
