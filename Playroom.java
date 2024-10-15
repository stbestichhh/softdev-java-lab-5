import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 * Playroom class
 */
public class Playroom {
  private List<Toy> toys;
  private double budget;

  /**
   * Constructor
   *
   * @param budget
   */
  public Playroom(double budget) {
    this.budget = budget;
    this.toys = new ArrayList<Toy>();
  }

  /**
   * Adds new toy to the playroom if it is not out of budget
   *
   * @param toy Any class inherited from Toy
   * @return void
   */
  public void addToy(Toy toy) throws Exception {
    double totalCost = toys.stream().mapToDouble(t -> t.price).sum();
    if (totalCost + toy.price > budget) {
      throw new Exception("Budget exceeded! Cannot add new Toy: " + toy.name + "\nCurrent budget: " + this.budget + "\n Money needed: " + totalCost + toy.price);
    }
    toys.add(toy);
  }

  /**
   * Sorts toys in the playroom it's price
   *
   * @return void
   */
  public void sortToysByPrice() {
    Collections.sort(toys, Comparator.comparingDouble(t -> t.price));
  }

  /**
   * Looks for the toys which are has price in range of minPrice and maxPrice params, then return list of found toys
   *
   * @param minPrice
   * @param maxPrice
   *
   * @return List<Toy>
   */
  public List<Toy> findToysInPriceRange(double minPrice, double maxPrice) {
    List<Toy> foundToys = new ArrayList<Toy>();
    for (Toy toy : this.toys) {
      if (toy.price <= maxPrice && toy.price >= minPrice) {
        foundToys.add(toy);
      }
    }
    return foundToys;
  }

  /**
   * Prints toys from the playrooms' list
   */
  public void printToys() {
    for (Toy toy : this.toys) {
      System.out.println(toy);
    }
  }

  /**
   * Prints toys from the toy list accepted as parameter
   *
   * @param toys list of toys to print
   */
  public void printToys(List<Toy> toys) {
    for (Toy toy : toys) {
      System.out.println(toy);
    }
  }
}
