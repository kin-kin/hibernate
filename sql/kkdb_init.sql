SET CLIENT_ENCODING TO 'UTF8';

BEGIN;

INSERT INTO account_role (name, create_date, update_date) VALUES ('Administrators', current_timestamp, current_timestamp);
INSERT INTO account (account_id, account_role_record_id, password, name, create_date, update_date) VALUES ('admin', (SELECT record_id FROM account_role WHERE account_role.name = 'Administrators'), 'admin', 'Administrator', current_timestamp, current_timestamp);

COMMIT;