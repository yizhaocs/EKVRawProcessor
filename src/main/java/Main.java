import org.apache.commons.lang3.text.StrTokenizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        ekvraw();
    }


    public static void ekvraw(){
        StrTokenizer st = StrTokenizer.getCSVInstance();
        st.setDelimiterChar('|');


        File file = new File("/Users/yzhao/Desktop/table_dump_outout.csv");
        File fout = new File("/Users/yzhao/Desktop/" + "result.csv");
        Scanner scanner = null;
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        int count = 0;
        try {
            scanner = new Scanner(file);
            fos = new FileOutputStream(fout);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            while (scanner.hasNextLine()) {
                String line = scanner.next();
                String[] segments = null;
                if(line != null)
                segments = st.reset(line).getTokenArray();
                String EVENT_ID = null;
                String KEY_ID = null;
                String VALUE = null;
                String COOKIE_ID = null;
                String DP_ID = null;
                String LOCATION_ID = null;
                String MODIFICATION_TS = null;

                EVENT_ID = segments[0];
                KEY_ID = segments[1];
                VALUE = segments[2];
                COOKIE_ID = segments[3];
                DP_ID = segments[4];
                LOCATION_ID = segments[5];
                MODIFICATION_TS = segments[6];



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
