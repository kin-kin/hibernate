@echo off

call .\db_config.bat
call .\db_create.bat

set PGPASSWORD=%DBPASSWORD%

psql -h %PGHOST% ^
     -p %PGPORT% ^
     -U %DBUSER% ^
     -d %DB% ^
     -f ..\sql\kkdb.sql

psql -h %PGHOST% ^
     -p %PGPORT% ^
     -U %DBUSER% ^
     -d %DB% ^
     -f ..\sql\kkdb_init.sql