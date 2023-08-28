public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        toyShop.addToy(new Toy(1, "Doll", 10, 40));
        toyShop.addToy(new Toy(2, "Car", 15, 30));
        toyShop.addToy(new Toy(3, "Teddy Bear", 5, 20));

        Toy drawnToy = toyShop.drawToy();
        if (drawnToy != null) {
            System.out.println("Congratulations! You've won a " + drawnToy.getName());
            toyShop.writeToyToFile(drawnToy);
        } else {
            System.out.println("Sorry, no more toys to draw.");
        }
    }
}
