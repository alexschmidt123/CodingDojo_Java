package ZooKeeper_;

public class Bat extends Mammal{
	void attackTown(){
		System.out.println("Fire the Town!!!");
		energyLevel -= 100;
		if (energyLevel < 0) {
			energyLevel = 0;
		}
	}
	void fly(){
		System.out.println("Take Off!!!");
		energyLevel -= 50;
		if (energyLevel < 0) {
			energyLevel = 0;
		}
	}
	void eatHuman(){
		System.out.println("Well, never mind!!!");
		energyLevel += 25;
	}
}