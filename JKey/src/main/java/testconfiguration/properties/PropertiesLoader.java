package testconfiguration.properties;

import exceptions.TestExceptions;
import testconfiguration.TestsConfig;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by Aundre.Jess
 */
public class PropertiesLoader {

    public static void populate(TestsConfig config) {
        Properties properties;
        PropertyFile propertyFileAnnotation = config.getClass().getAnnotation(PropertyFile.class);
        if (propertyFileAnnotation != null) {
            String propertyFileName = propertyFileAnnotation.value();
            if (propertyFileName == null) {
                throw new TestExceptions(
                        "Property file name cannot be empty. Class name : " + config.getClass().getName());
            } else {
                properties = new Properties();
                try {
                    InputStream stream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertyFileName);
                    if (stream != null) {
                        properties.load(stream);
                    } else {
                        throw new TestExceptions(
                                "Unable to read property file with name '" + propertyFileName + "' - file not found");
                    }
                } catch (IOException e) {
                    throw new TestExceptions("Error while reading property file with name '" + propertyFileName + "' : "
                            + e.getMessage(), e);
                }
            }
        } else {
            properties = System.getProperties();
        }
        Field[] fields = config.getClass().getDeclaredFields();
        for (Field field : fields) {
            Property propertyAnnotation = field.getAnnotation(Property.class);
            if (propertyAnnotation != null) {
                String propertyName = propertyAnnotation.value();
                if (propertyName == null) {
                    throw new TestExceptions("Property value cannot be empty. Field name : " + field.getName());
                }
                String propertyValue = properties.getProperty(propertyName);
                if (propertyValue != null) {
                    try {
                        field.setAccessible(true);
                        field.set(config, propertyValue);
                    } catch (IllegalAccessException e) {
                        throw new TestExceptions("Field cannot be set.", e);
                    }
                }
            }
        }
    }

}
