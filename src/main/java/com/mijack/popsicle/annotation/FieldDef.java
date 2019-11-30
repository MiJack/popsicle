/*
 *    Copyright 2019 Mi&Jack
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.mijack.popsicle.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mijack.popsicle.enums.FieldMethodGeneration;
import com.mijack.popsicle.enums.FieldType;

/**
 * 作用对象为类、接口、抽象类；
 *
 * * 输入对象为类，会生成对应的字段、方法，在getter方法实现上，会返回对应的字段，在setter方法实现上，会设置对应的值;
 * * 输入对象为接口，只生成对应的方法；
 * * 输入对象为抽象类，会生成相应的方法，字段。
 *
 * = 输入一个类
 * [source,java]
 * --
 * @FieldDef(name = "id", clazz = int.class)
 * @FieldDef(name = "name", clazz = String.class, setter = FieldMethodGeneration.NONE)
 * @FieldDef(name = "age", clazz = Integer.class, fieldType = FieldType.Default)
 * public class Student { }
 * --
 * [source,java]
 * --
 * public class Student {
 *     private int id;
 *     private String name;
 *     Integer age;
 *     public void setId(int id) {
 *         this.id = id;
 *     }
 *     public int getId() {
 *         return this.id;
 *     }
 *     public String getName() {
 *         return this.name;
 *     }
 *     public void setAge(Integer age) {
 *         this.age = age;
 *     }
 *     public Integer getAge() {
 *         return this.age;
 *     }
 * }
 *--
 * = 输入抽象类
 * [source,java]
 * --
 * @FieldDef(name = "id", clazz = int.class)
 * @FieldDef(name = "name", clazz = String.class, setter = FieldMethodGeneration.ABSTRACT_METHOD)
 * @FieldDef(name = "age", clazz = Integer.class, fieldType = FieldType.Default)
 * public abstract class Student { }
 * --
 * [source,java]
 * --
 * public abstract class Student {
 *     private int id;
 *     private String name;
 *     Integer age;
 *     public void setId(int id) {
 *         this.id = id;
 *     }
 *     public int getId() {
 *         return this.id;
 *     }
 *     public String getName() {
 *         return this.name;
 *     }
 *     public abstract setName(String name);
 *     public void setAge(Integer age) {
 *         this.age = age;
 *     }
 *     public Integer getAge() {
 *         return this.age;
 *     }
 * }
 *--
 * = 输入一个接口
 * [source,java]
 * --
 * @FieldDef(name = "id", clazz = int.class)
 * @FieldDef(name = "name", clazz = String.class, setter = FieldMethodGeneration.NONE)
 * @FieldDef(name = "age", clazz = Integer.class, fieldType = FieldType.Default)
 * public interface Student { }
 * --
 * [source,java]
 * --
 * public interface Student {
 *     void setId(int id);
 *     int getId();
 *     String getName();
 *     void setAge(Integer age);
 *     Integer getAge();
 * }
 * --
 * @author https://github.com/mijack[Mi&amp;Jack]
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface FieldDef {
    String name();

    Class<?> clazz();

    FieldType fieldType() default FieldType.PRIVATE;

    FieldMethodGeneration getter() default FieldMethodGeneration.DEFAULT;

    FieldMethodGeneration setter() default FieldMethodGeneration.DEFAULT;
}
