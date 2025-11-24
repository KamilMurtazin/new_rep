public class Warrior extends GameCharacter {
	private double strength;
	private double armor;
	private String weaponType;
	
	public Warrior(String name) {
        super(name);
        this.strength = 15.0;
        this.armor = 10.0;
        this.weaponType = "Sword";
    }
    
    public Warrior(String name, int level, double health, double mana, boolean isAlive,
                   double strength, double armor, String weaponType) {
        super(name, level, health, mana, isAlive);
        this.strength = strength;
        this.armor = armor;
        this.weaponType = weaponType;
    }
	
	
	public double getStrength() {
        return strength;
    }
    public double getArmor() {
        return armor;
    }
    public String getWeaponType() {
        return weaponType;
    }
    
	
    public void setStrength(double strength) {
        if (strength >= 0) {
            this.strength = strength;
        }
    }
    public void setArmor(double armor) {
        if (armor >= 0) {
            this.armor = armor;
        }
    }
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
    
	
    @Override
    public void displayInfo() {
        System.out.println("=== WARRIOR ===");
        displayBasicInfo();
        System.out.println("Strength: " + strength);
        System.out.println("Armor: " + armor);
        System.out.println("Weapon: " + weaponType);
        System.out.println("===============");
    }
    
    @Override
    public void useSpecialAbility() {
        if (isAlive()) {
            if (getMana() >= 30) {
                setMana(getMana() - 30);
                this.strength *= 1.5;
                System.out.println(getName() + " uses BERSERK! Strength increased to " + strength);
            } else {
                System.out.println(getName() + ": Not enough mana for Berserk!");
            }
        } else {
            System.out.println(getName() + " cannot use special ability because is dead!");
        }
    }
    
    @Override
    public void attack() {
        if (isAlive()) {
            double damage = strength * 1.2;
            System.out.println(getName() + " attacks with " + weaponType + " for " + damage + " damage!");
        } else {
            System.out.println(getName() + " cannot attack because is dead!");
        }
    }
    
    public void attack(String weapon) {
        if (isAlive()) {
            double damage = strength * 1.5;
            System.out.println(getName() + " attacks with " + weapon + " for " + damage + " damage!");
        } else {
            System.out.println(getName() + " cannot attack because is dead!");
        }
    }
}