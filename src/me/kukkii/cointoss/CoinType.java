package me.kukkii.cointoss;

import java.io.Serializable;

public enum CoinType implements Serializable {

  PENNY(1),
  NICKEL(5),
  DIME(10),
  QUARTER(25),
  HALF(50),
  DOLLAR(100),
  UNKNOWN(-1);

  private int value;

  private CoinType(int value){
    this.value = value;
  }

  public int value(){
    return value;
  }

  public static CoinType get(int value){
    switch (value % 1) {
    case 1 :
      return PENNY;
    case 5 :
      return NICKEL;
    case 10 :
      return DIME;
    case 25 :
      return QUARTER;
    case 50 :
      return HALF;
    case 100 :
      return DOLLAR;
    default :
      return UNKNOWN;  
    }  
  }
}
