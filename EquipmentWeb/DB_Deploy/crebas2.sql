/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/12/25 16:44:09                          */
/*==============================================================*/


drop table if exists dbeqp.eqmt_event_association;

/*==============================================================*/
/* Table: CNTR_ISO_TYPE                                         */
/*==============================================================*/
create table dbeqp.CNTR_ISO_TYPE
(
   ISO_CDE              char(4) not null,
   GROUP_CDE            char(4),
   DESCRIPTION          varchar(50),
   primary key (ISO_CDE)
);

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
/* Table: EQMT_EVENT_ASSOCIATION                                */
/*==============================================================*/
create table dbeqp.EQMT_EVENT_ASSOCIATION
(
   EVENT_TIMESTAMP      char(32) not null,
   EQMT_NUM             varchar(10),
   SEQ_NUM              int,
   LOC                  char(5),
   EVENT_DT_LOC         datetime,
   EVENT_TYPE           char(2),
   EQMT_TYPE_GRP_CDE    char(4),
   EQMT_TYPE_CDE        char(4),
   MATERIAL             varchar(20),
   primary key (EVENT_TIMESTAMP)
);

/*==============================================================*/
/* Table: EQP_EVENT_LOG                                         */
/*==============================================================*/
create table dbeqp.EQP_EVENT_LOG
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
   CNTR_COND            int,
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
   FACILITY             char(5) not null,
   OFFICE               char(3) not null,
   REGION               varchar(20) not null,
   REG_CDE              char(4),
   TERRITORY            char(3) not null,
   REC_UPD_DT           datetime,
   primary key (FACILITY)
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

alter table dbeqp.EQMT_EVENT_ASSOCIATION add constraint FK_Reference_4 foreign key (LOC)
      references dbeqp.EQP_SUPPLY_HIERARCHY (FACILITY) on delete restrict on update restrict;

alter table dbeqp.EQP_EVENT_LOG add constraint FK_Reference_3 foreign key (FCIL_CDE)
      references dbeqp.EQP_SUPPLY_HIERARCHY (FACILITY) on delete restrict on update restrict;

alter table dbeqp.EQP_LATEST_INFO add constraint FK_Reference_2 foreign key (EQMT_NUM)
      references dbeqp.CONTAINER (EQMT_NUM) on delete restrict on update restrict;

