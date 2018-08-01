# ProjectTemplate
项目创建模板

## SSM_Demo_01
SSM_Demo_01 为SSM的整合模板，手动整合Spring, SpringMVC, MyBatis
## SSM_Demo_02
SSM_Demo_02 为通过springboot的方式整合SSM
### MapperScan
* 启动类上加 @MapperScan(basePackages = "top.arexstorm.dao")注解
* dao 上加 @Repository(value = "userDao")
* mapper文件默认放在 src/main/resources/top/arexstorm/dao/UserDao.xml
### 直接指定Mapper.xml位置
* 去除启动类上的 @MapperScan注解
* dao 去除@Repository注解，添加@Mapper
* application.properties 中添加 mybatis.mapper-locations=classpath:mapper/*.xml
* mapper文件放在 src/main/resources/mapper/UserDao.xml
