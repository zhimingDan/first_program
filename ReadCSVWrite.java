import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
class ReadCsvWrite {
    public static void main(String[] args) {
        String filename = "D:\\D55509CS7H_20230322135826.CSV";
        String filename1 = "D:\\textN.txt";
        String filename2 = "D:\\textY.txt";
        final String CHARSET_NAME = "UTF-8";

        List<String> content = new ArrayList<>(0);
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(filename1));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(filename2));

            String line1;
            while ((line1 = br.readLine()) != null) {
                content.add(line1);
            }

            boolean isFirstLine = true;
            int panelIdIndex = -1;
            int overQTimeFlgIndex = -1;

            int flag = content.size();
            for (int i = 0; i < content.size(); i++) {
                if (content.get(i).equals("[Body]")) {
                    flag = i;
                    break;
                }
            }
            for (int m = flag; m < content.size(); m++) {
                line += content.get(m);
                line += ",";
            }
            String[] data = line.split(",");
            if (isFirstLine) {
                for (int j = 0; j < data.length; j++) {
                    if (data[j].equals("PANEL_ID")) {
                        panelIdIndex = j;
                    } else if (data[j].equals("OVER_QTIME_FLG")) {
                        overQTimeFlgIndex = j;
                    }
                }
                isFirstLine = false;
            }
            //生成表头
            writer1.write(data[panelIdIndex] + "\t\t" + data[overQTimeFlgIndex] + "\n");
            writer2.write(data[panelIdIndex] + "\t\t" + data[overQTimeFlgIndex] + "\n");
            while (overQTimeFlgIndex < data.length) {
                if (overQTimeFlgIndex != -1) {
                    String value = data[overQTimeFlgIndex];
                    if (value.equals("N")) {
                        writer1.write(data[panelIdIndex] + "\t\t" + value + "\n");
                    } else if (value.equals("Y")) {
                        writer2.write(data[panelIdIndex] + "\t\t" + value + "\n");
                    }
                }
                // 一共108列
                overQTimeFlgIndex += 108;
                panelIdIndex += 108;
            }
            br.close();
            writer1.close();
            writer2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
