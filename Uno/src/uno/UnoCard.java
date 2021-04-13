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

    enum color {
        Red, Blue, Yellow, Green, Wild;
        private static final Color[] color = Color.value();

        public static Color getColor(int i) {
            return Color.color[i];
        }
    }

    enum value {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Reverse, Skip, WildFour;
        private static final Value[] value = Value.value();

        public static Value getValue(int i) {
            return Value.value[i];
        }
    }
}
