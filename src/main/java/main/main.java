package main;

import car.Car;
import java.util.List;
import util.Util;

public class main {

  public static void main(String[] args) {
    Util util = new Util();
    List<Car> carList = null;

    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
    carList = util.makeCarList(util.inputed_carName_split(util.scanningInputString()));
    System.out.println("시도할 회수는 몇회인가요?");
    int count = Integer.parseInt(util.scanningInputString());

    System.out.println("\n\n\n\n실행 결과");
    for (int i = 0; i < count; i++) {
      carList = util.positionMoveForward(carList);
      util.printCarPosition(carList);
      System.out.println("\n\n");
    }
    util.findTheWinner(carList);
    util.winnerPrint();
  }
}
