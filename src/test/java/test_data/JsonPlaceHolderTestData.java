package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataSetUpWithAllKeys(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedData = new HashMap<>();
//        expectedData.put("userId", 66);
        expectedData.put("userId", userId);
//        expectedData.put("title", "Tidy your room");
        expectedData.put("title", title);
//        expectedData.put("completed", false);
        expectedData.put("completed", completed);

        return expectedData;
    }
    public Map<String, Object> expectedDataSetUpWithMissingKeys(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedData = new HashMap<>();
        if (userId==null){
            expectedData.put("title", title);
        }else if(completed==null) {
            expectedData.put("title", title);
        }

        return expectedData;
    }


}