2013-08-19 huangjl 公文正文密级属性过滤功能改造
 公文表单保存的时候把密级保存到mv_formset_inst表的SECRET_LEVEL字段
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/FormSetInst.xml
*/missiveJar/source/com/excellence/platform/missive/vo/FormSetInstVO.java

2013-09-13 huangjl，批示意见按日期升序
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-10-27 huangjl，文号控件焦点问题：当某个流程步骤需要编文号时，直接点发送按钮，会提示“请选择字号”
*/missiveJar/source/com/excellence/platform/missive/vo/SerialObjectVO.java

2013-10-29，huangjl，增加检索指定密级的信息的查询条件
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java
常量名：INFO_SECRET_LEVEL

增加密级、业务类型、标题查询条件
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-01，增加消息提醒标志位，zh项目，标识是否已经发催办消息提醒
ALTER TABLE MV_WORKITEM ADD (NOTICE_FLAG  VARCHAR2(32 BYTE));

*/missiveJar/source/com/excellence/platform/missive/vo/WorkItemVO.java

/**
 * zh项目用作：消息提醒标识位
 * niticeFlag=null或''或0时表示未发消息通知，niticeFlag=1或>1时表示已发消息通知（次数）
 * 其他项目可用作外围处理的状态位
 */
private String niticeFlag;

*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/WorkItem.xml

2013-11-04，huangjl，zh项目，批示控件，去掉批示语按钮（用户要求将批示控件和词条功能合并，现只保留常用词条）
*/missiveJar/source/com/excellence/platform/missive/vo/OpinionObjectVO.java

2013-11-05 huangjl，公文已办列表增加接收时间、完成时间、发送人、运行状态查询条件
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java

2013-11-06 huangjl，zh项目，实现公文正文、附件加解密
/missiveJar/source/com/excellence/platform/missive/vo/FileVO.java						encryptType是已有字段，zh项目中用作加密类型，默认为base64
/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/File.xml				encryptType是已有字段，zh项目中用作加密类型，默认为base64（MV_FORM_FILE表）
/missiveJar/source/com/excellence/platform/missive/dao/ibatis/FileSqlMapDao.java		
*/missiveJar/source/com/excellence/platform/missive/service/MissiveFileServiceImpl.java	

2013-11-09 公文待办（连续办理）查找下一个工作项的算法性能优化：
	zh压力测试，发现某用户在压力测试的时候待办中产生了17万待办公文，打开某份公文时（后台在查找下一份待办）的时间大约为15秒
	算法原来注释掉的方法，在用户待办列表中，以下是WorkItemIds按从小到大排列，
	x1,x2,x3,x4.....currWorkItemId,y1,y2,y3.....
	如果用户现在打开的待办工作项是currWorkItemId，那么，看是否有y1，如果没有y1，则看是否有x1，注意id是从小到大排列
	原来的算法是把所有工作项取出来，在内存中（排序！），再标记y1和x1
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-12 huangjl，已办列表新增的流程状态查询条件引起催办设置查询步骤信息报错，修正这个bug
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-20 huangjl，表单密级字段有时候保存了其他字段的值
FormAction 5525
FormSetInstVO	setDsValueByDsIndex
*/missiveJar/source/com/excellence/platform/missive/vo/FormVO.java:getDsIndexByDsName

2013-11-28 huangjl 待办翻页，传递的参数有可能会引起类型转换错，修正这个问题
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-29 huangjl 流转中的公文（待办、待阅）是否包含过期公文，默认不包含，设置为true时在待办、待阅列表中显示过期公文
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java
<config name="missive">
	<!-- 流转中的公文（待办、待阅）是否包含过期公文，默认不包含过期公文（设置为false），设置为true时在待办、待阅列表中显示过期公文 -->
	<todoAndToRead.IncludeOverDeadlineWorkitem>true</todoAndToRead.IncludeOverDeadlineWorkitem>
</config>

2013-12-04 huangjl 公文待办当前步骤查询条件，使用模糊查询
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-12-04 huangjl 公文待办增加按紧急程度倒序、日期倒序
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-12-05 huangjl 领导批示意见框，双击是否能弹出全屏窗口显示/编辑，在配置文件exoa-config.xml中配置，默认为true
*/missiveJar/source/com/excellence/platform/missive/vo/OpinionObjectVO.java
跟之前修改是否显示“批示语”、“放大编辑”、“修改记录”几个按钮（或连接）所用的开关为同一个
<config name="missive">
	<!-- 2013-11-13 huangjl，领导批示意见框，是否显示“批示语”、“放大编辑”、“修改记录”几个按钮（或连接） -->
	<Opinion.showEditButton>false</Opinion.showEditButton>
</config>

2013-12-24 huangjl 增加按起草人所在部门查询条件（原来只有按起草人所在单位查询条件）
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2014-02-20 huangjl 公文表单绑定流程时，根据exoa-config.xml中pdaOnOff的设置是否保存pda权限绑定信息
*/missiveJar/source/com/excellence/platform/missive/service/FormServiceImpl.java（MV_OBJECT_PDA_RIGHT）

2014-02-20 huangjl 公文表单绑定流程时，根据exoa-config.xml中pdaOnOff的设置是否保存pda权限绑定信息
*/missiveJar/source/com/excellence/platform/missive/service/FormServiceImpl.java（MV_OBJECT_PDA_RIGHT）

解析表单数据日期数据，增加后台打印解析出错信息
*/missiveJar/source/com/excellence/platform/missive/vo/FormSetInstVO.java

2014-02-20 huangjl 流程催办功能，修正定时设置被催办流程的公文实例（工作项为被催办状态）功能（原来只催办业务工作流，修正为能催办所有流程）
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2014-03-19 huangjl，通过配置可以去掉公文表单页面文本框的蓝色边框
*/missiveJar/source/com/excellence/platform/missive/vo/TextObjectVO.java
在exoa-config.xml中增加配置
<config name="missive">
	<!-- 通过配置textareaNeedEditBorderColor=false可以去掉公文表单页面文本框的蓝色边框 -->
	<textareaNeedEditBorderColor>false</textareaNeedEditBorderColor>
</config>

2015-05-20 huangjl 标准产品权限丢失问题，表单绑定流程的时候丢失表单版本
问题说明：-----------------------------------------------------------------------------------------
在exoa-config.xml中设置了<pdaOnOff>false< pdaOnOff>，公文表单绑定界面上就不会出现pda的选项
但是missive.jar后台还是会保存pda绑定的信息
如需处理，不能直接删除OBJECT_PDA_DOC_ATTRIBUTES表的数据，由于MV_DOC_ATTRIBUTES表有外键关联，删除该表数据后表单绑定时仍然会报错，还是会丢失权限。
中铝洛阳由于丢失权限而丢失公文（失去关联的权限数据，打开公文在界面上看不到表单和公文），
可以修改mv_formset_inst表中对应公文记录的form_id由【绑定的表单版本id】——>【上一表单版本id】恢复，就能打开公文
OBJECT_PDA_DOC_ATTRIBUTES是mv_object_pda_right对mv_doc_attribute的外键关联；
不能简单地删除mv_object_pda_right这个表的数据，要删除得先备份，还要去掉外键关联。
问题说明：-----------------------------------------------------------------------------------------

同步产品对这个问题修改的文件：
*/missiveJar/source/com/excellence/platform/missive/domain/logic/FormManagerImpl.java
*/missiveJar/source/com/excellence/platform/missive/idao/FormRightDao.java
*/missiveJar/source/com/excellence/platform/missive/idao/ObjectPdaRightDao.java
*/missiveJar/source/com/excellence/platform/missive/idao/ObjectRightDao
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/FormRightSqlMapDao.java
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/ObjectPdaRightSqlMapDao.java
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/ObjectRightSqlMapDao.java

*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/FormRight.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/FormRight-mysql.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/FormRight-sqlserver.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/ObjectRight.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/ObjectRight-mysql.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/ObjectRight-sqlserver.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/ObjectPdaRight.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/ObjectPdaRight-mysql.xml
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/ObjectPdaRight-sqlserver.xml


