#drop table if exists gi_urlmapping;
create table gi_urlmapping
(
	id varchar(128),
	url varchar(128),
	type varchar(128),
	enabled int default 0,
	content varchar(8196),
	updated bigint,
	created bigint
);
create unique index gi_urlmapping_index_id on gi_urlmapping(id);
create index gi_urlmapping_index_url on gi_urlmapping(url);
create index gi_urlmapping_index_enabled on gi_urlmapping(enabled);
