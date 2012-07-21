package me.kukkii.cointoss;


public enum Coin{

  HEAD(0),
  TAIL(1),
  UNKNOWN(-1);

  private int value;

  private Coin(int value){
    this.value = value;
  }

  public int value(){
    return value;
  }

  public static Coin get(int value){
    switch (value % 1) {
    case 0 :
      return HEAD;
    case 1 :
      return TAIL;
    default :
      return UNKNOWN;  
    }  
  }
}
