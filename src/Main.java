import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ekvraw();
    }


    public static void ekvraw(){
        File file = new File("/Users/yzhao/Desktop/table_dump_outout.csv");
        File fout = new File("/Users/yzhao/Desktop/" + "somehing.csv");
        Scanner scanner = null;
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        int count = 0;
        try {
            scanner = new Scanner(file);
            fos = new FileOutputStream(fout);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            while (scanner.hasNextLine()) {
                String cookieID = scanner.nextLine().trim();
                // ckvraw|20|103467387633636100|2044=;12345|103467387633636100|80|80|80
                bw.write("ckvraw" + "|" + time_stamp + "|" + cookieID + "|" + key + "=" + value + "|" + "null" + "|||");
                bw.newLine();
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Count row:" + count);
    }
}
