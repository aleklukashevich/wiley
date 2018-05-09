package selenium;

import java.util.Hashtable;

/**
 * Created by Alek on 09.05.2018.
 */
public final class ParamHolder {
    private static final Hashtable<String, Object> PARAMS = new Hashtable<>();

    public static void setParam(String key, Object object){
        PARAMS.put(key, object);
    }

    public static Object getParam(String key){
        return PARAMS.get(key);
    }
}
