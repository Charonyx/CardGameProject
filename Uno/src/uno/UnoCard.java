/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author USER
 */
public class UnoCard {

    public enum Color {
        Red, Blue, Yellow, Green, Wild;

    }

    public enum Value {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine,
        PlusTwo, Reverse, Skip, Wild, WildFour;
        
    }

    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setValue(Value value) {
        this.value = value;
    }
    Value value;
    public Color[] colors = Color.values();
    public Value[] values = Value.values();

    public UnoCard() {
    }

    public UnoCard(Color color, Value value) {

        this.color = color;
        this.value = value;

    }

    public UnoCard.Color getColor() {
        return color;
    }

    public UnoCard.Value getValue() {
        return value;
    }

    public UnoCard.Value getValue(int i) {
        return values[i];
    }
    
    public UnoCard.Color getColor(int i ){
        return colors[i];
    }
    
    @Override
    public String toString() {
        return "UnoCard [ Color :" + color + " , value :" + value + "]";
    }

    public int cardValue(UnoCard.Value cardValue){
        if(cardValue == Value.PlusTwo || cardValue == Value.Wild || cardValue == value.WildFour){
            return 10;
        }
        else{
            return cardValue.ordinal();
        }
    }
    public int getColorToInt(){
            return color.ordinal();
    }
    public int getValueToInt(int i){
            return this.values[i].ordinal();
    }
    
    public int getValueToInt(){
            return this.value.ordinal();
    }
    
    public void setColorAndValue(UnoCard.Color color ,UnoCard.Value value){
        this.color = color;
        this.value = value;
    }
    
}
