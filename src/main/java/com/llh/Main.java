package com.llh;


import com.llh.dao.SourceA;
import com.llh.dao.SourceB;
import com.llh.dao.Target;
import com.llh.manage.MappingManager;


// 主类，演示映射过程
public class Main {
    public static void main(String[] args) throws Exception {
        // 创建源对象
        SourceA sourceA = new SourceA();
        sourceA.setName("John Doe");
        sourceA.setAge(30);

        SourceB sourceB = new SourceB();
        sourceB.setAddress("123 Main St");
        sourceB.setPhone("555-1234");

        // 创建目标对象
        Target target = new Target();

        // 加载映射规则并执行映射
        MappingManager manager = new MappingManager("/mapping.yaml");
        manager.map(sourceA, target);
        manager.map(sourceB, target);

        // 打印结果
        System.out.println("Full Name: " + target.getFullName());
        System.out.println("Age: " + target.getAge());
        System.out.println("Location: " + target.getLocation());
        System.out.println("Contact Number: " + target.getContactNumber());
    }
}