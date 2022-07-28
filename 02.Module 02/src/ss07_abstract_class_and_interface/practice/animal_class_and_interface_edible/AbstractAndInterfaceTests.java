package ss07_abstract_class_and_interface.practice.animal_class_and_interface_edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                System.out.println();
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }
        System.out.println();
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }

//        Chicken chicken = new Chicken();
//        System.out.println(chicken.makeSound());
//        System.out.println(chicken.howToEat());
    }
}
