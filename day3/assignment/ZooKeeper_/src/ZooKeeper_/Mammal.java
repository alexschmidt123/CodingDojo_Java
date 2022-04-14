package ZooKeeper_;

public class Mammal {
	protected Integer energyLevel;
	
	public Mammal() {
		energyLevel = 300;
	}
	public Integer displayEnergy() {
		System.out.println("Energy: "+energyLevel);
		return energyLevel;
	};
}
