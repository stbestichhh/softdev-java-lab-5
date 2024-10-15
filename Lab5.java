public class Lab5 {

  public static void main(String[] args) {
    try {
      Playroom playroom = new Playroom(100);

      playroom.addToy(new Car(1, 15));
      playroom.addToy(new Doll(2, 20));
      playroom.addToy(new Ball(3, 10));
      playroom.addToy(new Car(2, 25));
      playroom.addToy(new Doll(3, 30));

      System.out.println("Toys sorted by price:");
      playroom.sortToysByPrice();
      playroom.printToys();

      System.out.println("Toys in budget between 15 and 25:");
      List<Toy> foundToys = playroom.findToysInPriceRange(15, 25);
      playroom.printToys(foundToys);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
