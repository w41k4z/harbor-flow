package comparator;

import java.lang.reflect.Method;
import java.util.Comparator;

import orm.utilities.Treatment;

public class ModelComparator implements Comparator<Object> {
    /* FIELDS SECTION */
    private Class<?> targetType;
    private String fieldName;
    private boolean isDescendant = false;

    /* CONSTRUCTOR SECTION */
    public ModelComparator(Class<?> targetType, String field) {
        this.setTargetType(targetType);
        this.setFieldName(field);
    }

    public ModelComparator(Class<?> targetType, String field, boolean isDescendant) {
        this(targetType, field);
        this.isDescendant = isDescendant;
    }

    /* SETTERS SECTION */
    public void setTargetType(Class<?> targetType) {
        this.targetType = targetType;
    }

    public void setFieldName(String field) {
        this.fieldName = field;
    }

    /* GETTERS SECTION */
    public Class<?> getTargetType() {
        return this.targetType;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    /* OVERRIDES SECTION */
    @Override
    public int compare(Object o1, Object o2) {
        try {
            String fieldMethodAccessor = Treatment.toCamelCase("set", this.getFieldName());
            Method method = o1.getClass().getMethod(fieldMethodAccessor, this.getTargetType());
            Object value1 = method.invoke(o1);
            Object value2 = method.invoke(o2);
            int result = value1.toString().compareTo(value2.toString());
            return this.isDescendant ? -1 * result : result;
        } catch (Exception e) {
            return 0;
        }
    }

}
