package com.zzz.sell.reflect;

import com.zzz.sell.annotation.Registers;
import com.zzz.sell.bean.Register;
import org.reflections.Reflections;

import java.util.Iterator;
import java.util.Set;

/**
 * @author zzz
 * @description
 * @date 2020/3/4
 */
public class RegisterReflect {
    private static Set<Class<?>> registers = null;
    public static Class<Register> getRegister(String type) throws Exception {
        if(registers == null) {
            Reflections reflections = new Reflections("com.zzz.sell.bean");
            registers = reflections.getTypesAnnotatedWith(Registers.class);
        }
        Iterator<Class<?>> iterator = registers.iterator();
        while(iterator.hasNext()){
            Class<?> register = iterator.next();
            Registers annoRegister = register.getAnnotation(Registers.class);
            if(type.equals(annoRegister.value())){
                System.out.println("使用了注册器:" + register.getName());
                return (Class<Register>) register;
            }
        }
        throw new Exception("未匹配到注册器");
    }
   public static Register getRegisterObject(String type) throws Exception {
        Class<Register> registerClass = getRegister(type);
        return registerClass.newInstance();
    }
}
