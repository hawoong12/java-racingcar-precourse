package util;

import static org.assertj.core.api.Assertions.assertThat;

import car.Car;
import car.Cars;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UtilTest {

  Util util = new Util();

  @Test
  public void should_input_String_return_StringArray() {
    String[] tempArray = util.inputed_carName_split("pobi,crong,honux");
    assertThat(tempArray.length > 0).isTrue();
  }

  @Test
  public void should_if_Length_IsMoreThan5_ReturnNull() {
    assertThat(util.checkNameLength("hawoong").equals("")).isTrue();
  }

  @Test
  public void should_if_Length_IsMoreThan5_ReturnFalse() {
    assertThat(util.checkBoolean("hawoong")).isFalse();
  }

  @Test
  public void should_if_LengthIsLessThan5_ReturnTrue() {
    assertThat(util.checkBoolean("hw")).isTrue();
  }

  @Test
  public void should_if_input_StringAndCar_Is_AddCarList() {
    String name = "Benz";
    Cars carList = new Cars();
    util.addCar(name, carList);
    assertThat(carList.get(0).getName()).isEqualTo(name);
  }

  @Test
  public void should_return_ten_under_0_upper_Number() {
    assertThat((util.getRandomNumber() > 0 && util.getRandomNumber() < 10)).isTrue();
  }

  @Test
  public void should_inputNumber_Is_4_underIsReturn0() {
    assertThat(util.checkNumber(3)).isEqualTo(0);
  }

  @Test
  public void should_inputNumber_Is_3_upperIsReturn1() {
    assertThat(util.checkNumber(4)).isEqualTo(1);
  }

  @Test
  public void should_return_normal_carList() {
    Cars carList = new Cars();
    carList.add(new Car("benz", 0));
    carList = util.positionMoveForward(carList);
    assertThat(carList.get(0).getName()).isEqualTo("benz");
  }

  @Test
  public void should_if_samePosition_Is_AddArray() {
    (util.LargestCarList).add(new Car("testCar", 5));
    Car car1 = (util.LargestCarList).get(0);
    Car car2 = new Car("car2", 5);
    util.samePositionIsAdd(car1, car2);
    assertThat((util.LargestCarList).size() == 2).isTrue();
  }

  @Test
  public void should_if_Which_Large_Position_Is_AloneArray() {
    (util.LargestCarList).add(new Car("testCar", 5));
    Car car1 = (util.LargestCarList).get(0);
    Car car2 = new Car("car2", 6);
    util.largestPositionIsRemoveAfterAdd(car1, car2);
    assertThat(
        (util.LargestCarList).size() == 1 && (util.LargestCarList).get(0).getName().equals("car2"))
        .isTrue();
  }

  @Test
  public void should_find_largest_Car_Position_return_car2() {
    Car car1 = new Car("car1", 2);
    Car car2 = new Car("car2", 3);
    assertThat(util.compareTwoCarPosition(car1, car2)).isEqualTo(car2);
  }
}
