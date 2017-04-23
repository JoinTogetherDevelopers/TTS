------------------------------------------------------------------
--  TABLE tActivity
------------------------------------------------------------------

CREATE TABLE tActivity
(
   activityPK             varchar(12),
   projectPK              varchar(12),
   title                    varchar(100),
   contents                 text,
   assignedQaId           varchar(15),
   importanceDegree       varchar(10),
   deployCategory         varchar(10),
   status                   varchar(10),
   activityStartDate      datetime,
   activityEndDate        datetime,
   expectedCompleteDate   datetime,
   creatorId              varchar(20),
   createdDate            datetime,
   modifierId             varchar(20),
   modifiedDate           datetime,
   tProject_projectPK     varchar(12)
);



------------------------------------------------------------------
--  TABLE tJob
------------------------------------------------------------------

CREATE TABLE tJob;


------------------------------------------------------------------
--  TABLE tProject
------------------------------------------------------------------

CREATE TABLE tProject
(
   projectPK      varchar(12),
   projectKey     varchar(10),
   projectName    varchar(45),
   managerId      varchar(45),
   category         varchar(45),
   creatorId      varchar(45),
   createdDate    datetime,
   modifierId     varchar(45),
   modifiedDate   datetime
);



------------------------------------------------------------------
--  TABLE tTemplate
------------------------------------------------------------------

CREATE TABLE tTemplate
(
   activityPK     varchar(20),
   templatePK     varchar(20),
   rowNumber      int(11),
   colNumber      int(11),
   contents         text,
   assignedId     varchar(20),
   creatorId      varchar(20),
   createdDate    datetime,
   modifierId     varchar(20),
   modifiedDate   datetime
);


------------------------------------------------------------------
--  TABLE tTestEnvironment
------------------------------------------------------------------

CREATE TABLE tTestEnvironment
(
   activityPK          varchar(20),
   templatePK          varchar(20),
   templateRowNumber   int(11),
   testTarget          varchar(45),
   testResult          varchar(20),
   creatorId           varchar(20),
   createdDate         datetime,
   modifierId          varchar(20),
   modifiedDate        datetime,
   tJob_jobPK          varchar(12),
   tJob_activityPK     varchar(12),
   tJob_templatePK     varchar(12)
);


------------------------------------------------------------------
--  TABLE tUser
------------------------------------------------------------------

CREATE TABLE tUser
(
   userNo           int(11),
   userStatusCode   varchar(10),
   name             varchar(45),
   userid           varchar(45),
   userPassword     varchar(100),
   emailAddress     varchar(100),
   companyName      varchar(100),
   creatorId        varchar(45),
   createdDate      datetime,
   modifierId       varchar(45),
   modifiedDate     datetime,
   isAccountNonExpired boolean,
   isAccountNonLocked boolean,
   isCredentialsNonExpired boolean,
   isEnabled boolean

);

create table authority (
    userid varchar(20),
    authority_name varchar(20)
);


/* Insert Mock Data */

insert into tProject  values (1, '71-2624250', 'Y-Solowarm', 'Gittus', 'unesco.org', 'test1', '2016-08-26 08:27:44', 'ProinRisus.ppt', '2017-01-30 06:21:41');
insert into tProject  values (2, '67-2098140', 'Bitchip', 'Gumme', 'wikia.com', 'FF-AA-14-29-33-A0', '2017-02-10 06:53:53', 'Ipsum.ppt', '2016-08-26 20:06:29');
insert into tProject  values (3, '97-4003239', 'Otcom', 'Ethersey', 'nhs.uk', '90-21-A3-E0-FD-8D', '2016-04-28 00:18:42', 'NecSemDuis.tiff', '2017-03-03 13:21:03');
insert into tProject  values (4, '77-0034334', 'Pannier', 'Ratke', 'mtv.com', '83-60-9A-48-26-80', '2017-04-10 12:51:57', 'Sapien.png', '2016-11-03 07:07:08');
insert into tProject  values (5, '38-6220228', 'Pannier', 'Rochford', '360.cn', '26-9E-40-3E-33-E5', '2016-06-28 16:41:47', 'Sed.jpeg', '2016-11-13 09:26:30');
insert into tProject  values (6, '61-6717400', 'Otcom', 'McCerery', 'flickr.com', 'D1-06-A3-F2-ED-9E', '2017-02-10 20:39:45', 'PosuereCubilia.mp3', '2016-08-17 17:57:27');
insert into tProject  values (7, '03-9847070', 'Zontrax', 'Kobke', 'upenn.edu', 'E7-EA-30-B6-17-6E', '2016-05-11 10:22:10', 'Facilisi.ppt', '2016-08-24 22:51:11');
insert into tProject  values (8, '81-3804297', 'Wrapsafe', 'Hastwell', 'java.com', 'D0-63-30-77-EC-62', '2017-02-01 06:57:06', 'Auctor.jpeg', '2016-08-31 12:28:55');
insert into tProject  values (9, '67-9632670', 'Transcof', 'Stollmeier', 'ustream.tv', '87-1B-D5-E2-C1-E0', '2016-10-13 02:44:29', 'LectusPellentesque.mp3', '2016-06-17 22:46:56');
insert into tProject  values (10, '28-9476419', 'Domainer', 'Larose', '360.cn', 'D9-5D-41-87-66-12', '2017-04-07 12:36:04', 'SapienVarius.mp3', '2016-05-21 09:29:07');
insert into tProject  values (11, '74-6003574', 'Fix San', 'Hateley', 'washingtonpost.com', '42-A8-12-79-AE-6C', '2016-09-06 00:41:48', 'PurusEuMagna.txt', '2016-11-09 06:04:45');
insert into tProject  values (12, '67-1045846', 'Matsoft', 'Gradon', 'quantcast.com', '8F-CE-D3-63-69-01', '2017-01-26 14:56:03', 'Sit.avi', '2016-11-25 07:24:01');
insert into tProject  values (13, '96-4853017', 'Tempsoft', 'Manuello', 'yellowbook.com', 'BA-9B-B1-71-2A-4F', '2016-06-04 21:50:56', 'SuspendissePotenti.pdf', '2017-03-22 03:30:01');
insert into tProject  values (14, '05-3243335', 'Domainer', 'Coultous', 'mozilla.org', '52-38-11-AA-9B-D2', '2016-06-09 08:35:16', 'IpsumPrimis.xls', '2016-11-20 07:45:46');
insert into tProject  values (15, '90-2166317', 'Lotlux', 'Sange', 'fda.gov', '7F-25-12-A9-55-FC', '2016-08-30 06:11:02', 'NullaSedVel.gif', '2016-08-14 05:57:58');
insert into tProject  values (16, '49-8958365', 'Transcof', 'Brinicombe', 'dmoz.org', 'C8-82-F9-A6-F6-F2', '2016-09-11 16:32:59', 'MattisPulvinar.ppt', '2017-04-16 08:43:39');
insert into tProject  values (17, '22-9319684', 'Zaam-Dox', 'Heynel', 'dot.gov', '47-30-8A-CA-4A-DA', '2016-08-03 20:28:47', 'Etiam.ppt', '2017-02-25 20:44:26');
insert into tProject  values (18, '73-1436568', 'Voyatouch', 'Greenside', 'sun.com', 'B4-4D-AC-7E-FC-51', '2016-10-24 21:52:17', 'PretiumNislUt.ppt', '2016-06-04 19:33:31');
insert into tProject  values (19, '47-5284731', 'Zathin', 'Deyes', 'un.org', 'A8-99-23-64-9B-72', '2016-05-02 03:07:42', 'Ante.ppt', '2017-02-23 10:40:25');
insert into tProject  values (20, '86-1888571', 'Y-find', 'Spikeings', 'discovery.com', '69-2C-05-16-8B-C7', '2017-03-21 22:38:03', 'NisiEu.gif', '2016-08-31 09:18:15');


INSERT INTO tuser 
            (userno,userstatuscode,name,userid,userpassword,emailaddress,companyname,creatorid,createddate,modifierid,modifieddate)
VALUES      (1,'test','백창명1','test1','$2a$10$XT7.fUXyqj/z67FBEI4kVu94wkjH5QYiwlLq40PKOFfEVcTfmns92','test1@test.com','tts','test1','2017-03-11 16:26:00.0',NULL,NULL),
			(2,'test','백창명2','test2','$2a$10$r3lvtjLsLijcvw./YETL/eY8SpZMOnnl1b1CsI.nY9xy4/uZs3n.O','test2@test.com','tts','test2','2017-03-11 16:26:00.0',NULL,NULL),
			(3,'test','백창명3','test3','$2a$10$xLT5Vc.qViB/WcXrI56vs.zjs42e257eEZBYTswnyI9cq0uHyK3G6','test3@test.com','tts','test3','2017-03-11 16:26:00.0',NULL,NULL),
			(4,'test','백창명4','test4','$2a$10$WJCMhY8CZX6YRDttMHqb1.Wqa3ubGc/xk802DvC9cTs0CQflgOcbC','test4@test.com','tts','test4','2017-03-11 16:26:00.0',NULL,NULL),
			(5,'test','백창명5','test5','$2a$10$XLtn17U31BOab1FoPnPREOxsbjUXpm2KtyxvZCFuCJoD.Q6.GNzCu','test5@test.com','tts','test5','2017-03-11 16:26:00.0',NULL,NULL); 
			
INSERT INTO authority (userid, authority_name) VALUES ('test1','USER');
INSERT INTO authority (userid, authority_name) VALUES ('test2','ADMIN');
INSERT INTO authority (userid, authority_name) VALUES ('test3','USER');
INSERT INTO authority (userid, authority_name) VALUES ('test4','USER');
INSERT INTO authority (userid, authority_name) VALUES ('test5','USER');







