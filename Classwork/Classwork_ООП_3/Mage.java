public class Mage extends GameCharacter {
	private double intelligence;
	private double spellPower;
	public String element;
	
	public Mage(String name) {
        super(name);
        this.intelligence = 20.0;
        this.spellPower = 25.0;
        this.element = "Fire";
    }
    
    public Mage(String name, int level, double health, double mana, boolean isAlive,
                   double intelligence, double spellPower, String element) {
        super(name, level, health, mana, isAlive);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
        this.element = element;
    }
	
	
	public double getIntelligence() {
		return intelligence;
	}
	public double getSpellPower() {
		return spellPower;
	}
	public String getElement() {
		return element;
	}
	
	
	public void setIntelligence(double intelligence) {
		if (intelligence >= 0) {
			this.intelligence = intelligence;
		}
	}
	public void setSpellPower(double spellPower) {
		if (spellPower >= 0) {
			this.spellPower = spellPower;
		}
	}
	public void setElement(String element) {
		if (element != null) {
			this.element = element;
		}
	}
	
	
	@Override
	public void displayInfo(){
		System.out.println("===MAGE===");
		displayBasicInfo();
		System.out.println("Intelligence: " + intelligence);
		System.out.println("Spell Power: " + spellPower);
		System.out.println("Element: " + element);
		System.out.println("==========");
	}
	
	@Override
	public void useSpecialAbility() {
		if (isAlive) {
			if (getMana() >= 40) {
				setMana(getMana - 40);
				System.out.println(getName() + " uses MAGIC SHIELD! Damage reduction for next attack.");
			} else {
				System.out.println(getName() + ": Not enough mana for Magic Shield!");
			}
		} else {
			System.out.println(getName() + " cannot use special ability because is dead!");
        }
    }
	
	public void castSpell(String spellName) {
		if (isAlive) {
			if (getMana() >= 20) {
				setMana(getMana() - 20);
				double damage = spellPower * 1.5;
                System.out.println(getName() + " casts " + spellName + " for " + damage + " " + element + " damage!");
            } else {
                System.out.println(getName() + ": Not enough mana to cast " + spellName + "!");
            }
        } else {
            System.out.println(getName() + " cannot cast spells because is dead!");
        }
    }
	
	public void meditate() {
		if (isAlive) {
			double manaRestored = intelligence * 2;
            setMana(getMana() + manaRestored);
            System.out.println(getName() + " meditates and restores " + manaRestored + " mana!");
            System.out.println("Current mana: " + getMana());
        } else {
            System.out.println(getName() + " cannot meditate because is dead!");
        }
    }
}