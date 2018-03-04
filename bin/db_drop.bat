@echo off

call .\db_config.bat

psql -h %PGHOST% ^
     -p %PGPORT% ^
     -U %PGUSER% ^
     -f ..\sql\drop.sql ^
     -v DB=%DB% ^
     -v DBUSER=%DBUSER%