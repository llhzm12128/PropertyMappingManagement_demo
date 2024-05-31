package com.llh.manage;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

public class MappingManager {
    private List<MappingRule> mappingRules;

    public MappingManager(String mappingFile) throws Exception {
        Yaml yaml = new Yaml();
        try (InputStream in = MappingManager.class.getResourceAsStream(mappingFile)) {
            MappingRulesConfig config = yaml.loadAs(in, MappingRulesConfig.class);
            this.mappingRules = config.getMappings();
        }
    }

    public void map(Object source, Object target) throws Exception {
        String sourceClassName = source.getClass().getSimpleName();
        String targetClassName = target.getClass().getSimpleName();

        for (MappingRule rule : mappingRules) {
            ///String name = rule.getSourceClass();
            //System.out.println(name);
            if (rule.getSourceClass().equals(sourceClassName) && rule.getTargetClass().equals(targetClassName)) {
                for (MappingRule.FieldMapping fieldMapping : rule.getFields()) {
                    Field sourceField = source.getClass().getDeclaredField(fieldMapping.getSourceField());
                    sourceField.setAccessible(true);
                    Object value = sourceField.get(source);

                    Field targetField = target.getClass().getDeclaredField(fieldMapping.getTargetField());
                    targetField.setAccessible(true);
                    targetField.set(target, value);
                }
            }
        }
    }
}
