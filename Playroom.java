import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Playroom {
  private List<Toy> toys;
  private double budget;

  public Playroom(double budget) {
    this.budget = budget;
    this.toys = new ArrayList<Toy>();
  }

  public void addToy(Toy toy) throws Exception {
    double totalCost = toys.stream().mapToDouble(t -> t.price).sum();
    if (totalCost + toy.price > budget) {
      throw new Exception("Budget exceeded! Cannot add new Toy: " + toy.name + "\nCurrent budget: " + this.budget + "\n Money needed: " + totalCost + toy.price);
    }
    toys.add(toy);
  }

  public void sortToysByPrice() {
    Collections.sort(toys, Comparator.comparingDouble(t -> t.price));
  }

  public List<Toy> findToysInPriceRange(double minPrice, double maxPrice) {
    List<Toy> foundToys = new ArrayList<Toy>();
    for (Toy toy : this.toys) {
      if (toy.price <= maxPrice && toy.price >= minPrice) {
        foundToys.add(toy);
      }
    }
    return foundToys;
  }

  public void printToys() {
    for (Toy toy : this.toys) {
      System.out.println(toy);
    }
  }

  public void printToys(List<Toy> toys) {
    for (Toy toy : toys) {
      System.out.println(toy);
    }
  }
}
