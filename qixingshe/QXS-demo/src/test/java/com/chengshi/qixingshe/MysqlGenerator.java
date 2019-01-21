package com.chengshi.qixingshe;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ResourceBundle;

public class MysqlGenerator {

    /**
     * 包名
     */
    private static final String PACKAGE_NAME = "com.chengshi.qixingshe";
    /**
     * 模块名称
     */
    private static final String MODULE_NAME = "biz";
    /**
     * 输出文件的路径
     */
    private static final String OUT_PATH = "E:\\mysql\\code";
    /**
     * 代码生成者
     */
    private static final String AUTHOR = "TianJinshan";

    /**
     * JDBC相关配置
     */
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imetting?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "1234";


    public static void main(String[] args) {

        ResourceBundle rb = ResourceBundle.getBundle("db/Mybatis-Plus");
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir("E;//mysql");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);//开器activeRecord模式
        gc.setEnableCache(false);//XML二级缓存
        gc.setBaseResultMap(true); //XML columnList
        gc.setAuthor(rb.getString("author"));

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName(rb.getString("driver"));
        dsc.setUrl(rb.getString("url"));
        dsc.setUsername(rb.getString("userName"));
        dsc.setPassword(rb.getString("passWord"));
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[] { "bmd_", "mp_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategy.setInclude(new String[]{rb.getString("tableName")}); // 需要生成的表
        // 字段名生成策略
        // strategy.setFieldNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperServiceImplClass("com.baomidou.springwind.service.support.BaseServiceImpl");
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName("test");
        pc.setParent(rb.getString("parent"));// 自定义包路径
        pc.setController("controller" + rb.getString("className"));// 这里是控制器包名，默认 web
        pc.setEntity("model" + rb.getString("className"));
        pc.setMapper("dao" + rb.getString("className"));
        pc.setXml("mapping" + rb.getString("className"));
        pc.setService("service" + rb.getString("className"));
        pc.setServiceImpl("service" + rb.getString("className") + ".impl");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();

    }
}
