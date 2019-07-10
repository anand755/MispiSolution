package file.preprocess;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RemoveDots {

    public static void main(String[] args) throws Exception {
        String inputFilePath = "C:\\Users\\anand_jha2\\AnandJha\\Documents\\ProjectFiles\\modifiedpool.json";

        InputStream inputStream = new FileInputStream(inputFilePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            stringBuilder.append(line);
            line = bufferedReader.readLine();
        }
        String fileAsString = stringBuilder.toString();




    }
}
