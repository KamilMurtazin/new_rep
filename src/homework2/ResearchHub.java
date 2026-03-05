package homework2;

public class ResearchHub<S extends LaboratoryItem>{
    private S[] storage;
    private int count;

    public ResearchHub(){
        this.storage = (S[]) new LaboratoryItem[2];
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public S[] getStorage() {
        return storage;
    }

    public void register(S item){
        if (count == storage.length){
            S[] newStorage = (S[]) new LaboratoryItem[storage.length * 2];
            for (int i = 0; i < storage.length; i++){
                newStorage[i] = storage[i];
            }
            storage = newStorage;
        }
        storage[count] = item;
        count++;
    }

    public S release(int index){
        if (index < 0 || index >= count){
            return null;
        }
        S removed = storage[index];
        for (int i = index; i < count - 1 ; i ++){
            storage[i] = storage[i + 1];
        }
        storage[count - 1] = null;
        count --;
        return removed;
    }

    public int indexOf(S item) {
        for (int i = 0; i < count; i ++){
            if (storage[i] == item){
                return i;
            }
        }
        return -1;
    }

    public void clearByHazardLevel(int limit){
        for (int i = count - 1; i >= 0; i --){
            if (storage[i].getBiohazardLevel() > limit){
                release(i);
            }
        }
    }

    public void adjustPurity(Number offset, Number multiplier) {
        for (int i = 0; i < count; i++) {
            if (storage[i] instanceof ResearchSample) {
                ResearchSample<?> sample = (ResearchSample<?>) storage[i];
                sample.adjustPurity(offset, multiplier);
            }
        }
    }

    public double getAveragePurity() {
        double sum = 0;
        int sampleCount = 0;

        for (int i = 0; i < count; i++) {
            if (storage[i] instanceof ResearchSample) {
                ResearchSample<?> sample = (ResearchSample<?>) storage[i];
                sum += sample.getPurity().doubleValue();
                sampleCount++;
            }
        }

        if (sampleCount == 0) {
            return 0;
        }
        return sum / sampleCount;
    }
    public boolean checkSession(S item, Integer sessionID){
        return item.getSessionID() == sessionID;
    }
}
