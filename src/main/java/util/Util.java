package util;

import car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

  List<Car> LargestCarList = new ArrayList<>();

  public String scanningInputString() {
    Scanner scn = new Scanner(System.in);
    return scn.nextLine();
  }

  public String[] inputed_carName_split(String inputString) {
    String[] carNames = inputString.split(",");
    return carNames;
  }

  public String checkNameLength(String carName) {
    if (carName.length() > 5) {
      System.out.println(carName + "  자동차 이름의 길이는 5자까지만 가능합니다.");
      return "";
    }
    return carName;
  }

  public boolean checkBoolean(String name) {
    if (checkNameLength(name).equals("")) {
      return false;
    }

    return true;
  }

  public List<Car> makeCarList(String[] carNames) {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < carNames.length; i++) {
      addCar(carNames[i], carList);
    }
    return carList;
  }

  public void addCar(String carName, List<Car> carList) {
    if (checkBoolean(carName)) {
      Car car = new Car(carName, 0);
      carList.add(car);
    }
  }

  public int getRandomNumber() {
    return (int) (Math.random() * 9) + 1;
  }

  public int checkNumber(int number) {
    if (number >= 4) {
      return 1;
    }
    return 0;
  }

  public List<Car> positionMoveForward(List<Car> carList) {
    List<Car> tempCarList = new ArrayList<>();
    for (Car car : carList) {
      car.setPosition(car.getPosition() + checkNumber(getRandomNumber()));
      tempCarList.add(car);
    }
    return tempCarList;
  }

  public String returnHyphen(int number) {
    String hyphen = "";
    for (int i = 0; i < number; i++) {
      hyphen += "-";
    }
    return hyphen;
  }

  public void printCarPosition(List<Car> carList) {
    for (int i = 0; i < carList.size(); i++) {
      System.out
          .println(carList.get(i).getName() + " : " + returnHyphen(carList.get(i).getPosition()));
    }
  }

  public void findTheWinner(List<Car> carList) {
    Car tempCar = new Car(0);

    for (int i = 0; i < carList.size(); i++) {
      Car car = carList.get(i);
      tempCar = compareTwoCarPosition(tempCar, car);
    }
  }

  public void winnerPrint() {
    String winnerNames = "";
    for (int i = 0; i < LargestCarList.size(); i++) {
      Car car = LargestCarList.get(i);
      winnerNames = lastIndexIsNotContainComma(winnerNames, i, car);
      winnerNames = normalIndex(winnerNames, i, car);
    }
    System.out.println(winnerNames + "가 최종우승했습니다.");
  }

  public String normalIndex(String winnerNames, int i, Car car) {
    if (i < LargestCarList.size() - 1) {
      winnerNames += car.getName() + ", ";
    }
    return winnerNames;
  }

  public String lastIndexIsNotContainComma(String winnerNames, int i,
      Car car) {
    if (i == LargestCarList.size() - 1) {
      winnerNames += car.getName();
    }
    return winnerNames;
  }

  public Car compareTwoCarPosition(Car tempCar, Car car) {
    if (car.getPosition() >= tempCar.getPosition()) {
      samePositionIsAdd(tempCar, car);
      largestPositionIsRemoveAfterAdd(tempCar, car);
      tempCar = car;
    }
    return tempCar;
  }

  public void largestPositionIsRemoveAfterAdd(Car tempCar, Car car) {
    if (car.getPosition() > tempCar.getPosition()) {
      LargestCarList = new ArrayList<>();
      LargestCarList.add(car);
    }
  }

  public void samePositionIsAdd(Car tempCar, Car car) {
    if (car.getPosition() == tempCar.getPosition()) {
      LargestCarList.add(car);
    }
  }
}
