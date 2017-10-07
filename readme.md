架构采用的是SpringMVC4.2.4+mybatis3.4.4+ehcache+redis+shiro1.2.2
虽然redis集成了,但是我自己写的SessionDao有些问题目前就还是用的shiro的EnterpriseCacheSessionDAO,因此就没有用redis来缓存Session,但是集成到Spring
中。

前端框架采用的是bootstrap 实现了角色+权限+用户的控制,另外为了能够更好的查看效果我加了一个实体类 即Info 权限才用的是注解方式

然后是密码采用的是Base64加密 加密思路为 加密密码 String pass = password+salt(盐)==>然后调用Base64UU工具类的setString获取到加密密码 
然后把加密密码和salt存入数据库 --->salt我是用uuid生成然后截取前面15位 解密同样很简单的String password = Base64UU.getString(password+salt); 
解密后的密码要注意假如你的密码是123456盐是xxsdgshsgs 那么解密后的密码是123456xxsdgshsgs,利用String的截取方法截取password即可

导入shiro_mybatis.sql,当然了得新创建一个shiro_mybatis数据库,并且把db.properties中的数据库信息改了即可


假如发现问题可以联系本人QQ134266212 或者邮箱noatnu@163.com
