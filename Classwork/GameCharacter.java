public class GameCharacter {
	
	private String name;
	private int level;
	private double health;
	private double mana;
	private boolean isAlive;
	
	public static int totalCharacters = 0;
	public static final int MAX_LEVEL = 100;
	
	public GameCharacter(String name) {
		this(name, 1, 100.0, 100.0, true);
	}
	public GameCharacter(String name, int level, double health, double mana, boolean isAlive) {
		setName(name);
		setLevel(level);
		setHealth(health);
		setMana(mana);
		setAlive(isAlive);
		totalCharacters ++;
	}
	
	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public double getHealth() {
		return health;
	}
	public double getMana() {
		return mana;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public static int getTotalCharacters() {
		return totalCharacters;
	}
	public static int getMaxLevel() {
		return MAX_LEVEL;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(int level) {
		if (level >= 1 && level <= MAX_LEVEL) {
			this.level = level;
		} else {
			System.out.println("Incorrect level: " + level + ". Level must be between 1 and " + MAX_LEVEL)
		}
	}
	public void setHealth(double health) {
		this.health = health;
		if (this.health <= 0) {
			this.health = 0;
			this.isAlive = false;
		} else if (this.health > 0 && !this.isAlive) {
			this.isAlive = true;
		}
	}
	public void setMana(double mana) {
		if (mana >= 0) {
			this.mana = mana;
		} else {
			System.out.println("Incorrect value of mana: " + mana + ". Mana cannot be negative.");
		}
	}
	public void setAlive(boolean alive) {
		this.isAlive = alive;
		if (!alive) {
			this.health = 0;
		}
	}
	
	
	public abstract void displayInfo();
	public abstract void useSpecialAbility();
	
	public void attack() {
		if (!isAlive) {
			System.out.println(name + " cannot attack because is dead!");
		}
		System.out.println(name + " performs a basic attack!");
	}
	
	public void takeDamage(double damage) {
		if (isAlive) {
			if (damage > 0) {
				setHealth(health - damage);
				System.out.println(name + " takes " + damage + " damage! Health: " + health);
				
				if (!isAlive) {
					System.out.println(name + " has been defeated!");
				}
			} else {
            System.out.println("Damage must be positive!");
			}
		} else {
			System.out.println(name + " is already dead!");
		}
	}
	
	public void heal(double amount) {
		if (isAlive) {
            if (amount > 0) {
                setHealth(health + amount);
                System.out.println(name + " heals " + amount + " health points! Current health: " + health);
            } else {
                System.out.println("Heal amount must be positive!");
            }
        } else {
            System.out.println(name + " cannot be healed because is dead!");
        }
    }
    
	protected void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level + "/" + MAX_LEVEL);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("Status: " + (isAlive ? "Alive" : "Dead"));
    }
}