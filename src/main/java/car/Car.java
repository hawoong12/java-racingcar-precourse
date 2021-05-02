package car;

public class Car {

  private String name;
  private int position;

  @Override
  public String toString() {
    return "Car{" +
        "name='" + name + '\'' +
        ", position=" + position +
        '}';
  }

  public Car() {
  }

  public Car(int position) {
    this.position = position;
  }

  public Car(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }
}
