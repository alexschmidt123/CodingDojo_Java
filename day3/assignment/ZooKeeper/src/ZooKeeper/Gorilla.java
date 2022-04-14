package ZooKeeper;
public class Gorilla extends Mammal{
	void throwSomething(){
		System.out.println("Throw something!!!");
		energyLevel -= 5;
	}
	void eatBanana(){
		System.out.println("Yum. Another please!!!");
		energyLevel += 10;
	}
	void climb(){
		System.out.println("Has climbed a tree!!!");
		energyLevel -= 10;
	}
}