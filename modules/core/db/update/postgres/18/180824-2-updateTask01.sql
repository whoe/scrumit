alter table SCRUMIT_TASK add constraint FK_SCRUMIT_TASK_ON_TRACKER foreign key (TRACKER_ID) references SCRUMIT_TRACKER(ID);
create index IDX_SCRUMIT_TASK_ON_TRACKER on SCRUMIT_TASK (TRACKER_ID);
