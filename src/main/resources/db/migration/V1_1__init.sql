------------------------------------------------------------------
--  TABLE tActivity
------------------------------------------------------------------

CREATE TABLE `tActivity`
(
   `activityPK`             varchar(12),
   `projectPK`              varchar(12),
   title                    varchar(100),
   contents                 text,
   `assignedQaId`           varchar(15),
   `importanceDegree`       varchar(10),
   `deployCategory`         varchar(10),
   status                   varchar(10),
   `activityStartDate`      datetime,
   `activityEndDate`        datetime,
   `expectedCompleteDate`   datetime,
   `creatorId`              varchar(20),
   `createdDate`            datetime,
   `modifierId`             varchar(20),
   `modifiedDate`           datetime,
   `tProject_projectPK`     varchar(12)
);



------------------------------------------------------------------
--  TABLE tJob
------------------------------------------------------------------

CREATE TABLE `tJob`;


------------------------------------------------------------------
--  TABLE tProject
------------------------------------------------------------------

CREATE TABLE `tProject`
(
   `projectPK`      varchar(12),
   `projectKey`     varchar(10),
   `projectName`    varchar(45),
   `managerId`      varchar(45),
   category         varchar(45),
   `creatorId`      varchar(45),
   `createdDate`    datetime,
   `modifierId`     varchar(45),
   `modifiedDate`   datetime
);



------------------------------------------------------------------
--  TABLE tTemplate
------------------------------------------------------------------

CREATE TABLE `tTemplate`
(
   `activityPK`     varchar(20),
   `templatePK`     varchar(20),
   `rowNumber`      int(11),
   `colNumber`      int(11),
   contents         text,
   `assignedId`     varchar(20),
   `creatorId`      varchar(20),
   `createdDate`    datetime,
   `modifierId`     varchar(20),
   `modifiedDate`   datetime
);


------------------------------------------------------------------
--  TABLE tTestEnvironment
------------------------------------------------------------------

CREATE TABLE `tTestEnvironment`
(
   `activityPK`          varchar(20),
   `templatePK`          varchar(20),
   `templateRowNumber`   int(11),
   `testTarget`          varchar(45),
   `testResult`          varchar(20),
   `creatorId`           varchar(20),
   `createdDate`         datetime,
   `modifierId`          varchar(20),
   `modifiedDate`        datetime,
   `tJob_jobPK`          varchar(12),
   `tJob_activityPK`     varchar(12),
   `tJob_templatePK`     varchar(12)
);


------------------------------------------------------------------
--  TABLE tUser
------------------------------------------------------------------

CREATE TABLE tUser
(
   userNo           int(11),
   userStatusCode   varchar(10),
   name               varchar(45),
   userId           varchar(45),
   userPassword     varchar(100),
   emailAddress     varchar(100),
   companyName      varchar(100),
   creatorId        varchar(45),
   createdDate      datetime,
   modifierId       varchar(45),
   modifiedDate     datetime
);

INSERT INTO tuser 
            (userno,userstatuscode,name,userid,userpassword,emailaddress,companyname,creatorid,createddate,modifierid,modifieddate)
VALUES      (1,'test','백창명1','test1','test1','test1@test.com','tts','test1','2017-03-11 16:26:00.0',NULL,NULL),
			(2,'test','백창명2','test2','test2','test2@test.com','tts','test2','2017-03-11 16:26:00.0',NULL,NULL),
			(3,'test','백창명3','test3','test3','test3@test.com','tts','test3','2017-03-11 16:26:00.0',NULL,NULL),
			(4,'test','백창명4','test4','test4','test4@test.com','tts','test4','2017-03-11 16:26:00.0',NULL,NULL),
			(5,'test','백창명5','test5','test5','test5@test.com','tts','test5','2017-03-11 16:26:00.0',NULL,NULL); 



