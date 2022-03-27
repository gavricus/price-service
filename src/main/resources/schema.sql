create table if not exists prices(
  id bigint auto_increment primary key,/*added explicit id field to avoid all columns compound PK*/
  brand_id bigint not null,
  start_date timestamp with time zone not null,
  end_date timestamp with time zone not null,
  price_list bigint not null,
  product_id bigint not null,
  priority tinyint not null default 0,
  price integer not null, /*opted for integer prices (multiplied by 100) to avoid rounding problems*/
  curr varchar(4) not null
  );
