package ZooKeeper;

public class Mammal {
	protected Integer energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	public Integer displayEnergy() {
		System.out.println(energyLevel);
		return energyLevel;
	};
}
