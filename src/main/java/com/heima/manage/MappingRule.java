package com.heima.manage;

import java.util.List;

// 映射规则类
public class MappingRule {
    private String sourceClass;
    private String targetClass;
    private List<MappingRule.FieldMapping> fields;

    // 内部类，表示字段映射
    public static class FieldMapping {
        private String sourceField;
        private String targetField;

        public String getSourceField() {
            return sourceField;
        }

        public void setSourceField(String sourceField) {
            this.sourceField = sourceField;
        }

        public String getTargetField() {
            return targetField;
        }

        public void setTargetField(String targetField) {
            this.targetField = targetField;
        }
    }


    public String getSourceClass() {
        return sourceClass;
    }

    public void setSourceClass(String sourceClass) {
        this.sourceClass = sourceClass;
    }

    public String getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(String targetClass) {
        this.targetClass = targetClass;
    }

    public List<MappingRule.FieldMapping> getFields() {
        return fields;
    }

    public void setFields(List<MappingRule.FieldMapping> fields) {
        this.fields = fields;
    }
}
