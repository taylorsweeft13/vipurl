import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: taylorsweeft13
 * @create: 2019/07/03
 * @version: 1.0
 **/
public class ParseTool {

    public static void main(String[] args) {

        String pathname = "url.txt";
        List<String> urlList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                urlList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File writeName = new File("prefix.json");
            writeName.createNewFile();
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                String jsonStr = JSONObject.toJSONString(urlList);
                System.out.println(jsonStr);
                out.write(jsonStr);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
