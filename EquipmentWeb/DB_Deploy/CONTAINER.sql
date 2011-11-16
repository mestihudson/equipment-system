connect 'jdbc:derby://localhost:1527/eqp;create=true;user=admin;password=admin_ps;';
drop table if exists CONTAINER;

/*==============================================================*/
/* Table: CONTAINER                                             */
/*==============================================================*/
create table CONTAINER
(
   EQMT_NUM             varchar(11) not null,
   ISO_CDE              char(4) not null,
   GROUP_CDE            char(4) not null,
   STATE                varchar(8) not null,
   CREATE_DT            timestamp,
   UPDATE_DT            timestamp,
   primary key (EQMT_NUM)
);
