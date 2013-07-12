CREATE TABLE user_roles (
    email varchar(100) not null primary key references users(email),
    role varchar(20),
    created_at timestamp(0) with time zone NOT NULL,
    updated_at timestamp(0) with time zone NOT NULL
);

CREATE UNIQUE INDEX index_user_roles_on_email_and_role
  ON user_roles
  USING btree
  (email, role);