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

package com.mijack.popsicle.enums;

/**
 * 字段方法生成策略
 *
 * @author Mi&amp;Jack
 */
public enum FieldMethodGeneration {
    /**
     * 默认策略
     */
    DEFAULT,
    /**
     * 声明为抽象或者接口方法
     */
    ABSTRACT_METHOD,
    /**
     * 在实现上进行和相关字段的设置操作
     */
    FIELD_RELATION,
    /**
     * 不生成方法
     */
    NONE
}
