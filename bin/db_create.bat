@echo off

call .\db_config.bat
call .\db_drop.bat

psql -h %PGHOST% ^
     -p %PGPORT% ^
     -U %PGUSER% ^
     -f ..\sql\create.sql ^
     -v DB=%DB% ^
     -v DBUSER=%DBUSER% ^
     -v DBPASSWORD='%DBPASSWORD%'