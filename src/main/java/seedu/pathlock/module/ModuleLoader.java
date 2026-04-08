package seedu.pathlock.module;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuleLoader {

    private static final Logger logger = Logger.getLogger(ModuleLoader.class.getName());
    private static final String MODULE_FILE = "/modules.json";

    public static Map<String, Module> loadModules() {
        InputStream is = ModuleLoader.class.getResourceAsStream(MODULE_FILE);
        if (is == null) {
            logger.log(Level.SEVERE, "modules.json not found in resources");
            throw new RuntimeException("modules.json not found in resources");
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Module>>() {}.getType();
        List<Module> moduleList = gson.fromJson(new InputStreamReader(is), listType);

        Map<String, Module> modules = new LinkedHashMap<>();
        for (Module module : moduleList) {
            modules.put(module.getModuleCode().toUpperCase(), module);
        }

        logger.log(Level.INFO, "Loaded {0} modules from JSON", modules.size());
        return modules;
    }
}
