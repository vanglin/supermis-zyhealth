package com.smartpro.mis.generator.action;


import com.smartpro.mis.generator.action.config.SupermisGeneratorConfig;

/**
 * 代码生成器,可以生成实体,dao,service,controller,html,js
 *
 * @author smartpro
 * @Date 2017/5/21 12:38
 */
public class SupermisCodeGenerator {

    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
         */
        SupermisGeneratorConfig supermisGeneratorConfig = new SupermisGeneratorConfig();
        supermisGeneratorConfig.doMpGeneration();

        /**
         * supermis的生成器:
         *      supermis的代码生成器可以生成controller,html页面,页面对应的js
         */
        supermisGeneratorConfig.doSupermisGeneration();
    }

}