package file.preprocess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

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

        try {
            JSONObject jsonObject = new JSONObject(fileAsString);
            Iterator<String> keys = jsonObject.keys();

            List<String> initKeyList = new ArrayList<>();
            while (keys.hasNext()) {
                initKeyList.add(keys.next());
            }

            //while (keys.hasNext()) {
            for (String key : initKeyList) {
                //String key = keys.next();

                if (jsonObject.get(key) instanceof JSONArray) {

                    System.out.println("This Key has collection " + key);

                    List arrayList = Arrays.asList(jsonObject.get(key));

                    for (Object object : arrayList) {
                        JSONObject childObj = new JSONObject(object);
                        Iterator<String> childKeys = childObj.keys();
                        List<String> childKeyList = new ArrayList<>();
                        while (childKeys.hasNext()) {
                            childKeyList.add(childKeys.next());
                        }
                        System.out.println("Child Key count is " + childKeyList.size());
                        System.out.println("Child Key count is " + childKeyList.toString());

                    }
                    //Object value = jsonObject.get(key);

                    //JSONArray valueArray = new JSONArray(value);

                    //JSONObject obj = ((JSONArray) value).toJSONObject(value)
                    //System.out.println("Length of array is " + arrayList.size());

                } else {
                    if (key.contains(".")) {
                        String newKey = key.replaceAll("\\.", "_");
                        Object value = jsonObject.get(key);
                        jsonObject.put(newKey, value);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

