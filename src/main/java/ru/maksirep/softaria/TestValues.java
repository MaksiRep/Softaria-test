package ru.maksirep.softaria;

import java.util.HashMap;
import java.util.Map;

public class TestValues {

    public static final Map<String, String> FIRST_DAY_MAP = new HashMap<>();
    public static final Map<String, String> SECOND_DAY_MAP = new HashMap<>();
    public static final Map<String, String> THIRD_DAY_MAP = new HashMap<>();
    public static final Map<String, String> FOURTH_DAY_MAP = new HashMap<>();
    public static final Map<String, String> EMPTY_MAP = null;

    static {
        FIRST_DAY_MAP.put("http://maksirep.com/page1", "<html>Page 1</html>");
        FIRST_DAY_MAP.put("http://maksirep.com/page2", "<html>Page 2</html>");
        FIRST_DAY_MAP.put("http://maksirep.com/page3", "<html>Page 3</html>");
        SECOND_DAY_MAP.put("http://maksirep.com/page1", "<html>Page 1 update</html>");
        SECOND_DAY_MAP.put("http://maksirep.com/page3", "<html>Page 3 update</html>");
        SECOND_DAY_MAP.put("http://maksirep.com/page4", "<html>Page 4</html>");
        THIRD_DAY_MAP.put("http://maksirep.com/page2", "<html>Page 2</html>");
        THIRD_DAY_MAP.put("http://maksirep.com/page4", "<html>Page 4 update</html>");
        FOURTH_DAY_MAP.put("http://maksirep.com/page5", "<html>Page 5</html>");
        FOURTH_DAY_MAP.put("http://maksirep.com/page1", "<html>Page 1</html>");
    }
}
