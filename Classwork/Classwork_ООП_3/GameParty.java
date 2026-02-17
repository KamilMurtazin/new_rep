class GameParty {
    private GameCharacter[] partyMembers;
    private int count;
    private String partyName;
    
    public GameParty(String partyName, int maxSize) {
        this.partyName = partyName;
        this.partyMembers = new GameCharacter[maxSize];
        this.count = 0;
    }
    
    public void addCharacter(GameCharacter character) {
        if (count < partyMembers.length) {
            partyMembers[count] = character;
            count++;
        }
    }
    
    public void removeCharacter(String name) {
        for (int i = 0; i < count; i++) {
            if (partyMembers[i].getName().equals(name)) {
                for (int j = i; j < count - 1; j++) {
                    partyMembers[j] = partyMembers[j + 1];
                }
                count--;
                break;
            }
        }
    }
    
    public void displayPartyInfo() {
        System.out.println("Группа: " + partyName);
        for (int i = 0; i < count; i++) {
            partyMembers[i].displayInfo();
            System.out.println();
        }
    }
    
    public void useAllSpecialAbilities() {
        for (int i = 0; i < count; i++) {
            partyMembers[i].useSpecialAbility();
        }
    }
    
    public GameCharacter[] findCharactersByClass(String className) {
        GameCharacter[] result = new GameCharacter[count];
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (partyMembers[i].getClass().getSimpleName().equals(className)) {
                result[found] = partyMembers[i];
                found++;
            }
        }
        return result;
    }
    
    public double calculatePartyPower() {
        double power = 0;
        for (int i = 0; i < count; i++) {
            power += partyMembers[i].getLevel();
        }
        return power;
    }
}