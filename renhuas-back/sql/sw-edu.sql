/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.30-log : Database - sw-edu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sw-edu` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `sw-edu`;

/*Table structure for table `analyze_sch_eval` */

DROP TABLE IF EXISTS `analyze_sch_eval`;

CREATE TABLE `analyze_sch_eval` (
  `analyze_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学校测评分析ID',
  `sch_name` varchar(200) NOT NULL COMMENT '学校名称',
  `sch_id` bigint(20) NOT NULL COMMENT '学校ID',
  `sch_year` varchar(200) NOT NULL COMMENT '学年',
  `semester` varchar(200) NOT NULL COMMENT '学期',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `eval_score` double NOT NULL COMMENT '测评得分',
  `ranking` varchar(50) NOT NULL COMMENT '排名',
  PRIMARY KEY (`analyze_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校教学质量分析表';

/*Data for the table `analyze_sch_eval` */

/*Table structure for table `analyze_teach_eval` */

DROP TABLE IF EXISTS `analyze_teach_eval`;

CREATE TABLE `analyze_teach_eval` (
  `analyze_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '老师测评分析ID',
  `teach_name` varchar(200) NOT NULL COMMENT '老师名称',
  `teach_id` bigint(20) NOT NULL COMMENT '老师ID',
  `cart_id` varchar(200) NOT NULL COMMENT '身份证号',
  `sch_name` varchar(200) NOT NULL COMMENT '学校名称',
  `sch_id` bigint(20) NOT NULL COMMENT '学校ID',
  `sch_year` varchar(200) NOT NULL COMMENT '学年',
  `academic` varchar(200) NOT NULL COMMENT '学期',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `eval_score` varchar(200) NOT NULL COMMENT '测评得分',
  `ranking` varchar(50) NOT NULL COMMENT '排名',
  PRIMARY KEY (`analyze_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='老师教学质量分析表';

/*Data for the table `analyze_teach_eval` */

/*Table structure for table `basicdata_average_score` */

DROP TABLE IF EXISTS `basicdata_average_score`;

CREATE TABLE `basicdata_average_score` (
  `average_score_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评价分数ID',
  `course` varchar(200) NOT NULL COMMENT '科目',
  `course_id` bigint(20) NOT NULL COMMENT '科目ID',
  `average_score` varchar(200) NOT NULL COMMENT '平均分数',
  `aver_type` varchar(200) NOT NULL COMMENT '类型',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_year` varchar(200) NOT NULL COMMENT '学年',
  `sch_year_id` bigint(20) NOT NULL COMMENT '学年ID',
  `semester` varchar(200) NOT NULL COMMENT '学期',
  `semester_id` bigint(20) NOT NULL COMMENT '学期ID',
  `grade` varchar(200) NOT NULL COMMENT '年级',
  `grade_id` bigint(20) NOT NULL COMMENT '年级ID',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  PRIMARY KEY (`average_score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='平均分数表';

/*Data for the table `basicdata_average_score` */

/*Table structure for table `basicdata_course` */

DROP TABLE IF EXISTS `basicdata_course`;

CREATE TABLE `basicdata_course` (
  `course_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '科目ID',
  `course` varchar(200) NOT NULL COMMENT '科目',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='科目课程表';

/*Data for the table `basicdata_course` */

/*Table structure for table `basicdata_exam_type` */

DROP TABLE IF EXISTS `basicdata_exam_type`;

CREATE TABLE `basicdata_exam_type` (
  `exam_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '考试类型ID',
  `exam_type` varchar(200) NOT NULL COMMENT '考试类型',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  PRIMARY KEY (`exam_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='考试类型表';

/*Data for the table `basicdata_exam_type` */

/*Table structure for table `basicdata_grade` */

DROP TABLE IF EXISTS `basicdata_grade`;

CREATE TABLE `basicdata_grade` (
  `grade_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '年级ID',
  `grade` varchar(200) NOT NULL COMMENT '年级',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='年级表';

/*Data for the table `basicdata_grade` */

/*Table structure for table `basicdata_sch_type` */

DROP TABLE IF EXISTS `basicdata_sch_type`;

CREATE TABLE `basicdata_sch_type` (
  `sch_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学校类型ID',
  `sch_type` varchar(200) NOT NULL COMMENT '学校类型',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  PRIMARY KEY (`sch_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校类型表';

/*Data for the table `basicdata_sch_type` */

/*Table structure for table `basicdata_sch_year` */

DROP TABLE IF EXISTS `basicdata_sch_year`;

CREATE TABLE `basicdata_sch_year` (
  `sch_year_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学年ID',
  `sch_year` varchar(200) NOT NULL COMMENT '学年',
  `start_time` varchar(200) NOT NULL COMMENT '开始时间',
  `end_time` varchar(200) NOT NULL COMMENT '结束时间',
  `study_week` varchar(200) NOT NULL COMMENT '学习周',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  PRIMARY KEY (`sch_year_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学年表';

/*Data for the table `basicdata_sch_year` */

/*Table structure for table `basicdata_semester` */

DROP TABLE IF EXISTS `basicdata_semester`;

CREATE TABLE `basicdata_semester` (
  `semester_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学期ID',
  `semester` varchar(200) NOT NULL COMMENT '学期',
  `study_week` varchar(200) NOT NULL COMMENT '学习周',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  PRIMARY KEY (`semester_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学期表';

/*Data for the table `basicdata_semester` */

/*Table structure for table `data_inform` */

DROP TABLE IF EXISTS `data_inform`;

CREATE TABLE `data_inform` (
  `infor_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `infor_name` varchar(200) NOT NULL COMMENT '文件名称',
  `sch_semester` varchar(200) NOT NULL COMMENT '学年学期',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `infor_type` varchar(200) NOT NULL COMMENT '文件类型',
  `upload_time` datetime NOT NULL COMMENT '上传时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  `upload_state` char(1) NOT NULL DEFAULT '0' COMMENT '上传状态（0未成功，1成功）',
  `lock_state` char(1) NOT NULL DEFAULT '0' COMMENT '锁定状态（0未到期，1到期）',
  PRIMARY KEY (`infor_id`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据管理表';

/*Data for the table `data_inform` */

/*Table structure for table `eval_edu_quality` */

DROP TABLE IF EXISTS `eval_edu_quality`;

CREATE TABLE `eval_edu_quality` (
  `tech_quality_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '教学质量ID',
  `tech_quality_name` varchar(200) NOT NULL COMMENT '教学质量报告',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_semester` varchar(200) NOT NULL COMMENT '所属学年学期',
  `eval_objective` varchar(200) NOT NULL COMMENT '客户评价',
  `eval_subjective` varchar(200) NOT NULL COMMENT '主观评价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `username` varchar(200) NOT NULL COMMENT '用户姓名',
  PRIMARY KEY (`tech_quality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教学质量评测表';

/*Data for the table `eval_edu_quality` */

/*Table structure for table `eval_school` */

DROP TABLE IF EXISTS `eval_school`;

CREATE TABLE `eval_school` (
  `eval_id` bigint(20) unsigned zerofill NOT NULL COMMENT '学校测评ID',
  `eval_name` varchar(200) NOT NULL COMMENT '总表名称',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_semester` varchar(200) NOT NULL COMMENT '所属学年学期',
  `eval_plan_name` varchar(200) NOT NULL COMMENT '测评方案名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  `ref_state` char(1) NOT NULL DEFAULT '0' COMMENT '引用状态（0未引用，1引用）',
  PRIMARY KEY (`eval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校测评表';

/*Data for the table `eval_school` */

/*Table structure for table `eval_teach_persion` */

DROP TABLE IF EXISTS `eval_teach_persion`;

CREATE TABLE `eval_teach_persion` (
  `eval_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '老师个人ID',
  `eval_persion_name` varchar(200) NOT NULL COMMENT '老师个人报告名称',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_semester` varchar(200) NOT NULL COMMENT '所属学年学期',
  `eval_objective` varchar(200) NOT NULL COMMENT '客观评价',
  `eval_subjective` varchar(200) NOT NULL COMMENT '主观评价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  PRIMARY KEY (`eval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='老师个人测评表';

/*Data for the table `eval_teach_persion` */

/*Table structure for table `eval_teacher` */

DROP TABLE IF EXISTS `eval_teacher`;

CREATE TABLE `eval_teacher` (
  `eval_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '老师测评ID',
  `eval_teach_name` varchar(200) NOT NULL COMMENT '老师测评汇总名称',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_semester` varchar(200) NOT NULL COMMENT '所属学年学期',
  `eval_plan` varchar(200) NOT NULL COMMENT '评测方案名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `ref_state` char(1) NOT NULL COMMENT '引用状态（0未引用，1引用）',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  PRIMARY KEY (`eval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='老师教学测评表';

/*Data for the table `eval_teacher` */

/*Table structure for table `gen_table` */

DROP TABLE IF EXISTS `gen_table`;

CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表';

/*Data for the table `gen_table` */

/*Table structure for table `gen_table_column` */

DROP TABLE IF EXISTS `gen_table_column`;

CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表字段';

/*Data for the table `gen_table_column` */

/*Table structure for table `plan_edu` */

DROP TABLE IF EXISTS `plan_edu`;

CREATE TABLE `plan_edu` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '方案ID',
  `plan_name` varchar(200) NOT NULL COMMENT '方案名称',
  `tar_type` varchar(200) NOT NULL COMMENT '指标类型',
  `ref_tar` varchar(200) NOT NULL COMMENT '引用指标',
  `sch_semester` varchar(200) NOT NULL COMMENT '所属学年学期',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  `state` char(1) NOT NULL DEFAULT '0' COMMENT '引用状态（0未引用，1引用）',
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='方案管理表';

/*Data for the table `plan_edu` */

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `blob_data` blob COMMENT '存放持久化Trigger对象',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Blob类型的触发器表';

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `calendar_name` varchar(200) NOT NULL COMMENT '日历名称',
  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='日历信息表';

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `cron_expression` varchar(200) NOT NULL COMMENT 'cron表达式',
  `time_zone_id` varchar(80) DEFAULT NULL COMMENT '时区',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Cron类型的触发器表';

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`cron_expression`,`time_zone_id`) values ('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT','0/15 * * * * ?','Asia/Shanghai'),('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT','0/20 * * * * ?','Asia/Shanghai');

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `entry_id` varchar(95) NOT NULL COMMENT '调度器实例id',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `instance_name` varchar(200) NOT NULL COMMENT '调度器实例名',
  `fired_time` bigint(13) NOT NULL COMMENT '触发的时间',
  `sched_time` bigint(13) NOT NULL COMMENT '定时器制定的时间',
  `priority` int(11) NOT NULL COMMENT '优先级',
  `state` varchar(16) NOT NULL COMMENT '状态',
  `job_name` varchar(200) DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(200) DEFAULT NULL COMMENT '任务组名',
  `is_nonconcurrent` varchar(1) DEFAULT NULL COMMENT '是否并发',
  `requests_recovery` varchar(1) DEFAULT NULL COMMENT '是否接受恢复执行',
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='已触发的触发器表';

/*Data for the table `qrtz_fired_triggers` */

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `job_name` varchar(200) NOT NULL COMMENT '任务名称',
  `job_group` varchar(200) NOT NULL COMMENT '任务组名',
  `description` varchar(250) DEFAULT NULL COMMENT '相关介绍',
  `job_class_name` varchar(250) NOT NULL COMMENT '执行任务类名称',
  `is_durable` varchar(1) NOT NULL COMMENT '是否持久化',
  `is_nonconcurrent` varchar(1) NOT NULL COMMENT '是否并发',
  `is_update_data` varchar(1) NOT NULL COMMENT '是否更新数据',
  `requests_recovery` varchar(1) NOT NULL COMMENT '是否接受恢复执行',
  `job_data` blob COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务详细信息表';

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`sched_name`,`job_name`,`job_group`,`description`,`job_class_name`,`is_durable`,`is_nonconcurrent`,`is_update_data`,`requests_recovery`,`job_data`) values ('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT',NULL,'com.renhuas.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0 com.renhuas.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.renhuas.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0|혷xpt\0\0pppt\01t\00/10 * * * * ?t\0ryTask.ryNoParamst\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（无参）t\03t\01x\0'),('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT',NULL,'com.renhuas.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0 com.renhuas.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.renhuas.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0|혷xpt\0\0pppt\01t\00/15 * * * * ?t\0ryTask.ryParams(\'ry\')t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（有参）t\03t\01x\0'),('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT',NULL,'com.renhuas.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0 com.renhuas.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.renhuas.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0|혷xpt\0\0pppt\01t\00/20 * * * * ?t\08ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（多参）t\03t\01x\0');

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `lock_name` varchar(40) NOT NULL COMMENT '悲观锁名称',
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='存储的悲观锁信息表';

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`sched_name`,`lock_name`) values ('RuoyiScheduler','STATE_ACCESS'),('RuoyiScheduler','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='暂停的触发器表';

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `instance_name` varchar(200) NOT NULL COMMENT '实例名称',
  `last_checkin_time` bigint(13) NOT NULL COMMENT '上次检查时间',
  `checkin_interval` bigint(13) NOT NULL COMMENT '检查间隔时间',
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='调度器状态表';

/*Data for the table `qrtz_scheduler_state` */

insert  into `qrtz_scheduler_state`(`sched_name`,`instance_name`,`last_checkin_time`,`checkin_interval`) values ('RuoyiScheduler','DESKTOP-INMB5KD1636074747079',1636074915740,15000);

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `repeat_count` bigint(7) NOT NULL COMMENT '重复的次数统计',
  `repeat_interval` bigint(12) NOT NULL COMMENT '重复的间隔时间',
  `times_triggered` bigint(10) NOT NULL COMMENT '已经触发的次数',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='简单触发器的信息表';

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `str_prop_1` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
  `str_prop_2` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
  `str_prop_3` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
  `int_prop_1` int(11) DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
  `int_prop_2` int(11) DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
  `long_prop_1` bigint(20) DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
  `long_prop_2` bigint(20) DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
  `dec_prop_1` decimal(13,4) DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
  `dec_prop_2` decimal(13,4) DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
  `bool_prop_1` varchar(1) DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
  `bool_prop_2` varchar(1) DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='同步机制的行锁表';

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT '触发器的名字',
  `trigger_group` varchar(200) NOT NULL COMMENT '触发器所属组的名字',
  `job_name` varchar(200) NOT NULL COMMENT 'qrtz_job_details表job_name的外键',
  `job_group` varchar(200) NOT NULL COMMENT 'qrtz_job_details表job_group的外键',
  `description` varchar(250) DEFAULT NULL COMMENT '相关介绍',
  `next_fire_time` bigint(13) DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
  `prev_fire_time` bigint(13) DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `trigger_state` varchar(16) NOT NULL COMMENT '触发器状态',
  `trigger_type` varchar(8) NOT NULL COMMENT '触发器的类型',
  `start_time` bigint(13) NOT NULL COMMENT '开始时间',
  `end_time` bigint(13) DEFAULT NULL COMMENT '结束时间',
  `calendar_name` varchar(200) DEFAULT NULL COMMENT '日程表名称',
  `misfire_instr` smallint(2) DEFAULT NULL COMMENT '补偿执行的策略',
  `job_data` blob COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='触发器详细信息表';

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`job_name`,`job_group`,`description`,`next_fire_time`,`prev_fire_time`,`priority`,`trigger_state`,`trigger_type`,`start_time`,`end_time`,`calendar_name`,`misfire_instr`,`job_data`) values ('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT','TASK_CLASS_NAME1','DEFAULT',NULL,1636074750000,-1,5,'PAUSED','CRON',1636074747000,0,NULL,2,''),('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT','TASK_CLASS_NAME2','DEFAULT',NULL,1636074750000,-1,5,'PAUSED','CRON',1636074747000,0,NULL,2,''),('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT','TASK_CLASS_NAME3','DEFAULT',NULL,1636074760000,-1,5,'PAUSED','CRON',1636074747000,0,NULL,2,'');

/*Table structure for table `sch_class` */

DROP TABLE IF EXISTS `sch_class`;

CREATE TABLE `sch_class` (
  `class_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `class_name` varchar(200) NOT NULL COMMENT '班级名称',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班级表';

/*Data for the table `sch_class` */

/*Table structure for table `sch_school` */

DROP TABLE IF EXISTS `sch_school`;

CREATE TABLE `sch_school` (
  `sch_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学校ID',
  `sch_name` varchar(200) NOT NULL COMMENT '学校名称',
  `sch_type` varchar(200) NOT NULL COMMENT '学校类型',
  `sch_code` varchar(200) NOT NULL COMMENT '学校代码',
  `region` varchar(200) NOT NULL COMMENT '所属区域',
  `address` varchar(500) NOT NULL COMMENT '地址',
  `link_name` varchar(200) NOT NULL COMMENT '联系人',
  `link_phone` varchar(200) NOT NULL COMMENT '联系电话',
  `sch_profile` varchar(500) NOT NULL COMMENT '学校简介',
  PRIMARY KEY (`sch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校表';

/*Data for the table `sch_school` */

/*Table structure for table `sch_student` */

DROP TABLE IF EXISTS `sch_student`;

CREATE TABLE `sch_student` (
  `stu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `stu_name` varchar(200) NOT NULL COMMENT '学生姓名',
  `stu_nation` varchar(200) NOT NULL COMMENT '民族',
  `stu_sex` varchar(200) NOT NULL COMMENT '性别',
  `sch_name` varchar(200) NOT NULL COMMENT '学校名称',
  `sch_id` varchar(200) NOT NULL COMMENT '学校ID',
  `sch_num` varchar(200) NOT NULL COMMENT '学籍号',
  `grade` varchar(200) NOT NULL COMMENT '当前年级',
  `class_id` bigint(20) NOT NULL COMMENT '班级ID',
  `class_name` varchar(200) NOT NULL COMMENT '当前班级',
  `native_place` varchar(200) NOT NULL COMMENT '籍贯',
  `address` varchar(500) NOT NULL COMMENT '常住地址',
  `guardian` varchar(200) NOT NULL COMMENT '监护人姓名',
  `guard_phone` varchar(200) NOT NULL COMMENT '监护人电话',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';

/*Data for the table `sch_student` */

/*Table structure for table `sch_teacher` */

DROP TABLE IF EXISTS `sch_teacher`;

CREATE TABLE `sch_teacher` (
  `teach_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `teach_name` varchar(200) NOT NULL COMMENT '教师姓名',
  `teach_sex` varchar(200) NOT NULL COMMENT '老师性别',
  `birth_date` varchar(200) NOT NULL COMMENT '出生日期',
  `cart_id` varchar(200) NOT NULL COMMENT '身份证号',
  `job_title` varchar(200) NOT NULL COMMENT '职称',
  `sch_name` varchar(200) NOT NULL COMMENT '任教学校',
  `sch_id` bigint(20) NOT NULL COMMENT '学校ID',
  `sch_type` varchar(200) NOT NULL COMMENT '学校类型',
  `course` varchar(200) NOT NULL COMMENT '任教科目',
  `telephone` varchar(200) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`teach_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='老师表';

/*Data for the table `sch_teacher` */

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='参数配置表';

/*Data for the table `sys_config` */

insert  into `sys_config`(`config_id`,`config_name`,`config_key`,`config_value`,`config_type`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2021-11-05 08:56:21','',NULL,'蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2021-11-05 08:56:21','',NULL,'初始化密码 123456'),(3,'主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2021-11-05 08:56:21','',NULL,'深色主题theme-dark，浅色主题theme-light'),(4,'账号自助-验证码开关','sys.account.captchaOnOff','true','Y','admin','2021-11-05 08:56:21','',NULL,'是否开启验证码功能（true开启，false关闭）'),(5,'账号自助-是否开启用户注册功能','sys.account.registerUser','false','Y','admin','2021-11-05 08:56:21','',NULL,'是否开启注册用户功能（true开启，false关闭）');

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`parent_id`,`ancestors`,`dept_name`,`order_num`,`leader`,`phone`,`email`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`) values (100,0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(101,100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(102,100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(103,101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(104,101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(105,101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(106,101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(108,102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL),(109,102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-11-05 08:56:20','',NULL);

/*Table structure for table `sys_dict_data` */

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='字典数据表';

/*Data for the table `sys_dict_data` */

insert  into `sys_dict_data`(`dict_code`,`dict_sort`,`dict_label`,`dict_value`,`dict_type`,`css_class`,`list_class`,`is_default`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,1,'男','0','sys_user_sex','','','Y','0','admin','2021-11-05 08:56:21','',NULL,'性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2021-11-05 08:56:21','',NULL,'性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2021-11-05 08:56:21','',NULL,'性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2021-11-05 08:56:21','',NULL,'显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2021-11-05 08:56:21','',NULL,'正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2021-11-05 08:56:21','',NULL,'正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'停用状态'),(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2021-11-05 08:56:21','',NULL,'默认分组'),(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2021-11-05 08:56:21','',NULL,'系统分组'),(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2021-11-05 08:56:21','',NULL,'系统默认是'),(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'系统默认否'),(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2021-11-05 08:56:21','',NULL,'通知'),(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2021-11-05 08:56:21','',NULL,'公告'),(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2021-11-05 08:56:21','',NULL,'正常状态'),(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'关闭状态'),(18,1,'新增','1','sys_oper_type','','info','N','0','admin','2021-11-05 08:56:21','',NULL,'新增操作'),(19,2,'修改','2','sys_oper_type','','info','N','0','admin','2021-11-05 08:56:21','',NULL,'修改操作'),(20,3,'删除','3','sys_oper_type','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'删除操作'),(21,4,'授权','4','sys_oper_type','','primary','N','0','admin','2021-11-05 08:56:21','',NULL,'授权操作'),(22,5,'导出','5','sys_oper_type','','warning','N','0','admin','2021-11-05 08:56:21','',NULL,'导出操作'),(23,6,'导入','6','sys_oper_type','','warning','N','0','admin','2021-11-05 08:56:21','',NULL,'导入操作'),(24,7,'强退','7','sys_oper_type','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'强退操作'),(25,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2021-11-05 08:56:21','',NULL,'生成操作'),(26,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'清空操作'),(27,1,'成功','0','sys_common_status','','primary','N','0','admin','2021-11-05 08:56:21','',NULL,'正常状态'),(28,2,'失败','1','sys_common_status','','danger','N','0','admin','2021-11-05 08:56:21','',NULL,'停用状态');

/*Table structure for table `sys_dict_type` */

DROP TABLE IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='字典类型表';

/*Data for the table `sys_dict_type` */

insert  into `sys_dict_type`(`dict_id`,`dict_name`,`dict_type`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'用户性别','sys_user_sex','0','admin','2021-11-05 08:56:21','',NULL,'用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2021-11-05 08:56:21','',NULL,'菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2021-11-05 08:56:21','',NULL,'系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2021-11-05 08:56:21','',NULL,'任务状态列表'),(5,'任务分组','sys_job_group','0','admin','2021-11-05 08:56:21','',NULL,'任务分组列表'),(6,'系统是否','sys_yes_no','0','admin','2021-11-05 08:56:21','',NULL,'系统是否列表'),(7,'通知类型','sys_notice_type','0','admin','2021-11-05 08:56:21','',NULL,'通知类型列表'),(8,'通知状态','sys_notice_status','0','admin','2021-11-05 08:56:21','',NULL,'通知状态列表'),(9,'操作类型','sys_oper_type','0','admin','2021-11-05 08:56:21','',NULL,'操作类型列表'),(10,'系统状态','sys_common_status','0','admin','2021-11-05 08:56:21','',NULL,'登录状态列表');

/*Table structure for table `sys_job` */

DROP TABLE IF EXISTS `sys_job`;

CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度表';

/*Data for the table `sys_job` */

insert  into `sys_job`(`job_id`,`job_name`,`job_group`,`invoke_target`,`cron_expression`,`misfire_policy`,`concurrent`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2021-11-05 08:56:21','',NULL,''),(2,'系统默认（有参）','DEFAULT','ryTask.ryParams(\'ry\')','0/15 * * * * ?','3','1','1','admin','2021-11-05 08:56:21','',NULL,''),(3,'系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2021-11-05 08:56:21','',NULL,'');

/*Table structure for table `sys_job_log` */

DROP TABLE IF EXISTS `sys_job_log`;

CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度日志表';

/*Data for the table `sys_job_log` */

/*Table structure for table `sys_logininfor` */

DROP TABLE IF EXISTS `sys_logininfor`;

CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COMMENT='系统访问记录';

/*Data for the table `sys_logininfor` */

insert  into `sys_logininfor`(`info_id`,`user_name`,`ipaddr`,`login_location`,`browser`,`os`,`status`,`msg`,`login_time`) values (100,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2021-11-05 09:06:07');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(11) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(11) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int(11) DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2145 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_name`,`parent_id`,`order_num`,`path`,`component`,`query`,`is_frame`,`is_cache`,`menu_type`,`visible`,`status`,`perms`,`icon`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'系统管理',0,8,'system',NULL,'',1,0,'M','0','0','','system','admin','2021-11-04 10:34:08','admin','2021-11-04 17:41:27','系统管理目录'),(2,'系统监控',0,9,'monitor',NULL,'',1,0,'M','0','0','','monitor','admin','2021-11-04 10:34:08','admin','2021-11-04 17:41:34','系统监控目录'),(3,'系统工具',0,10,'tool',NULL,'',1,0,'M','0','0','','tool','admin','2021-11-04 10:34:08','admin','2021-11-04 17:41:43','系统工具目录'),(4,'若依官网',0,11,'http://ruoyi.vip',NULL,'',0,0,'M','1','0','','guide','admin','2021-11-04 10:34:08','admin','2021-11-04 17:41:50','若依官网地址'),(100,'用户管理',1,1,'user','system/user/index','',1,0,'C','0','0','system:user:list','user','admin','2021-11-04 10:34:08','',NULL,'用户管理菜单'),(101,'角色管理',1,2,'role','system/role/index','',1,0,'C','0','0','system:role:list','peoples','admin','2021-11-04 10:34:08','',NULL,'角色管理菜单'),(102,'菜单管理',1,3,'menu','system/menu/index','',1,0,'C','0','0','system:menu:list','tree-table','admin','2021-11-04 10:34:08','',NULL,'菜单管理菜单'),(103,'部门管理',1,4,'dept','system/dept/index','',1,0,'C','0','0','system:dept:list','tree','admin','2021-11-04 10:34:08','',NULL,'部门管理菜单'),(104,'岗位管理',1,5,'post','system/post/index','',1,0,'C','0','0','system:post:list','post','admin','2021-11-04 10:34:08','',NULL,'岗位管理菜单'),(105,'字典管理',1,6,'dict','system/dict/index','',1,0,'C','0','0','system:dict:list','dict','admin','2021-11-04 10:34:08','',NULL,'字典管理菜单'),(106,'参数设置',1,7,'config','system/config/index','',1,0,'C','0','0','system:config:list','edit','admin','2021-11-04 10:34:08','',NULL,'参数设置菜单'),(107,'通知公告',1,8,'notice','system/notice/index','',1,0,'C','0','0','system:notice:list','message','admin','2021-11-04 10:34:08','',NULL,'通知公告菜单'),(108,'日志管理',1,9,'log','','',1,0,'M','0','0','','log','admin','2021-11-04 10:34:08','',NULL,'日志管理菜单'),(109,'在线用户',2,1,'online','monitor/online/index','',1,0,'C','0','0','monitor:online:list','online','admin','2021-11-04 10:34:08','',NULL,'在线用户菜单'),(110,'定时任务',2,2,'job','monitor/job/index','',1,0,'C','0','0','monitor:job:list','job','admin','2021-11-04 10:34:08','',NULL,'定时任务菜单'),(111,'数据监控',2,3,'druid','monitor/druid/index','',1,0,'C','0','0','monitor:druid:list','druid','admin','2021-11-04 10:34:08','',NULL,'数据监控菜单'),(112,'服务监控',2,4,'server','monitor/server/index','',1,0,'C','0','0','monitor:server:list','server','admin','2021-11-04 10:34:08','',NULL,'服务监控菜单'),(113,'缓存监控',2,5,'cache','monitor/cache/index','',1,0,'C','0','0','monitor:cache:list','redis','admin','2021-11-04 10:34:08','',NULL,'缓存监控菜单'),(114,'表单构建',3,1,'build','tool/build/index','',1,0,'C','0','0','tool:build:list','build','admin','2021-11-04 10:34:08','',NULL,'表单构建菜单'),(115,'代码生成',3,2,'gen','tool/gen/index','',1,0,'C','0','0','tool:gen:list','code','admin','2021-11-04 10:34:08','',NULL,'代码生成菜单'),(116,'系统接口',3,3,'swagger','tool/swagger/index','',1,0,'C','0','0','tool:swagger:list','swagger','admin','2021-11-04 10:34:08','',NULL,'系统接口菜单'),(500,'操作日志',108,1,'operlog','monitor/operlog/index','',1,0,'C','0','0','monitor:operlog:list','form','admin','2021-11-04 10:34:08','',NULL,'操作日志菜单'),(501,'登录日志',108,2,'logininfor','monitor/logininfor/index','',1,0,'C','0','0','monitor:logininfor:list','logininfor','admin','2021-11-04 10:34:08','',NULL,'登录日志菜单'),(1001,'用户查询',100,1,'','','',1,0,'F','0','0','system:user:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1002,'用户新增',100,2,'','','',1,0,'F','0','0','system:user:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1003,'用户修改',100,3,'','','',1,0,'F','0','0','system:user:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1004,'用户删除',100,4,'','','',1,0,'F','0','0','system:user:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1005,'用户导出',100,5,'','','',1,0,'F','0','0','system:user:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1006,'用户导入',100,6,'','','',1,0,'F','0','0','system:user:import','#','admin','2021-11-04 10:34:08','',NULL,''),(1007,'重置密码',100,7,'','','',1,0,'F','0','0','system:user:resetPwd','#','admin','2021-11-04 10:34:08','',NULL,''),(1008,'角色查询',101,1,'','','',1,0,'F','0','0','system:role:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1009,'角色新增',101,2,'','','',1,0,'F','0','0','system:role:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1010,'角色修改',101,3,'','','',1,0,'F','0','0','system:role:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1011,'角色删除',101,4,'','','',1,0,'F','0','0','system:role:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1012,'角色导出',101,5,'','','',1,0,'F','0','0','system:role:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1013,'菜单查询',102,1,'','','',1,0,'F','0','0','system:menu:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1014,'菜单新增',102,2,'','','',1,0,'F','0','0','system:menu:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1015,'菜单修改',102,3,'','','',1,0,'F','0','0','system:menu:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1016,'菜单删除',102,4,'','','',1,0,'F','0','0','system:menu:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1017,'部门查询',103,1,'','','',1,0,'F','0','0','system:dept:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1018,'部门新增',103,2,'','','',1,0,'F','0','0','system:dept:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1019,'部门修改',103,3,'','','',1,0,'F','0','0','system:dept:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1020,'部门删除',103,4,'','','',1,0,'F','0','0','system:dept:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1021,'岗位查询',104,1,'','','',1,0,'F','0','0','system:post:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1022,'岗位新增',104,2,'','','',1,0,'F','0','0','system:post:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1023,'岗位修改',104,3,'','','',1,0,'F','0','0','system:post:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1024,'岗位删除',104,4,'','','',1,0,'F','0','0','system:post:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1025,'岗位导出',104,5,'','','',1,0,'F','0','0','system:post:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1026,'字典查询',105,1,'#','','',1,0,'F','0','0','system:dict:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1027,'字典新增',105,2,'#','','',1,0,'F','0','0','system:dict:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1028,'字典修改',105,3,'#','','',1,0,'F','0','0','system:dict:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1029,'字典删除',105,4,'#','','',1,0,'F','0','0','system:dict:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1030,'字典导出',105,5,'#','','',1,0,'F','0','0','system:dict:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1031,'参数查询',106,1,'#','','',1,0,'F','0','0','system:config:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1032,'参数新增',106,2,'#','','',1,0,'F','0','0','system:config:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1033,'参数修改',106,3,'#','','',1,0,'F','0','0','system:config:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1034,'参数删除',106,4,'#','','',1,0,'F','0','0','system:config:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1035,'参数导出',106,5,'#','','',1,0,'F','0','0','system:config:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1036,'公告查询',107,1,'#','','',1,0,'F','0','0','system:notice:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1037,'公告新增',107,2,'#','','',1,0,'F','0','0','system:notice:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1038,'公告修改',107,3,'#','','',1,0,'F','0','0','system:notice:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1039,'公告删除',107,4,'#','','',1,0,'F','0','0','system:notice:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1040,'操作查询',500,1,'#','','',1,0,'F','0','0','monitor:operlog:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1041,'操作删除',500,2,'#','','',1,0,'F','0','0','monitor:operlog:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1042,'日志导出',500,4,'#','','',1,0,'F','0','0','monitor:operlog:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1043,'登录查询',501,1,'#','','',1,0,'F','0','0','monitor:logininfor:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1044,'登录删除',501,2,'#','','',1,0,'F','0','0','monitor:logininfor:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1045,'日志导出',501,3,'#','','',1,0,'F','0','0','monitor:logininfor:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1046,'在线查询',109,1,'#','','',1,0,'F','0','0','monitor:online:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1047,'批量强退',109,2,'#','','',1,0,'F','0','0','monitor:online:batchLogout','#','admin','2021-11-04 10:34:08','',NULL,''),(1048,'单条强退',109,3,'#','','',1,0,'F','0','0','monitor:online:forceLogout','#','admin','2021-11-04 10:34:08','',NULL,''),(1049,'任务查询',110,1,'#','','',1,0,'F','0','0','monitor:job:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1050,'任务新增',110,2,'#','','',1,0,'F','0','0','monitor:job:add','#','admin','2021-11-04 10:34:08','',NULL,''),(1051,'任务修改',110,3,'#','','',1,0,'F','0','0','monitor:job:edit','#','admin','2021-11-04 10:34:08','',NULL,''),(1052,'任务删除',110,4,'#','','',1,0,'F','0','0','monitor:job:remove','#','admin','2021-11-04 10:34:08','',NULL,''),(1053,'状态修改',110,5,'#','','',1,0,'F','0','0','monitor:job:changeStatus','#','admin','2021-11-04 10:34:08','',NULL,''),(1054,'任务导出',110,7,'#','','',1,0,'F','0','0','monitor:job:export','#','admin','2021-11-04 10:34:08','',NULL,''),(1055,'生成查询',115,1,'#','','',1,0,'F','0','0','tool:gen:query','#','admin','2021-11-04 10:34:08','',NULL,''),(1056,'生成修改',115,2,'#','','',1,0,'F','0','0','tool:gen:edit','#','admin','2021-11-04 10:34:09','',NULL,''),(1057,'生成删除',115,3,'#','','',1,0,'F','0','0','tool:gen:remove','#','admin','2021-11-04 10:34:09','',NULL,''),(1058,'导入代码',115,2,'#','','',1,0,'F','0','0','tool:gen:import','#','admin','2021-11-04 10:34:09','',NULL,''),(1059,'预览代码',115,4,'#','','',1,0,'F','0','0','tool:gen:preview','#','admin','2021-11-04 10:34:09','',NULL,''),(1060,'生成代码',115,5,'#','','',1,0,'F','0','0','tool:gen:code','#','admin','2021-11-04 10:34:09','',NULL,''),(2000,'数据信息',2006,1,'datainform','datainform/datainform/index',NULL,1,0,'C','0','0','datainform:datainform:list','documentation','admin','2021-11-04 12:17:26','admin','2021-11-04 18:10:00','数据管理菜单'),(2001,'数据管理查询',2000,1,'#','',NULL,1,0,'F','0','0','datainform:datainform:query','#','admin','2021-11-04 12:17:26','',NULL,''),(2002,'数据管理新增',2000,2,'#','',NULL,1,0,'F','0','0','datainform:datainform:add','#','admin','2021-11-04 12:17:26','',NULL,''),(2003,'数据管理修改',2000,3,'#','',NULL,1,0,'F','0','0','datainform:datainform:edit','#','admin','2021-11-04 12:17:26','',NULL,''),(2004,'数据管理删除',2000,4,'#','',NULL,1,0,'F','0','0','datainform:datainform:remove','#','admin','2021-11-04 12:17:26','',NULL,''),(2005,'数据管理导出',2000,5,'#','',NULL,1,0,'F','0','0','datainform:datainform:export','#','admin','2021-11-04 12:17:26','',NULL,''),(2006,'数据管理',0,1,'datainform',NULL,NULL,1,0,'M','0','0','','excel','admin','2021-11-04 14:43:23','admin','2021-11-04 14:45:03',''),(2007,'客观指标',2019,1,'objtarget','target/objtarget/index',NULL,1,0,'C','0','0','target:objtarget:list','dict','admin','2021-11-04 15:51:58','admin','2021-11-04 18:11:18','客观指标菜单'),(2008,'客观指标查询',2007,1,'#','',NULL,1,0,'F','0','0','target:objtarget:query','#','admin','2021-11-04 15:51:58','',NULL,''),(2009,'客观指标新增',2007,2,'#','',NULL,1,0,'F','0','0','target:objtarget:add','#','admin','2021-11-04 15:51:58','',NULL,''),(2010,'客观指标修改',2007,3,'#','',NULL,1,0,'F','0','0','target:objtarget:edit','#','admin','2021-11-04 15:51:58','',NULL,''),(2011,'客观指标删除',2007,4,'#','',NULL,1,0,'F','0','0','target:objtarget:remove','#','admin','2021-11-04 15:51:58','',NULL,''),(2012,'客观指标导出',2007,5,'#','',NULL,1,0,'F','0','0','target:objtarget:export','#','admin','2021-11-04 15:51:58','',NULL,''),(2013,'主观指标',2019,2,'subjtarget','target/subjtarget/index',NULL,1,0,'C','0','0','target:subjtarget:list','drag','admin','2021-11-04 15:52:21','admin','2021-11-04 18:11:29','主观指标菜单'),(2014,'主观指标查询',2013,1,'#','',NULL,1,0,'F','0','0','target:subjtarget:query','#','admin','2021-11-04 15:52:21','',NULL,''),(2015,'主观指标新增',2013,2,'#','',NULL,1,0,'F','0','0','target:subjtarget:add','#','admin','2021-11-04 15:52:21','',NULL,''),(2016,'主观指标修改',2013,3,'#','',NULL,1,0,'F','0','0','target:subjtarget:edit','#','admin','2021-11-04 15:52:21','',NULL,''),(2017,'主观指标删除',2013,4,'#','',NULL,1,0,'F','0','0','target:subjtarget:remove','#','admin','2021-11-04 15:52:21','',NULL,''),(2018,'主观指标导出',2013,5,'#','',NULL,1,0,'F','0','0','target:subjtarget:export','#','admin','2021-11-04 15:52:21','',NULL,''),(2019,'指标管理',0,2,'target',NULL,NULL,1,0,'M','0','0',NULL,'chart','admin','2021-11-04 15:57:25','',NULL,''),(2020,'教学质量评测',2044,2,'eduqualityeval','evaluation/eduqualityeval/index',NULL,1,0,'C','0','0','evaluation:eduqualityeval:list','server','admin','2021-11-04 16:30:26','admin','2021-11-04 18:12:49','教学质量评测菜单'),(2021,'教学质量评测查询',2020,1,'#','',NULL,1,0,'F','0','0','evaluation:eduqualityeval:query','#','admin','2021-11-04 16:30:26','',NULL,''),(2022,'教学质量评测新增',2020,2,'#','',NULL,1,0,'F','0','0','evaluation:eduqualityeval:add','#','admin','2021-11-04 16:30:26','',NULL,''),(2023,'教学质量评测修改',2020,3,'#','',NULL,1,0,'F','0','0','evaluation:eduqualityeval:edit','#','admin','2021-11-04 16:30:26','',NULL,''),(2024,'教学质量评测删除',2020,4,'#','',NULL,1,0,'F','0','0','evaluation:eduqualityeval:remove','#','admin','2021-11-04 16:30:26','',NULL,''),(2025,'教学质量评测导出',2020,5,'#','',NULL,1,0,'F','0','0','evaluation:eduqualityeval:export','#','admin','2021-11-04 16:30:26','',NULL,''),(2026,'学校测评',2044,1,'schooledueval','evaluation/schooledueval/index',NULL,1,0,'C','0','0','evaluation:schooledueval:list','list','admin','2021-11-04 16:30:47','admin','2021-11-04 18:11:49','学校测评菜单'),(2027,'学校测评查询',2026,1,'#','',NULL,1,0,'F','0','0','evaluation:schooledueval:query','#','admin','2021-11-04 16:30:47','',NULL,''),(2028,'学校测评新增',2026,2,'#','',NULL,1,0,'F','0','0','evaluation:schooledueval:add','#','admin','2021-11-04 16:30:47','',NULL,''),(2029,'学校测评修改',2026,3,'#','',NULL,1,0,'F','0','0','evaluation:schooledueval:edit','#','admin','2021-11-04 16:30:47','',NULL,''),(2030,'学校测评删除',2026,4,'#','',NULL,1,0,'F','0','0','evaluation:schooledueval:remove','#','admin','2021-11-04 16:30:47','',NULL,''),(2031,'学校测评导出',2026,5,'#','',NULL,1,0,'F','0','0','evaluation:schooledueval:export','#','admin','2021-11-04 16:30:47','',NULL,''),(2032,'老师教学测评',2044,3,'teacheredueval','evaluation/teacheredueval/index',NULL,1,0,'C','0','0','evaluation:teacheredueval:list','peoples','admin','2021-11-04 16:31:12','admin','2021-11-04 18:12:22','老师教学测评菜单'),(2033,'老师教学测评查询',2032,1,'#','',NULL,1,0,'F','0','0','evaluation:teacheredueval:query','#','admin','2021-11-04 16:31:12','',NULL,''),(2034,'老师教学测评新增',2032,2,'#','',NULL,1,0,'F','0','0','evaluation:teacheredueval:add','#','admin','2021-11-04 16:31:12','',NULL,''),(2035,'老师教学测评修改',2032,3,'#','',NULL,1,0,'F','0','0','evaluation:teacheredueval:edit','#','admin','2021-11-04 16:31:12','',NULL,''),(2036,'老师教学测评删除',2032,4,'#','',NULL,1,0,'F','0','0','evaluation:teacheredueval:remove','#','admin','2021-11-04 16:31:12','',NULL,''),(2037,'老师教学测评导出',2032,5,'#','',NULL,1,0,'F','0','0','evaluation:teacheredueval:export','#','admin','2021-11-04 16:31:12','',NULL,''),(2038,'老师个人测评',2044,4,'teachpersioneval','evaluation/teachpersioneval/index',NULL,1,0,'C','0','0','evaluation:teachpersioneval:list','people','admin','2021-11-04 16:31:26','admin','2021-11-04 18:12:14','老师个人测评菜单'),(2039,'老师个人测评查询',2038,1,'#','',NULL,1,0,'F','0','0','evaluation:teachpersioneval:query','#','admin','2021-11-04 16:31:27','',NULL,''),(2040,'老师个人测评新增',2038,2,'#','',NULL,1,0,'F','0','0','evaluation:teachpersioneval:add','#','admin','2021-11-04 16:31:27','',NULL,''),(2041,'老师个人测评修改',2038,3,'#','',NULL,1,0,'F','0','0','evaluation:teachpersioneval:edit','#','admin','2021-11-04 16:31:27','',NULL,''),(2042,'老师个人测评删除',2038,4,'#','',NULL,1,0,'F','0','0','evaluation:teachpersioneval:remove','#','admin','2021-11-04 16:31:27','',NULL,''),(2043,'老师个人测评导出',2038,5,'#','',NULL,1,0,'F','0','0','evaluation:teachpersioneval:export','#','admin','2021-11-04 16:31:27','',NULL,''),(2044,'测评管理',0,3,'evaluation',NULL,NULL,1,0,'M','0','0',NULL,'druid','admin','2021-11-04 16:32:58','',NULL,''),(2057,'测评分析',0,4,'evalanalyze',NULL,NULL,1,0,'M','0','0','','build','admin','2021-11-04 16:51:04','admin','2021-11-04 17:59:56',''),(2058,'学校教学追溯',2132,1,'schedutrace','edutrace/schedutrace/index',NULL,1,0,'C','0','0','edutrace:schedutrace:list','cascader','admin','2021-11-04 17:08:59','admin','2021-11-04 18:13:56','学校教学追溯菜单'),(2059,'学校教学追溯查询',2058,1,'#','',NULL,1,0,'F','0','0','edutrace:schedutrace:query','#','admin','2021-11-04 17:08:59','',NULL,''),(2060,'学校教学追溯新增',2058,2,'#','',NULL,1,0,'F','0','0','edutrace:schedutrace:add','#','admin','2021-11-04 17:08:59','',NULL,''),(2061,'学校教学追溯修改',2058,3,'#','',NULL,1,0,'F','0','0','edutrace:schedutrace:edit','#','admin','2021-11-04 17:08:59','',NULL,''),(2062,'学校教学追溯删除',2058,4,'#','',NULL,1,0,'F','0','0','edutrace:schedutrace:remove','#','admin','2021-11-04 17:08:59','',NULL,''),(2063,'学校教学追溯导出',2058,5,'#','',NULL,1,0,'F','0','0','edutrace:schedutrace:export','#','admin','2021-11-04 17:08:59','',NULL,''),(2064,'学生教学追溯',2132,3,'stuedutrace','edutrace/stuedutrace/index',NULL,1,0,'C','0','0','edutrace:stuedutrace:list','people','admin','2021-11-04 17:09:16','admin','2021-11-04 18:14:22','学生教学质量追溯菜单'),(2065,'学生教学质量追溯查询',2064,1,'#','',NULL,1,0,'F','0','0','edutrace:stuedutrace:query','#','admin','2021-11-04 17:09:16','',NULL,''),(2066,'学生教学质量追溯新增',2064,2,'#','',NULL,1,0,'F','0','0','edutrace:stuedutrace:add','#','admin','2021-11-04 17:09:16','',NULL,''),(2067,'学生教学质量追溯修改',2064,3,'#','',NULL,1,0,'F','0','0','edutrace:stuedutrace:edit','#','admin','2021-11-04 17:09:16','',NULL,''),(2068,'学生教学质量追溯删除',2064,4,'#','',NULL,1,0,'F','0','0','edutrace:stuedutrace:remove','#','admin','2021-11-04 17:09:16','',NULL,''),(2069,'学生教学质量追溯导出',2064,5,'#','',NULL,1,0,'F','0','0','edutrace:stuedutrace:export','#','admin','2021-11-04 17:09:16','',NULL,''),(2070,'老师教学追溯',2132,2,'teachedutrace','edutrace/teachedutrace/index',NULL,1,0,'C','0','0','edutrace:teachedutrace:list','peoples','admin','2021-11-04 17:09:33','admin','2021-11-04 18:14:14','老师教学追溯菜单'),(2071,'老师教学追溯查询',2070,1,'#','',NULL,1,0,'F','0','0','edutrace:teachedutrace:query','#','admin','2021-11-04 17:09:33','',NULL,''),(2072,'老师教学追溯新增',2070,2,'#','',NULL,1,0,'F','0','0','edutrace:teachedutrace:add','#','admin','2021-11-04 17:09:33','',NULL,''),(2073,'老师教学追溯修改',2070,3,'#','',NULL,1,0,'F','0','0','edutrace:teachedutrace:edit','#','admin','2021-11-04 17:09:33','',NULL,''),(2074,'老师教学追溯删除',2070,4,'#','',NULL,1,0,'F','0','0','edutrace:teachedutrace:remove','#','admin','2021-11-04 17:09:33','',NULL,''),(2075,'老师教学追溯导出',2070,5,'#','',NULL,1,0,'F','0','0','edutrace:teachedutrace:export','#','admin','2021-11-04 17:09:33','',NULL,''),(2076,'班级信息',2130,2,'schclass','school/schclass/index',NULL,1,0,'C','0','0','school:schclass:list','table','admin','2021-11-04 17:21:30','admin','2021-11-04 18:15:07','班级信息菜单'),(2077,'班级信息查询',2076,1,'#','',NULL,1,0,'F','0','0','school:schclass:query','#','admin','2021-11-04 17:21:30','',NULL,''),(2078,'班级信息新增',2076,2,'#','',NULL,1,0,'F','0','0','school:schclass:add','#','admin','2021-11-04 17:21:30','',NULL,''),(2079,'班级信息修改',2076,3,'#','',NULL,1,0,'F','0','0','school:schclass:edit','#','admin','2021-11-04 17:21:30','',NULL,''),(2080,'班级信息删除',2076,4,'#','',NULL,1,0,'F','0','0','school:schclass:remove','#','admin','2021-11-04 17:21:30','',NULL,''),(2081,'班级信息导出',2076,5,'#','',NULL,1,0,'F','0','0','school:schclass:export','#','admin','2021-11-04 17:21:30','',NULL,''),(2082,'学校信息',2130,1,'schschool','school/schschool/index',NULL,1,0,'C','0','0','school:schschool:list','tree','admin','2021-11-04 17:21:44','admin','2021-11-04 18:14:38','学校信息菜单'),(2083,'学校信息查询',2082,1,'#','',NULL,1,0,'F','0','0','school:schschool:query','#','admin','2021-11-04 17:21:44','',NULL,''),(2084,'学校信息新增',2082,2,'#','',NULL,1,0,'F','0','0','school:schschool:add','#','admin','2021-11-04 17:21:44','',NULL,''),(2085,'学校信息修改',2082,3,'#','',NULL,1,0,'F','0','0','school:schschool:edit','#','admin','2021-11-04 17:21:44','',NULL,''),(2086,'学校信息删除',2082,4,'#','',NULL,1,0,'F','0','0','school:schschool:remove','#','admin','2021-11-04 17:21:44','',NULL,''),(2087,'学校信息导出',2082,5,'#','',NULL,1,0,'F','0','0','school:schschool:export','#','admin','2021-11-04 17:21:44','',NULL,''),(2088,'学生信息',2130,1,'schstudent','school/schstudent/index',NULL,1,0,'C','0','0','school:schstudent:list','user','admin','2021-11-04 17:22:02','admin','2021-11-04 18:14:48','学生信息菜单'),(2089,'学生信息查询',2088,1,'#','',NULL,1,0,'F','0','0','school:schstudent:query','#','admin','2021-11-04 17:22:02','',NULL,''),(2090,'学生信息新增',2088,2,'#','',NULL,1,0,'F','0','0','school:schstudent:add','#','admin','2021-11-04 17:22:02','',NULL,''),(2091,'学生信息修改',2088,3,'#','',NULL,1,0,'F','0','0','school:schstudent:edit','#','admin','2021-11-04 17:22:02','',NULL,''),(2092,'学生信息删除',2088,4,'#','',NULL,1,0,'F','0','0','school:schstudent:remove','#','admin','2021-11-04 17:22:02','',NULL,''),(2093,'学生信息导出',2088,5,'#','',NULL,1,0,'F','0','0','school:schstudent:export','#','admin','2021-11-04 17:22:02','',NULL,''),(2094,'教师信息',2130,3,'schteacher','school/schteacher/index',NULL,1,0,'C','0','0','school:schteacher:list','peoples','admin','2021-11-04 17:22:29','admin','2021-11-04 18:15:17','教师信息菜单'),(2095,'教师信息查询',2094,1,'#','',NULL,1,0,'F','0','0','school:schteacher:query','#','admin','2021-11-04 17:22:29','',NULL,''),(2096,'教师信息新增',2094,2,'#','',NULL,1,0,'F','0','0','school:schteacher:add','#','admin','2021-11-04 17:22:29','',NULL,''),(2097,'教师信息修改',2094,3,'#','',NULL,1,0,'F','0','0','school:schteacher:edit','#','admin','2021-11-04 17:22:29','',NULL,''),(2098,'教师信息删除',2094,4,'#','',NULL,1,0,'F','0','0','school:schteacher:remove','#','admin','2021-11-04 17:22:29','',NULL,''),(2099,'教师信息导出',2094,5,'#','',NULL,1,0,'F','0','0','school:schteacher:export','#','admin','2021-11-04 17:22:29','',NULL,''),(2100,'平均分数',2131,5,'averagescore','basicdata/averagescore/index',NULL,1,0,'C','0','0','basicdata:averagescore:list','number','admin','2021-11-04 17:33:50','admin','2021-11-04 18:16:22','平均分数菜单'),(2101,'平均分数查询',2100,1,'#','',NULL,1,0,'F','0','0','basicdata:averagescore:query','#','admin','2021-11-04 17:33:50','',NULL,''),(2102,'平均分数新增',2100,2,'#','',NULL,1,0,'F','0','0','basicdata:averagescore:add','#','admin','2021-11-04 17:33:50','',NULL,''),(2103,'平均分数修改',2100,3,'#','',NULL,1,0,'F','0','0','basicdata:averagescore:edit','#','admin','2021-11-04 17:33:50','',NULL,''),(2104,'平均分数删除',2100,4,'#','',NULL,1,0,'F','0','0','basicdata:averagescore:remove','#','admin','2021-11-04 17:33:50','',NULL,''),(2105,'平均分数导出',2100,5,'#','',NULL,1,0,'F','0','0','basicdata:averagescore:export','#','admin','2021-11-04 17:33:50','',NULL,''),(2106,'科目信息',2131,4,'courseinfo','basicdata/courseinfo/index',NULL,1,0,'C','0','0','basicdata:courseinfo:list','clipboard','admin','2021-11-04 17:34:10','admin','2021-11-04 18:16:06','科目信息菜单'),(2107,'科目信息查询',2106,1,'#','',NULL,1,0,'F','0','0','basicdata:courseinfo:query','#','admin','2021-11-04 17:34:10','',NULL,''),(2108,'科目信息新增',2106,2,'#','',NULL,1,0,'F','0','0','basicdata:courseinfo:add','#','admin','2021-11-04 17:34:10','',NULL,''),(2109,'科目信息修改',2106,3,'#','',NULL,1,0,'F','0','0','basicdata:courseinfo:edit','#','admin','2021-11-04 17:34:10','',NULL,''),(2110,'科目信息删除',2106,4,'#','',NULL,1,0,'F','0','0','basicdata:courseinfo:remove','#','admin','2021-11-04 17:34:10','',NULL,''),(2111,'科目信息导出',2106,5,'#','',NULL,1,0,'F','0','0','basicdata:courseinfo:export','#','admin','2021-11-04 17:34:10','',NULL,''),(2112,'学校类型',2131,1,'schooltype','basicdata/schooltype/index',NULL,1,0,'C','0','0','basicdata:schooltype:list','build','admin','2021-11-04 17:34:34','admin','2021-11-04 18:15:38','学校类型菜单'),(2113,'学校类型查询',2112,1,'#','',NULL,1,0,'F','0','0','basicdata:schooltype:query','#','admin','2021-11-04 17:34:34','',NULL,''),(2114,'学校类型新增',2112,2,'#','',NULL,1,0,'F','0','0','basicdata:schooltype:add','#','admin','2021-11-04 17:34:34','',NULL,''),(2115,'学校类型修改',2112,3,'#','',NULL,1,0,'F','0','0','basicdata:schooltype:edit','#','admin','2021-11-04 17:34:34','',NULL,''),(2116,'学校类型删除',2112,4,'#','',NULL,1,0,'F','0','0','basicdata:schooltype:remove','#','admin','2021-11-04 17:34:34','',NULL,''),(2117,'学校类型导出',2112,5,'#','',NULL,1,0,'F','0','0','basicdata:schooltype:export','#','admin','2021-11-04 17:34:34','',NULL,''),(2118,'学年信息',2131,2,'schoolyear','basicdata/schoolyear/index',NULL,1,0,'C','0','0','basicdata:schoolyear:list','date-range','admin','2021-11-04 17:34:53','admin','2021-11-04 18:15:48','学年信息菜单'),(2119,'学年信息查询',2118,1,'#','',NULL,1,0,'F','0','0','basicdata:schoolyear:query','#','admin','2021-11-04 17:34:53','',NULL,''),(2120,'学年信息新增',2118,2,'#','',NULL,1,0,'F','0','0','basicdata:schoolyear:add','#','admin','2021-11-04 17:34:53','',NULL,''),(2121,'学年信息修改',2118,3,'#','',NULL,1,0,'F','0','0','basicdata:schoolyear:edit','#','admin','2021-11-04 17:34:53','',NULL,''),(2122,'学年信息删除',2118,4,'#','',NULL,1,0,'F','0','0','basicdata:schoolyear:remove','#','admin','2021-11-04 17:34:53','',NULL,''),(2123,'学年信息导出',2118,5,'#','',NULL,1,0,'F','0','0','basicdata:schoolyear:export','#','admin','2021-11-04 17:34:53','',NULL,''),(2124,'学期信息',2131,3,'semester','basicdata/semester/index',NULL,1,0,'C','0','0','basicdata:semester:list','date','admin','2021-11-04 17:35:12','admin','2021-11-04 18:15:55','学期信息菜单'),(2125,'学期信息查询',2124,1,'#','',NULL,1,0,'F','0','0','basicdata:semester:query','#','admin','2021-11-04 17:35:12','',NULL,''),(2126,'学期信息新增',2124,2,'#','',NULL,1,0,'F','0','0','basicdata:semester:add','#','admin','2021-11-04 17:35:12','',NULL,''),(2127,'学期信息修改',2124,3,'#','',NULL,1,0,'F','0','0','basicdata:semester:edit','#','admin','2021-11-04 17:35:13','',NULL,''),(2128,'学期信息删除',2124,4,'#','',NULL,1,0,'F','0','0','basicdata:semester:remove','#','admin','2021-11-04 17:35:13','',NULL,''),(2129,'学期信息导出',2124,5,'#','',NULL,1,0,'F','0','0','basicdata:semester:export','#','admin','2021-11-04 17:35:13','',NULL,''),(2130,'学校管理',0,6,'school',NULL,NULL,1,0,'M','0','0','','tree','admin','2021-11-04 17:38:04','admin','2021-11-04 18:08:02',''),(2131,'基础数据',0,7,'basicdata',NULL,NULL,1,0,'M','0','0','','edit','admin','2021-11-04 17:38:32','admin','2021-11-04 18:09:13',''),(2132,'教学追溯',0,5,'edutrace',NULL,NULL,1,0,'M','0','0','','guide','admin','2021-11-04 17:41:00','admin','2021-11-04 18:07:21',''),(2133,'学校测评分析',2057,1,'schevalanalyze','evalanalyze/schevalanalyze/index',NULL,1,0,'C','0','0','evalanalyze:schevalanalyze:list','chart','admin','2021-11-04 18:00:27','admin','2021-11-04 18:13:14','学校测评分析菜单'),(2134,'学校测评分析查询',2133,1,'#','',NULL,1,0,'F','0','0','evalanalyze:schevalanalyze:query','#','admin','2021-11-04 18:00:27','',NULL,''),(2135,'学校测评分析新增',2133,2,'#','',NULL,1,0,'F','0','0','evalanalyze:schevalanalyze:add','#','admin','2021-11-04 18:00:27','',NULL,''),(2136,'学校测评分析修改',2133,3,'#','',NULL,1,0,'F','0','0','evalanalyze:schevalanalyze:edit','#','admin','2021-11-04 18:00:27','',NULL,''),(2137,'学校测评分析删除',2133,4,'#','',NULL,1,0,'F','0','0','evalanalyze:schevalanalyze:remove','#','admin','2021-11-04 18:00:27','',NULL,''),(2138,'学校测评分析导出',2133,5,'#','',NULL,1,0,'F','0','0','evalanalyze:schevalanalyze:export','#','admin','2021-11-04 18:00:27','',NULL,''),(2139,'老师测评分析',2057,2,'teachevalanalyze','evalanalyze/teachevalanalyze/index',NULL,1,0,'C','0','0','evalanalyze:teachevalanalyze:list','user','admin','2021-11-04 18:00:42','admin','2021-11-04 18:13:27','老师测评分析菜单'),(2140,'老师测评分析查询',2139,1,'#','',NULL,1,0,'F','0','0','evalanalyze:teachevalanalyze:query','#','admin','2021-11-04 18:00:42','',NULL,''),(2141,'老师测评分析新增',2139,2,'#','',NULL,1,0,'F','0','0','evalanalyze:teachevalanalyze:add','#','admin','2021-11-04 18:00:42','',NULL,''),(2142,'老师测评分析修改',2139,3,'#','',NULL,1,0,'F','0','0','evalanalyze:teachevalanalyze:edit','#','admin','2021-11-04 18:00:42','',NULL,''),(2143,'老师测评分析删除',2139,4,'#','',NULL,1,0,'F','0','0','evalanalyze:teachevalanalyze:remove','#','admin','2021-11-04 18:00:42','',NULL,''),(2144,'老师测评分析导出',2139,5,'#','',NULL,1,0,'F','0','0','evalanalyze:teachevalanalyze:export','#','admin','2021-11-04 18:00:42','',NULL,'');

/*Table structure for table `sys_notice` */

DROP TABLE IF EXISTS `sys_notice`;

CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='通知公告表';

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`notice_id`,`notice_title`,`notice_type`,`notice_content`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'温馨提醒：2018-07-01 若依新版本发布啦','2','新版本内容','0','admin','2021-11-05 08:56:21','',NULL,'管理员'),(2,'维护通知：2018-07-01 若依系统凌晨维护','1','维护内容','0','admin','2021-11-05 08:56:21','',NULL,'管理员');

/*Table structure for table `sys_oper_log` */

DROP TABLE IF EXISTS `sys_oper_log`;

CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='操作日志记录';

/*Data for the table `sys_oper_log` */

/*Table structure for table `sys_post` */

DROP TABLE IF EXISTS `sys_post`;

CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='岗位信息表';

/*Data for the table `sys_post` */

insert  into `sys_post`(`post_id`,`post_code`,`post_name`,`post_sort`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'ceo','董事长',1,'0','admin','2021-11-05 08:56:20','',NULL,''),(2,'se','项目经理',2,'0','admin','2021-11-05 08:56:20','',NULL,''),(3,'hr','人力资源',3,'0','admin','2021-11-05 08:56:20','',NULL,''),(4,'user','普通员工',4,'0','admin','2021-11-05 08:56:21','',NULL,'');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_key`,`role_sort`,`data_scope`,`menu_check_strictly`,`dept_check_strictly`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'超级管理员','admin',1,'1',1,1,'0','0','admin','2021-11-05 08:56:21','',NULL,'超级管理员'),(2,'普通角色','common',2,'2',1,1,'0','0','admin','2021-11-05 08:56:21','',NULL,'普通角色');

/*Table structure for table `sys_role_dept` */

DROP TABLE IF EXISTS `sys_role_dept`;

CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和部门关联表';

/*Data for the table `sys_role_dept` */

insert  into `sys_role_dept`(`role_id`,`dept_id`) values (2,100),(2,101),(2,105);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values (2,1),(2,2),(2,3),(2,4),(2,100),(2,101),(2,102),(2,103),(2,104),(2,105),(2,106),(2,107),(2,108),(2,109),(2,110),(2,111),(2,112),(2,113),(2,114),(2,115),(2,116),(2,500),(2,501),(2,1000),(2,1001),(2,1002),(2,1003),(2,1004),(2,1005),(2,1006),(2,1007),(2,1008),(2,1009),(2,1010),(2,1011),(2,1012),(2,1013),(2,1014),(2,1015),(2,1016),(2,1017),(2,1018),(2,1019),(2,1020),(2,1021),(2,1022),(2,1023),(2,1024),(2,1025),(2,1026),(2,1027),(2,1028),(2,1029),(2,1030),(2,1031),(2,1032),(2,1033),(2,1034),(2,1035),(2,1036),(2,1037),(2,1038),(2,1039),(2,1040),(2,1041),(2,1042),(2,1043),(2,1044),(2,1045),(2,1046),(2,1047),(2,1048),(2,1049),(2,1050),(2,1051),(2,1052),(2,1053),(2,1054),(2,1055),(2,1056),(2,1057),(2,1058),(2,1059),(2,1060);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`dept_id`,`user_name`,`nick_name`,`user_type`,`email`,`phonenumber`,`sex`,`avatar`,`password`,`status`,`del_flag`,`login_ip`,`login_date`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,103,'admin','若依','00','ry@163.com','15888888888','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2021-11-05 09:06:08','admin','2021-11-05 08:56:20','','2021-11-05 09:06:07','管理员'),(2,105,'ry','若依','00','ry@qq.com','15666666666','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2021-11-05 08:56:20','admin','2021-11-05 08:56:20','',NULL,'测试员');

/*Table structure for table `sys_user_post` */

DROP TABLE IF EXISTS `sys_user_post`;

CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与岗位关联表';

/*Data for the table `sys_user_post` */

insert  into `sys_user_post`(`user_id`,`post_id`) values (1,1),(2,2);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values (1,1),(2,2);

/*Table structure for table `tar_obj` */

DROP TABLE IF EXISTS `tar_obj`;

CREATE TABLE `tar_obj` (
  `tar_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '指标ID',
  `group_name` varchar(200) NOT NULL COMMENT '组名称',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_year` varchar(200) NOT NULL COMMENT '所属学年',
  `semester` varchar(200) NOT NULL COMMENT '所属学期',
  `tar_type` varchar(200) NOT NULL COMMENT '指标类型',
  `description` varchar(500) NOT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '创建人',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `ref_state` char(1) NOT NULL COMMENT '引用状态（0未引用，1引用）',
  PRIMARY KEY (`tar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客观指标表';

/*Data for the table `tar_obj` */

/*Table structure for table `tar_subj` */

DROP TABLE IF EXISTS `tar_subj`;

CREATE TABLE `tar_subj` (
  `tar_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '指标ID',
  `group_name` varchar(200) NOT NULL COMMENT '组名称',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_year` varchar(200) NOT NULL COMMENT '所属学年',
  `semester` varchar(200) NOT NULL COMMENT '所属学期',
  `tar_type` varchar(200) NOT NULL COMMENT '指标类型',
  `description` varchar(500) NOT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '创建人',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `ref_state` char(1) NOT NULL COMMENT '引用状态（0未引用，1引用）',
  PRIMARY KEY (`tar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='主观指标表';

/*Data for the table `tar_subj` */

/*Table structure for table `trace_edu_sch` */

DROP TABLE IF EXISTS `trace_edu_sch`;

CREATE TABLE `trace_edu_sch` (
  `trace_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学校教程追溯ID',
  `trace_name` varchar(200) NOT NULL COMMENT '统计名称',
  `sch_name` varchar(200) NOT NULL COMMENT '学校名称',
  `sch_id` bigint(20) NOT NULL COMMENT '学校ID',
  `grade` varchar(200) NOT NULL COMMENT '年级',
  `count_time` varchar(200) NOT NULL COMMENT '统计时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`trace_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校教学追溯表';

/*Data for the table `trace_edu_sch` */

/*Table structure for table `trace_edu_student` */

DROP TABLE IF EXISTS `trace_edu_student`;

CREATE TABLE `trace_edu_student` (
  `trace_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生教学质量追溯ID',
  `trace_name` varchar(200) NOT NULL COMMENT '学生教学追溯报告名称',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `stu_name` varchar(200) NOT NULL COMMENT '学生姓名',
  `sch_num` varchar(200) NOT NULL COMMENT '学籍号（身份证号）',
  `count_time` varchar(200) NOT NULL COMMENT '统计时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`trace_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生教学质量追溯表';

/*Data for the table `trace_edu_student` */

/*Table structure for table `trace_edu_teach` */

DROP TABLE IF EXISTS `trace_edu_teach`;

CREATE TABLE `trace_edu_teach` (
  `trace_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '教师追溯ID',
  `trace_name` varchar(200) NOT NULL COMMENT '老师追溯报告名称',
  `academic` varchar(200) NOT NULL COMMENT '学业阶段',
  `sch_semester` varchar(200) NOT NULL COMMENT '所属学年学期',
  `obj_eval` varchar(200) NOT NULL COMMENT '客观评价',
  `subj_eval` varchar(200) NOT NULL COMMENT '主观评价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`trace_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='老师教学质量追溯表';

/*Data for the table `trace_edu_teach` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
