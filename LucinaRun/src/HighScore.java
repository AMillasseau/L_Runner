import java.io.*;

public class HighScore{

    String path = "src\\Highscore.csv";

    String[] names = new String[11];
    int[] scores = new int[11];

    public HighScore(){
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String li = br.readLine();
            int i =0;
            while (li!=null || i<11) {
                String[] words = li.split(",");
                names[i] = words[0];
                scores[i] = Integer.parseInt(words[1]);
                i++;
                li = br.readLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void write_new(String name,int score){
        try{
        for (int j = 9; j>=0; j--){
            if (score>scores[j]){
                scores[j+1] = scores[j];
                names[j+1] = names[j];
                scores[j] = score;
                names[j] = name;
            }
        }
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(names[0]+","+scores[0]);
        bw.newLine();
        for (int k=1; k<11;k++){
            bw.append(names[k]+","+scores[k]);
            bw.newLine();
        }
        bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void refresh(){
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String li = br.readLine();
            int i =0;
            while (li!=null || i<11) {
                String[] words = li.split(",");
                names[i] = words[0];
                scores[i] = Integer.parseInt(words[1]);
                i++;
                li = br.readLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
