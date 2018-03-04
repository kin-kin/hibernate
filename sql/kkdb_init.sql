SET CLIENT_ENCODING TO 'UTF8';

BEGIN;

INSERT INTO account_role (name, create_date, update_date) VALUES ('Administrators', current_timestamp, current_timestamp);
INSERT INTO account (id, password, name, role_id, create_date, update_date) VALUES ('admin', 'admin', 'Administrator', (SELECT account_role_id FROM account_role WHERE account_role.name = 'Administrators'), current_timestamp, current_timestamp);

COMMIT;