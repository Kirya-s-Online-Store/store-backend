FROM postgres:15-alpine

ADD /database/script/init.sql /docker-entrypoint-initdb.d
ADD /database/script/data.sql /docker-entrypoint-initdb.d