public class Archer extends GameCharacter {
	private double agility;
	private double accuracy;
	private String arrowType;
	
	public Archer(String name) {
		super(name);
		this.agility = agility;
		this.accuracy = accuracy;
		this.arrowType = arrowType;
	}
	
	public Archer(String name, int level, double health, double mana, boolean isAlive, double agility, double accuracy, String arrowType) {
		super(name, level, health, mana, isAlive);
		this.agility = agility;
		this.accuracy = accuracy;
		this.arrowType = arrowType;
	}
	
	
	public double getAgility() {
		return agility;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public String getArrowType() {
		return arrowType;
	}
	
	
	public void setAgility(double agility) {
		if (agility >= 0) {
			this.agility = agility;
		} 
	}
	public void setAccuracy(double accuracy) {
		if (accuracy >= 0) {
			this.accuracy = accuracy;
		}
	}
	public void setArrowType(String arrowType) {
		if (arrowType != null) {
			this.arrowType = arrowType;
		}
	}
	
	
	@Override
	public void displayInfo() {
		System.out.println(===ARCHER===);
		displayBasicInfo();
		System.out.println("Agility: " + agility);
		System.out.println("Accuracy: " + accuracy);
		System.out.println("Arroe type: " + arrowType + " %");
		System.out.println("==========");
	}
	
	@Override
	public void useSpecialAbility() {
		if (isAlive) {
			if (getMana >= 25) {
				setMana(getMana() - 25);
				this.accuracy = 100;
				System.out.println(getName() + " uses AIMED SHOT! Accuracy increased to 100%!");
            } else {
                System.out.println(getName() + ": Not enough mana for Aimed Shot!");
            }
        } else {
            System.out.println(getName() + " cannot use special ability because is dead!");
        }
    }
	
	@Override
	public void attack() {
		if (isAlive) {
			double damage = agility * 1.3;
            System.out.println(getName() + " shoots an arrow with " + accuracy + "% accuracy for " + damage + " damage!");
        } else {
            System.out.println(getName() + " cannot attack because is dead!");
        }
    }
	
	public void attack(String target, double distance) {
        if (isAlive()) {
            double distancePenalty = Math.max(0.5, 1.0 - (distance * 0.1));
            double damage = agility * 1.3 * distancePenalty;
            double adjustedAccuracy = Math.max(10, accuracy - (distance * 2));
            
            System.out.println(getName() + " shoots at " + target + " from " + distance + " meters distance!");
            System.out.println("Deals " + damage + " damage with " + adjustedAccuracy + "% accuracy!");
        } else {
            System.out.println(getName() + " cannot attack because is dead!");
        }
    }
}