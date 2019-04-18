create table items (
  id SERIAL primary key not null,
  name VARCHAR(255),
  descr VARCHAR(255),
  created BIGINT,
  comments VARCHAR(1000)
);