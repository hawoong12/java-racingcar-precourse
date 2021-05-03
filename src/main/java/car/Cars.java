package car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
  private List<Car> cars = new ArrayList<>();

  public Cars() {
  }

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public void add(Car car){
    cars.add(car);
  }

  public int size(){
    return cars.size();
  }

  public Car get(int i){
    return cars.get(i);
  }
}
