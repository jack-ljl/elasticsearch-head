2013-08-19 huangjl ���������ܼ����Թ��˹��ܸ���
 ���ı������ʱ����ܼ����浽mv_formset_inst���SECRET_LEVEL�ֶ�
*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/FormSetInst.xml
*/missiveJar/source/com/excellence/platform/missive/vo/FormSetInstVO.java

2013-09-13 huangjl����ʾ�������������
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-10-27 huangjl���ĺſؼ��������⣺��ĳ�����̲�����Ҫ���ĺ�ʱ��ֱ�ӵ㷢�Ͱ�ť������ʾ����ѡ���ֺš�
*/missiveJar/source/com/excellence/platform/missive/vo/SerialObjectVO.java

2013-10-29��huangjl�����Ӽ���ָ���ܼ�����Ϣ�Ĳ�ѯ����
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java
��������INFO_SECRET_LEVEL

�����ܼ���ҵ�����͡������ѯ����
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-01��������Ϣ���ѱ�־λ��zh��Ŀ����ʶ�Ƿ��Ѿ����߰���Ϣ����
ALTER TABLE MV_WORKITEM ADD (NOTICE_FLAG  VARCHAR2(32 BYTE));

*/missiveJar/source/com/excellence/platform/missive/vo/WorkItemVO.java

/**
 * zh��Ŀ��������Ϣ���ѱ�ʶλ
 * niticeFlag=null��''��0ʱ��ʾδ����Ϣ֪ͨ��niticeFlag=1��>1ʱ��ʾ�ѷ���Ϣ֪ͨ��������
 * ������Ŀ��������Χ�����״̬λ
 */
private String niticeFlag;

*/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/WorkItem.xml

2013-11-04��huangjl��zh��Ŀ����ʾ�ؼ���ȥ����ʾ�ﰴť���û�Ҫ����ʾ�ؼ��ʹ������ܺϲ�����ֻ�������ô�����
*/missiveJar/source/com/excellence/platform/missive/vo/OpinionObjectVO.java

2013-11-05 huangjl�������Ѱ��б����ӽ���ʱ�䡢���ʱ�䡢�����ˡ�����״̬��ѯ����
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java

2013-11-06 huangjl��zh��Ŀ��ʵ�ֹ������ġ������ӽ���
/missiveJar/source/com/excellence/platform/missive/vo/FileVO.java						encryptType�������ֶΣ�zh��Ŀ�������������ͣ�Ĭ��Ϊbase64
/missiveJar/source/com/excellence/platform/missive/dao/ibatis/sql/File.xml				encryptType�������ֶΣ�zh��Ŀ�������������ͣ�Ĭ��Ϊbase64��MV_FORM_FILE��
/missiveJar/source/com/excellence/platform/missive/dao/ibatis/FileSqlMapDao.java		
*/missiveJar/source/com/excellence/platform/missive/service/MissiveFileServiceImpl.java	

2013-11-09 ���Ĵ��죨��������������һ����������㷨�����Ż���
	zhѹ�����ԣ�����ĳ�û���ѹ�����Ե�ʱ������в�����17����칫�ģ���ĳ�ݹ���ʱ����̨�ڲ�����һ�ݴ��죩��ʱ���ԼΪ15��
	�㷨ԭ��ע�͵��ķ��������û������б��У�������WorkItemIds����С�������У�
	x1,x2,x3,x4.....currWorkItemId,y1,y2,y3.....
	����û����ڴ򿪵Ĵ��칤������currWorkItemId����ô�����Ƿ���y1�����û��y1�����Ƿ���x1��ע��id�Ǵ�С��������
	ԭ�����㷨�ǰ����й�����ȡ���������ڴ��У����򣡣����ٱ��y1��x1
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-12 huangjl���Ѱ��б�����������״̬��ѯ��������߰����ò�ѯ������Ϣ�����������bug
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-20 huangjl�����ܼ��ֶ���ʱ�򱣴��������ֶε�ֵ
FormAction 5525
FormSetInstVO	setDsValueByDsIndex
*/missiveJar/source/com/excellence/platform/missive/vo/FormVO.java:getDsIndexByDsName

2013-11-28 huangjl ���췭ҳ�����ݵĲ����п��ܻ���������ת���������������
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-11-29 huangjl ��ת�еĹ��ģ����졢���ģ��Ƿ�������ڹ��ģ�Ĭ�ϲ�����������Ϊtrueʱ�ڴ��졢�����б�����ʾ���ڹ���
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java
<config name="missive">
	<!-- ��ת�еĹ��ģ����졢���ģ��Ƿ�������ڹ��ģ�Ĭ�ϲ��������ڹ��ģ�����Ϊfalse��������Ϊtrueʱ�ڴ��졢�����б�����ʾ���ڹ��� -->
	<todoAndToRead.IncludeOverDeadlineWorkitem>true</todoAndToRead.IncludeOverDeadlineWorkitem>
</config>

2013-12-04 huangjl ���Ĵ��쵱ǰ�����ѯ������ʹ��ģ����ѯ
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-12-04 huangjl ���Ĵ������Ӱ������̶ȵ������ڵ���
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2013-12-05 huangjl �쵼��ʾ�����˫���Ƿ��ܵ���ȫ��������ʾ/�༭���������ļ�exoa-config.xml�����ã�Ĭ��Ϊtrue
*/missiveJar/source/com/excellence/platform/missive/vo/OpinionObjectVO.java
��֮ǰ�޸��Ƿ���ʾ����ʾ������Ŵ�༭�������޸ļ�¼��������ť�������ӣ����õĿ���Ϊͬһ��
<config name="missive">
	<!-- 2013-11-13 huangjl���쵼��ʾ������Ƿ���ʾ����ʾ������Ŵ�༭�������޸ļ�¼��������ť�������ӣ� -->
	<Opinion.showEditButton>false</Opinion.showEditButton>
</config>

2013-12-24 huangjl ���Ӱ���������ڲ��Ų�ѯ������ԭ��ֻ�а���������ڵ�λ��ѯ������
*/missiveJar/source/com/excellence/platform/missive/util/QueryCondition.java
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2014-02-20 huangjl ���ı�������ʱ������exoa-config.xml��pdaOnOff�������Ƿ񱣴�pdaȨ�ް���Ϣ
*/missiveJar/source/com/excellence/platform/missive/service/FormServiceImpl.java��MV_OBJECT_PDA_RIGHT��

2014-02-20 huangjl ���ı�������ʱ������exoa-config.xml��pdaOnOff�������Ƿ񱣴�pdaȨ�ް���Ϣ
*/missiveJar/source/com/excellence/platform/missive/service/FormServiceImpl.java��MV_OBJECT_PDA_RIGHT��

�����������������ݣ����Ӻ�̨��ӡ����������Ϣ
*/missiveJar/source/com/excellence/platform/missive/vo/FormSetInstVO.java

2014-02-20 huangjl ���̴߰칦�ܣ�������ʱ���ñ��߰����̵Ĺ���ʵ����������Ϊ���߰�״̬�����ܣ�ԭ��ֻ�߰�ҵ������������Ϊ�ܴ߰��������̣�
*/missiveJar/source/com/excellence/platform/missive/dao/MissiveProcessorDAO.java

2014-03-19 huangjl��ͨ�����ÿ���ȥ�����ı�ҳ���ı������ɫ�߿�
*/missiveJar/source/com/excellence/platform/missive/vo/TextObjectVO.java
��exoa-config.xml����������
<config name="missive">
	<!-- ͨ������textareaNeedEditBorderColor=false����ȥ�����ı�ҳ���ı������ɫ�߿� -->
	<textareaNeedEditBorderColor>false</textareaNeedEditBorderColor>
</config>

2015-05-20 huangjl ��׼��ƷȨ�޶�ʧ���⣬�������̵�ʱ��ʧ���汾
����˵����-----------------------------------------------------------------------------------------
��exoa-config.xml��������<pdaOnOff>false< pdaOnOff>�����ı��󶨽����ϾͲ������pda��ѡ��
����missive.jar��̨���ǻᱣ��pda�󶨵���Ϣ
���账������ֱ��ɾ��OBJECT_PDA_DOC_ATTRIBUTES������ݣ�����MV_DOC_ATTRIBUTES�������������ɾ���ñ����ݺ����ʱ��Ȼ�ᱨ�����ǻᶪʧȨ�ޡ�
�����������ڶ�ʧȨ�޶���ʧ���ģ�ʧȥ������Ȩ�����ݣ��򿪹����ڽ����Ͽ��������͹��ģ���
�����޸�mv_formset_inst���ж�Ӧ���ļ�¼��form_id�ɡ��󶨵ı��汾id������>����һ���汾id���ָ������ܴ򿪹���
OBJECT_PDA_DOC_ATTRIBUTES��mv_object_pda_right��mv_doc_attribute�����������
���ܼ򵥵�ɾ��mv_object_pda_right���������ݣ�Ҫɾ�����ȱ��ݣ���Ҫȥ�����������
����˵����-----------------------------------------------------------------------------------------

ͬ����Ʒ����������޸ĵ��ļ���
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


