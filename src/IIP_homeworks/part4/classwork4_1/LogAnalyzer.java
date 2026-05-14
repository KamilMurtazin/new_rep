package IIP_homeworks.part4.classwork4_1;

import java.util.List;
class LogAnalyzer implements Runnable{
    private final List<String> chunk;
    int errorCount = 0;
    int apiUsersCount = 0;

    public LogAnalyzer(List<String> chunk) {
        this.chunk = chunk;
    }

    @Override
    public void run(){
        for (int i = 0; i < chunk.size(); i++){
            String line = chunk.get(i);
            if (line.contains("ERROR")) errorCount++;
            if (line.contains("/api/users")) apiUsersCount++;
        }
    }
}
