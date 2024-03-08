package com.example.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * 功能：
 * 作者：
 * 日期： 2024/2/11 21:25
 */
public class Code {
    @Test
    void contextLoads() {


        /*数据库配置*/
        DataSourceConfig dataSourceConfig =
                new DataSourceConfig
                        .Builder("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false","root","xujian.123")
                        .dbQuery(new MySqlQuery())
                        .build();


        /*创建一共代码生成器对象*/
        AutoGenerator generator = new AutoGenerator(dataSourceConfig);




        String property = System.getProperty("user.dir");


        /*全局配置*/
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .outputDir(property + "/src/main/java")
                .author("xu")
//                .enableKotlin()
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();



        generator.global(globalConfig);

        /*包配置(PackageConfig)*/

        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.example")
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper.xml")
                .controller("controller")
                .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\project\\javaspace\\springboot_vue\\wms\\src\\main\\resources\\mapper"))
                .build();

        generator.packageInfo(packageConfig);


        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .disable(TemplateType.ENTITY)
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .xml("/templates/mapper.xml")
                .controller("/templates/controller.java")
                .build();

        generator.template(templateConfig);


        /*策略配置*/
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
//                .likeTable(new LikeTable("USER"))
                .addInclude("record")
//                .addTablePrefix("t_", "c_")
//                .addFieldSuffix("_flag")
                /*   .entityBuilder()
                   .controllerBuilder()
                   .mapperBuilder()
                   .serviceBuilder()*/
                .build();

        strategyConfig.entityBuilder()
//                .superClass(BaseEntity.class)
                .disableSerialVersionUID()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleted")
                .naming(NamingStrategy.no_change)
                .columnNaming(NamingStrategy.underline_to_camel)
//                .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
//                .addIgnoreColumns("age")
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
                .idType(IdType.AUTO)
                .formatFileName("%s")
                .build();

        strategyConfig.controllerBuilder()
//                .superClass(BaseController.class)
//                .enableHyphenStyle()
                .enableRestStyle()
                .formatFileName("%sController")
                .build();

        strategyConfig.serviceBuilder()
//                .superServiceClass(BaseService.class)
//                .superServiceImplClass(BaseServiceImpl.class)
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImp")
                .build();

        strategyConfig
                .mapperBuilder()
                .superClass(BaseMapper.class)
                .enableMapperAnnotation()
                .enableBaseResultMap()
                .enableBaseColumnList()
//                .cache(MyMapperCache.class)
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
                .build();


        generator.strategy(strategyConfig);






        /*执行代码生成器*/
        generator.execute();
    }

}