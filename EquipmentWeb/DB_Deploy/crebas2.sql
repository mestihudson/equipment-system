/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/11/19 22:39:48                          */
/*==============================================================*/


drop table if exists dbeqp.CONTAINER;

drop table if exists EQP_EVENT_LOG;

drop table if exists dbeqp.EQP_LATEST_INFO;

drop table if exists dbeqp.EQP_REJECTION;

drop table if exists dbeqp.EQP_SUPPLY_HIERARCHY;

drop table if exists dbeqp.GSP_CITY;

drop table if exists dbeqp.GSP_FACILITY;

drop table if exists dbeqp.GSP_OFFICE;

/*==============================================================*/
/* Table: CONTAINER                                             */
/*==============================================================*/
create table dbeqp.CONTAINER
(
   EQMT_NUM             varchar(10) not null,
   ISO_CDE              char(4) not null,
   GROUP_CDE            char(4) not null,
   CHK_DIGIT            char(1) not null,
   STATE                boolean not null,
   CREATE_DT            timestamp,
   UPDATE_DT            timestamp,
   primary key (EQMT_NUM)
);

/*==============================================================*/
/* Table: EQP_EVENT_LOG                                         */
/*==============================================================*/
create table EQP_EVENT_LOG
(
   EVENT_TIMESTAMP      char(32) not null,
   EVENT_CRE_DT         datetime not null,
   FCIL_CDE             char(5)  not null,
   EVENT_TYPE           char(2) not null,
   EVENT_DT_LOC         datetime  not null,
   CNTR_NUM             varchar(10) not null,
   CNTR_CHK_DIGIT       tinyint,
   SEAL_NUM             varchar(12),
   SEAL_TYPE            char(2),
   CNTR_GRP_CDE         char(4),
   LOAD_EMPTY_IND       char(1),
   SVC_LOOP             varchar(4),
   VSL_CDE              varchar(3),
   VOY_NUM              varchar(3),
   DIR_BOUND            varchar(5),
   LOAD_PORT            varchar(3),
   DSGH_PORT            varchar(3),
   NEXT_LOCA            varchar(5),
   DOC_REF              varchar(12),
   DOC_TYPE             char(2),
   GROSS_WT             numeric(7,2),
   GROSS_WT_UNIT        enum('LBS','KT','KGS'),
   CNTR_COND            varchar(1),
   HZ_IND               boolean,
   REMARKS              blob,
   CONTRA_ACTION        char(1),
   POS_AT_ROUTE         char(2),
   NATURE               char(2),
   UPD_USER             varchar(16),
   REC_UPD_DT           datetime,
   primary key (EVENT_TIMESTAMP)
);

/*==============================================================*/
/* Table: EQP_LATEST_INFO                                       */
/*==============================================================*/
create table dbeqp.EQP_LATEST_INFO
(
   EQMT_NUM             varchar(10) not null,
   EQMT_TYPE            CHAR(1) not null,
   EVENT_TYPE           char(2) not null,
   REC_UPD_DT           datetime,
   primary key (EQMT_NUM)
);

/*==============================================================*/
/* Table: EQP_REJECTION                                         */
/*==============================================================*/
create table dbeqp.EQP_REJECTION
(
   UUID                 char(32)
);

/*==============================================================*/
/* Table: EQP_SUPPLY_HIERARCHY                                  */
/*==============================================================*/
create table dbeqp.EQP_SUPPLY_HIERARCHY
(
   FCIL_CDE             char(5) not null,
   REG_CDE              char(3) not null,
   OFCE_CDE             char(3) not null,
   TERRITORY            char(3) not null,
   REC_UPD_DT           datetime,
   primary key (FCIL_CDE)
);

/*==============================================================*/
/* Table: GSP_CITY                                              */
/*==============================================================*/
create table dbeqp.GSP_CITY
(
   CODE                 char(32) not null,
   ENGLISH_NAME         char(60),
   LOCAL_NAME           char(60),
   REC_UPD_DT           datetime,
   primary key (CODE)
);

/*==============================================================*/
/* Table: GSP_FACILITY                                          */
/*==============================================================*/
create table dbeqp.GSP_FACILITY
(
   CODE                 char(5) not null,
   NAME                 varchar(25),
   TYPE                 smallint,
   EFF_DT               date,
   EXP_DT               date,
   REC_UPD_DT           datetime,
   primary key (CODE)
);

/*==============================================================*/
/* Table: GSP_OFFICE                                            */
/*==============================================================*/
create table dbeqp.GSP_OFFICE
(
   CODE                 char(3) not null,
   TYPE                 char(1),
   REC_UPD_DT           char(10),
   primary key (CODE)
);

alter table EQP_EVENT_LOG add constraint FK_Reference_3 foreign key (FCIL_CDE)
      references dbeqp.EQP_SUPPLY_HIERARCHY (FCIL_CDE) on delete restrict on update restrict;

alter table dbeqp.EQP_LATEST_INFO add constraint FK_Reference_2 foreign key (EQMT_NUM)
      references dbeqp.CONTAINER (EQMT_NUM) on delete restrict on update restrict;

