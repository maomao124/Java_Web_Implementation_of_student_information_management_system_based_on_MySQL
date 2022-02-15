/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : student1

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 15/02/2022 15:26:33
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrators
-- ----------------------------
DROP TABLE IF EXISTS `administrators`;
CREATE TABLE `administrators`
(
    `administrator_no`               bigint                                                 NOT NULL COMMENT '管理员编号',
    `administrator_name`             varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员姓名',
    `administrator_sex`              varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '管理员性别',
    `administrator_telephone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员手机号码',
    `administrator_job`              varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员职务',
    `administrator_idcard`           varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员身份证号码',
    PRIMARY KEY (`administrator_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for administrators_password
-- ----------------------------
DROP TABLE IF EXISTS `administrators_password`;
CREATE TABLE `administrators_password`
(
    `administrator_no`       bigint                                                  NOT NULL COMMENT '管理员编号',
    `administrator_password` varchar(130) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码，散列值',
    INDEX                    `administrator_no`(`administrator_no`) USING BTREE,
    CONSTRAINT `administrator_no` FOREIGN KEY (`administrator_no`) REFERENCES `administrators` (`administrator_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`
(
    `class_no`              bigint                                                 NOT NULL COMMENT '班级编号',
    `class_name`            varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
    `class_college`         varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在学院',
    `class_major`           varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属专业',
    `class_enrollment_year` int                                                    NOT NULL COMMENT '入学年份',
    PRIMARY KEY (`class_no`) USING BTREE,
    UNIQUE INDEX `class_no`(`class_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `course_no`     bigint                                                 NOT NULL COMMENT '课程编号',
    `course_name`   varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
    `course_credit` float                                                  NOT NULL COMMENT '课程学分',
    `course_hour`   int                                                    NOT NULL COMMENT '课程学时',
    `course_mode`   varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '方式，考试或者考查',
    PRIMARY KEY (`course_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`
(
    `forum_no`        bigint                                                 NOT NULL AUTO_INCREMENT COMMENT '论坛编号，楼层',
    `forum_people_no` bigint                                                 NOT NULL COMMENT '论坛发布者的学号或职工号，当发布不当言论时，可以通过此消息定位到某个人，不对外显示，和其它表独立',
    `forum_name`      varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '论坛发布者姓名',
    `forum_identity`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论坛发布者身份，学生，老师或者管理员',
    `forum_time`      varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论坛发布时间，varchar类型，这里用程序填充时间',
    `forum_content`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论坛文字内容，最大长度255字',
    PRIMARY KEY (`forum_no`) USING BTREE,
    UNIQUE INDEX `forum`(`forum_no`) USING BTREE COMMENT '唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '此表应该独立，当学生被删除时，学生发表的论坛内容应该保存在论坛里' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`
(
    `log_no`       bigint NOT NULL AUTO_INCREMENT COMMENT '登录日志编号',
    `log_time`     varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录时间',
    `log_login_no` bigint NULL DEFAULT NULL COMMENT '登录人的学号或者编号',
    `log_name`     varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录人的姓名',
    PRIMARY KEY (`log_no`) USING BTREE,
    UNIQUE INDEX `log_no`(`log_no`) USING BTREE COMMENT '索引'
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '此表为登录日志表，此表应该独立存在，不设外键' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`
(
    `new_no`       bigint NOT NULL AUTO_INCREMENT COMMENT '新闻编号',
    `new_author`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻发布者(作者)',
    `new_identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻发布者身份',
    `new_time`     varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻发布时间,这里使用varchar型，时间由程序填充',
    `new_title`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻标题',
    `new_text`     text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '新闻内容',
    PRIMARY KEY (`new_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '此表应该独立' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`
(
    `no`          bigint NOT NULL COMMENT '学生学号',
    `course_no`   bigint NOT NULL COMMENT '课程编号',
    `usual_score` float NULL DEFAULT NULL COMMENT '平时成绩',
    `end_score`   float NULL DEFAULT NULL COMMENT '期末成绩',
    `final_score` float NULL DEFAULT NULL COMMENT '最终分数',
    `grade_point` float NULL DEFAULT NULL COMMENT '绩点',
    `semester`    varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学期',
    INDEX         `no1`(`no`) USING BTREE,
    INDEX         `course_no`(`course_no`) USING BTREE,
    CONSTRAINT `course_no` FOREIGN KEY (`course_no`) REFERENCES `course` (`course_no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `no1` FOREIGN KEY (`no`) REFERENCES `student` (`student_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `student_no`              bigint                                                 NOT NULL COMMENT '学生学号',
    `name`                    varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
    `sex`                     varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '学生性别',
    `telephone_number`        varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
    `family_telephone_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭电话号码',
    `birthday`                varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生日信息，由程序填充，这里用varchar型',
    `address`                 varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
    `id_card`                 varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号码',
    `email`                   varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
    `dormitory_number`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寝室号',
    `class_no`                bigint                                                 NOT NULL COMMENT '所属班级编号',
    `state`                   varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态，在读、退学或者毕业',
    `remarks`                 varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`student_no`) USING BTREE,
    UNIQUE INDEX `no`(`student_no`) USING BTREE,
    INDEX                     `class_no`(`class_no`) USING BTREE,
    CONSTRAINT `class_no` FOREIGN KEY (`class_no`) REFERENCES `class` (`class_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student_password
-- ----------------------------
DROP TABLE IF EXISTS `student_password`;
CREATE TABLE `student_password`
(
    `no`       bigint                                                 NOT NULL COMMENT '学生学号',
    `password` varchar(34) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生登录密码，散列值',
    INDEX      `no`(`no`) USING BTREE,
    CONSTRAINT `no` FOREIGN KEY (`no`) REFERENCES `student` (`student_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach`
(
    `teach_no`   bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `teacher_no` bigint NOT NULL COMMENT '老师编号',
    `class_no`   bigint NULL DEFAULT NULL COMMENT '老师所教的班级',
    `course_no`  bigint NULL DEFAULT NULL COMMENT '老师所教的课程',
    `semester`   varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学期,比如：2019年下学期',
    PRIMARY KEY (`teach_no`) USING BTREE,
    INDEX        `teacher_no1`(`teacher_no`) USING BTREE,
    INDEX        `class_no1`(`class_no`) USING BTREE,
    INDEX        `course_no1`(`course_no`) USING BTREE,
    CONSTRAINT `class_no1` FOREIGN KEY (`class_no`) REFERENCES `class` (`class_no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `course_no1` FOREIGN KEY (`course_no`) REFERENCES `course` (`course_no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `teacher_no1` FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 308 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
    `teacher_no`               bigint                                                 NOT NULL COMMENT '老师编号',
    `teacher_name`             varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老师姓名',
    `teacher_sex`              varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '老师性别',
    `teacher_telephone_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师电话号码',
    `teacher_email`            varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师邮箱',
    `teacher_address`          varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师家庭地址',
    `teacher_idcard`           varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老师身份证号码',
    PRIMARY KEY (`teacher_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher_password
-- ----------------------------
DROP TABLE IF EXISTS `teacher_password`;
CREATE TABLE `teacher_password`
(
    `teacher_no`       bigint NOT NULL COMMENT '老师编号',
    `teacher_password` varchar(66) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师登录密码，散列值',
    PRIMARY KEY (`teacher_no`) USING BTREE,
    CONSTRAINT `teacher_no` FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET
FOREIGN_KEY_CHECKS = 1;
