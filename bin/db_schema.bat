@echo off

call .\db_config.bat
call .\db_create.bat

psql -h %PGHOST% ^
     -p %PGPORT% ^
     -U %PGUSER% ^
     -d %DB% ^
     -f ..\sql\kkdb.sql

psql -h %PGHOST% ^
     -p %PGPORT% ^
     -U %PGUSER% ^
     -d %DB% ^
     -f ..\sql\kkdb_init.sql